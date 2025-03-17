package edu.nenu.hisserver.service.impl;

import edu.nenu.hisserver.mapper.EmpMapper;
import edu.nenu.hisserver.pojo.Department;
import edu.nenu.hisserver.pojo.EmpAndWeekRule;
import edu.nenu.hisserver.pojo.Employee;
import edu.nenu.hisserver.pojo.Permit;
import edu.nenu.hisserver.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Employee> getAllEmp(Integer deptmentId, Integer registLevelId, String date, String noon) {
        // 获取满足要求的员工与其排班信息 对象
        List<EmpAndWeekRule> employeeOnWork = empMapper.getAllEmpByDate(deptmentId, registLevelId);
        // 获取日期属于星期几
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate visitDate = LocalDate.parse(date, formatter);
        int dayOfWeek = visitDate.getDayOfWeek().getValue();
        // 计算 weekRule 中的索引位置
        int index = (dayOfWeek % 7) * 2;
        System.out.println("================weekRule index :" + index + "===============");
        if (noon.equals("下午")) {
            index += 1;
        }

        List<Employee> employees = new ArrayList<>();

        for (EmpAndWeekRule empAndWeekRule : employeeOnWork) {
            // 获取 weekRule 的对应位
            char workStatus = empAndWeekRule.getWeekRule().charAt(index);
            if (workStatus == '1') {
                employees.add(empAndWeekRule);
            }
        }
        return employees;
    }

    /**
     * 登录 返回用户相关信息和所有权限
     */
    @Override
    public Employee login(Employee employee) {
        Employee e = empMapper.findByIdAndPassowrd(employee);
        // 查询所有权限
        try {
            List<Permit> permissions = empMapper.findPermitByEmpRoleId(e.getRole());
            // 调用构建树形结构方法
            e.setPermitList(buildPermissionTree(permissions));
            return e;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    // 根据部门类型获取所有员工
    @Override
    public List<Employee> getAllEmpByType(String type) {
        return empMapper.getAllEmpByType(type);
    }

    // 根据部门类型获取所有部门
    @Override
    public List<Department> getAllDeptByType(String type) {
        return empMapper.getAllDeptByType(type);
    }

    @Override
    public List<Employee> getAllEmpByDeptId(Integer deptId) {
        return empMapper.getAllEmpByDeptId(deptId);
    }

    /**
     * 构建树形结构方法 返回权限树
     * @param permissions 所有权限的列表
     */
    public List<Permit> buildPermissionTree(List<Permit> permissions) {
        Map<Integer, Permit> permissionMap = new HashMap<>();
        List<Permit> rootPermissions = new ArrayList<>();

        // 将所有权限放入Map中
        for (Permit permission : permissions) {
            permissionMap.put(permission.getId(), permission);
        }

        // 构建树形结构
        for (Permit permission : permissions) {
            // permit_parent不为空就是模块
            if (permission.getPermitParent() == null) {
                rootPermissions.add(permission);
            } else {
                Permit parent = permissionMap.get(permission.getPermitParent());
                if (parent != null) {
                    if (parent.getChildren() == null) {
                        parent.setChildren(new ArrayList<>());
                    }
                    parent.getChildren().add(permission);
                }
            }
        }
        return rootPermissions;
    }

}

package edu.nenu.hisserver.mapper;

import edu.nenu.hisserver.pojo.Department;
import edu.nenu.hisserver.pojo.EmpAndWeekRule;
import edu.nenu.hisserver.pojo.Employee;
import edu.nenu.hisserver.pojo.Permit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {



    /**
     * 根据部门 挂号级别 查询员工
     */
    List<EmpAndWeekRule> getAllEmpByDate(@Param("deptmentId") Integer deptmentId,@Param("registLevelId") Integer registLevelId);

    /**
     * 根据realname和密码返回员工
     */
    @Select("select * from employee where realname=#{realname} and password=#{password}")
    Employee findByIdAndPassowrd(Employee employee);

    /**
     * 获取所有权限
     */
    List<Permit> findPermitByEmpRoleId(Integer roleId);

    // 根据部门类型获取所有员工
    @Select("select e.id, e.realname, e.password, e.deptment_id, e.regist_level_id, e.scheduling_id, e.role, e.delmark " +
            "from employee e join department d on e.deptment_id=d.id " +
            "where d.dept_type=#{type}")
    List<Employee> getAllEmpByType(String type);

    // 根据部门类型获取所有部门
    @Select("select id, dept_code, dept_name, dept_type, delmark " +
            "from department where dept_type=#{type}")
    List<Department> getAllDeptByType(String type);

    // 根据部门id获取所有员工
    @Select("select * from employee where employee.deptment_id=#{deptId};")
    List<Employee> getAllEmpByDeptId(Integer deptId);
}

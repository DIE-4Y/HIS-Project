package edu.nenu.hisserver.service;

import edu.nenu.hisserver.pojo.Department;
import edu.nenu.hisserver.pojo.Employee;
import edu.nenu.hisserver.pojo.Result;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    public List<Employee> getAllEmp(Integer deptmentId, Integer registLevelId, String date, String noon);

    Employee login(Employee employee);

    List<Employee> getAllEmpByType(String type);

    List<Department> getAllDeptByType(String type);

    List<Employee> getAllEmpByDeptId(Integer deptId);
}

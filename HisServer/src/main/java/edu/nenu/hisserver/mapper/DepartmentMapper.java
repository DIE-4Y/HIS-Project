package edu.nenu.hisserver.mapper;

import edu.nenu.hisserver.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    @Select("select * from department where dept_type='门诊'")
    List<Department> findAllDepartment();
}

package edu.nenu.hisserver.service.impl;

import edu.nenu.hisserver.mapper.DepartmentMapper;
import edu.nenu.hisserver.pojo.Department;
import edu.nenu.hisserver.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> findAllDepartment() {
        return departmentMapper.findAllDepartment();
    }

}

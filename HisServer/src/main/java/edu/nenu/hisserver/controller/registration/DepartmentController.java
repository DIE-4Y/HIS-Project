package edu.nenu.hisserver.controller.registration;

import edu.nenu.hisserver.pojo.Result;
import edu.nenu.hisserver.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/registration")
@CrossOrigin    //跨域请求访问设置
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 返回所有部门信息
     */
    @GetMapping("/findAllDepartment")
    public Result findAllDepartment() {
        log.info("查找所有部门");
        return Result.success(departmentService.findAllDepartment());
    }
}

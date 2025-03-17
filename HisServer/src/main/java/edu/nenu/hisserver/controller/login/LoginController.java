package edu.nenu.hisserver.controller.login;

import edu.nenu.hisserver.pojo.Employee;
import edu.nenu.hisserver.pojo.Result;
import edu.nenu.hisserver.service.EmpService;
import edu.nenu.hisserver.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@CrossOrigin
public class LoginController {

    @Autowired
    private EmpService empService;

    /**
     * 登录获取用户的permit权限
     * data中返回Employee对象
     */
    @PostMapping("/login/employeeLogin")
    public Result login(@RequestBody Employee employee) {
        Employee e = empService.login(employee);
        log.info("登录接口调用{}", employee);
        if (e == null) {
            return Result.error("姓名或密码错误！");
        }
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", e.getId());
        claims.put("name", e.getRealname());
        String jwt = JwtUtils.generateJwt(claims);
        e.setToken(jwt);
        return Result.success(e);
    }
}

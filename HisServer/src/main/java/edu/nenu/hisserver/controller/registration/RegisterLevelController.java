package edu.nenu.hisserver.controller.registration;

import edu.nenu.hisserver.pojo.Result;
import edu.nenu.hisserver.service.RegisterLevelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RequestMapping("/registration")
@CrossOrigin
public class RegisterLevelController {

    @Autowired
    private RegisterLevelService service;

    /**
     * 查询所有号别 -专家 -普通 -主任
     */
    @GetMapping("/findAllRegistLevel")
    public Result list(){
        log.info("正在调用findAllRegistLevel()方法");
        return Result.success(service.findAllRegistLevel());
    }
}

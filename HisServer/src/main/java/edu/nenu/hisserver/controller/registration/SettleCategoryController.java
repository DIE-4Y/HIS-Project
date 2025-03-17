package edu.nenu.hisserver.controller.registration;

import edu.nenu.hisserver.pojo.Result;
import edu.nenu.hisserver.service.SettleCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/registration")
@CrossOrigin
public class SettleCategoryController {

    @Autowired
    private SettleCategoryService settleCategoryService;

    /**
     * 获取所有缴费方式
     */
    @GetMapping("/findAllSettleName")
    public Result findAllSettleName(){
        return Result.success(settleCategoryService.findAllSettleName());
    }
}

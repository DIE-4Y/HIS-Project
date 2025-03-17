package edu.nenu.hisserver.controller.registration;

import edu.nenu.hisserver.pojo.Result;
import edu.nenu.hisserver.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/registration")
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 获取所有在职员工信息
     * @param deptmentId    部门id
     * @param registLevelId 部门级别
     * @param visitDate     挂号日期
     * @param noon          午别：0-上午 1-下午
     */
    @GetMapping("/findAllDutyEmployee")
    public Result getAllEmp(@RequestParam Integer deptmentId,
                            @RequestParam Integer registLevelId,
                            @RequestParam String visitDate,
                            @RequestParam String noon) {
        log.info("获取所有在职员工信息{},{},{},{}", deptmentId, registLevelId, visitDate, noon);
        return Result.success(empService.getAllEmp(deptmentId, registLevelId, visitDate, noon));
    }

}

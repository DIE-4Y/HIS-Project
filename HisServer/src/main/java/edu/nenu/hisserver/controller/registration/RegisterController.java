package edu.nenu.hisserver.controller.registration;

import edu.nenu.hisserver.pojo.IntegerList;
import edu.nenu.hisserver.pojo.PageBean;
import edu.nenu.hisserver.pojo.Register;
import edu.nenu.hisserver.pojo.Result;
import edu.nenu.hisserver.service.CheckRequestService;
import edu.nenu.hisserver.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/registration")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private CheckRequestService checkRequestService;

    /**
     * 添加挂号人员信息
     * 1表示添加成功 0表示添加失败
     */
    @PostMapping("/addRegister")
    public Result update(@RequestBody Register register) {
        log.info("添加挂号人员信息");
        return Result.success(registerService.insert(register));
    }

    /**
     * 修改病人visit状态为已接诊
     */
    @PutMapping("/updateVisitState")
    public Result updateVisitState (@RequestBody Register register){
        log.info("修改visit状态：caseNumber:{}, name:{}",register.getCaseNumber(),register.getRealName());
        registerService.updateVisitState(register, 2);
        return Result.success();
    }

    /**
     * 查询最大病历号
     */
    @GetMapping("/findMaxCaseNumber")
    public Result generateId() {
        log.info("查询最大病历号");
        return Result.success(registerService.getMaxId());
    }

    /**
     * 分页查询 获取所有患者信息
     *
     * @return
     */
    @GetMapping("/findAllRegistersByEmployee")
    public Result getAllRegister(Integer empId, Integer pageNumber, Integer pageSize, String caseNumber, String realName) {
        log.info("分页查询开始empId:{}, pageNumber:{}, pageSize:{}, caseNumber:{}, realName:{}", empId, pageNumber, pageSize, caseNumber, realName);
        return Result.success(registerService.findAllRegistersByEmployee(empId, pageNumber, pageSize, caseNumber, realName, 1));
    }

    /**
     * 根据病历号和姓名模糊查询未缴费项目
     */
    @GetMapping("/getAllMedicalTechnology")
    public Result getAllMedicalTechnology(String caseNumber, String name) {
        List<Map<String, Object>> items = checkRequestService.getAllMedicalTechnology(caseNumber, name, "已开立");
        if (items.isEmpty()) {
            return Result.error("没有找到对应信息");
        } else {
            return Result.success(items);
        }
    }

    /**
     * 修改状态为结算
     */
    @PostMapping("/settlementCheckRequest")
    public Result settlementCheckRequest(@RequestBody List<Integer> checkRequestIdList) {
        log.info("修改缴费状态 ids：{}", checkRequestIdList);
        checkRequestService.settlementCheckRequest(checkRequestIdList);
        return Result.success();
    }
}

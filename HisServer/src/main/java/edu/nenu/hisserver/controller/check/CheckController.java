package edu.nenu.hisserver.controller.check;

import edu.nenu.hisserver.pojo.*;
import edu.nenu.hisserver.service.CheckRequestService;
import edu.nenu.hisserver.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/check")
public class CheckController {

    @Autowired
    private CheckRequestService checkRequestService;

    @Autowired
    private EmpService empService;

    /**
     * 获取所有已看诊人数
     */
    @GetMapping("/getAllCheckedCountById")
    public Result getAllCheckedCount() {
        log.info("获取所有已看诊人数");
        Integer count = checkRequestService.getAllCheckedCount();
        if (count != 0) {
            return Result.success(count);
        } else {
            return Result.error("没有已看诊人");
        }
    }

    /**
     * 获取所有待查看人数
     */
    @GetMapping("/getAllPeopleInLine")
    public Result getAllPeopleInLineCount() {
        log.info("获取所有待看诊人数");
        PageBean peopleInLine = checkRequestService.getAllPeopleInLine();
        System.out.println(peopleInLine);
        if (peopleInLine.getTotal() != 0) {
            return Result.success(peopleInLine);
        } else {
            return Result.error("没有待看诊人");
        }
    }

    /**
     * 根据病历号和姓名模糊查找
     * 还需要查找未缴费药品 -- 暂时还未做
     */
    @GetMapping("/findByCaseNumberAndName")
    public Result findByCaseNumberAndName(String caseNumber, String name, Integer pageSize, Integer pageNumber, String state) {
        log.info("根据病历号和姓名模糊查找开始，caseNumber：{}， name：{}, state:{}:", caseNumber, name, state);
        PageBean pageBean = checkRequestService.findByCaseNumberAndName(caseNumber, name, pageSize, pageNumber, state);
        if(pageBean.getTotal() == 0){
            return Result.error("没有查找到相关人员");
        }else {
            return Result.success(pageBean);
        }
    }

    /**
     * 根据病历号查询医疗项目
     */
    @GetMapping("/findMedicalTechnologyByCaseNumber")
    public Result findMedicalTechnologyByCaseNumber(String caseNumber) {
        log.info("根据病历号查询医疗项目,caseNumber:{}", caseNumber);
        return Result.success(checkRequestService.findMedicalTechnologyByCaseNumber(caseNumber, "已缴费"));
    }

    /**
     * 根据部门类型获取所有员工
     */
    @GetMapping("/getAllEmpByType")
    public Result getAllEmpByType(String deptType) {
        log.info("根据部门类型获取所有员工, deptType:{}", deptType);
        return Result.success(empService.getAllEmpByType(deptType));
    }

    /**
     * 根据部门类型获取所有部门
     */
    @GetMapping("/getAllDeptByType")
    public Result getAllDeptByType(String deptType) {
        log.info("根据部门类型获取所有部门, deptType:{}", deptType);
        return Result.success(empService.getAllDeptByType(deptType));
    }

    /**
     * 根据部门id获取所对应的员工
     */
    @GetMapping("/getAllEmpByDeptId")
    public Result getAllEmpByDeptId(Integer deptId) {
        log.info("根据部门id获取所对应的员工, deptId:{}", deptId);
        return Result.success(empService.getAllEmpByDeptId(deptId));
    }

    /**
     * 提交信息开始检查
     */
    @PostMapping("/startCheck")
    public Result startCheck(@RequestBody StartCheckSubmit startCheckSubmit) {
        log.info("提交信息，开始检查，startCheckSubmit: {}", startCheckSubmit);
        checkRequestService.updateCheckState(startCheckSubmit);
        return Result.success();
    }

    /**
     * 根据病历号，姓名，check_state状态获取素有项目
     */
    @GetMapping("/getAllCheckedMedicalTechnology")
    public Result getAllCheckedMedicalTechnology(String caseNumber, String name) {
        log.info("根据病历号，姓名，check_state状态获取所有项目,caseNumber:{}, name:{}", caseNumber, name);
        List<Map<String, Object>> medicalTechnologyList = checkRequestService.getAllMedicalTechnology(caseNumber, name, "执行完成");
        if (medicalTechnologyList.isEmpty()) {
            return Result.error("没有已检查项目");
        } else {
            return Result.success(medicalTechnologyList);
        }
    }

    /**
     * 修改检查结果
     */
    @PutMapping("/updateInputCheck")
    public Result updateInputCheck(@RequestBody InputCheckRequest inputCheckRequest) {
        log.info("修改检查结果正在执行，registerId:{},empId:{},medicalTechnologyIdList:{},checkResult:{}", inputCheckRequest.getRegisterId(), inputCheckRequest.getEmpId(), inputCheckRequest.getMedicalTechnologyIdList(), inputCheckRequest.getCheckResult());
        checkRequestService.updateInputCheck(inputCheckRequest.getRegisterId(), inputCheckRequest.getEmpId(), inputCheckRequest.getMedicalTechnologyIdList(), inputCheckRequest.getCheckResult());
        return Result.success();
    }
}

package edu.nenu.hisserver.controller.drugstore;

import edu.nenu.hisserver.pojo.*;
import edu.nenu.hisserver.service.DrugstoreService;
import edu.nenu.hisserver.service.PrescriptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/drugstore")
public class DrugstoreController {
    @Autowired
    private DrugstoreService drugstoreService;
    @Autowired
    private PrescriptionService prescriptionService;

    /**
     * 分页查询所有已缴费人员
     */
    @GetMapping("/getAllRegisterByState")
    public Result getAllRegisterByState(String caseNumber, String realName, Integer pageNumber, Integer pageSize) {
        log.info("分页查询所有已缴费人员,caseNumber:{}, realName:{}, pageNumber:{}, pageSize:{}", caseNumber, realName, pageNumber, pageSize);
        PageBean p = drugstoreService.getAllRegisterByState(caseNumber, realName, pageNumber, pageSize, "已缴费");
        if (p.getTotal() == 0) {
            return Result.error("没有找到相应人员");
        } else {
            return Result.success(p);
        }
    }

    /**
     * 根据患者id获取所有已缴费药品
     */
    @GetMapping("/getAllDrugByRegisterId")
    public Result getAllDrugByRegisterId(Integer registerId) {
        log.info("根据患者id获取所有已缴费药品, registerId:{}", registerId);
        List<Map<String, Object>> drugInfoList = drugstoreService.getAllDrugByRegisterId(registerId);
        if (drugInfoList.isEmpty()) {
            return Result.error("该用户没有已缴费药品");
        } else {
            return Result.success(drugInfoList);
        }
    }

    /**
     *  根据registerId和drugId修改为已发药状态
     */
    @PutMapping("/updatePrescriptionState")
    public Result updatePrescriptionState(@RequestBody Prescription prescription){
        prescription.setDrugState("已发药");
        prescriptionService.updatePrescriptionStateByRegisterIdAndDrugId(prescription);
        return Result.success();
    }
}

package edu.nenu.hisserver.controller.physician;

import edu.nenu.hisserver.pojo.*;
import edu.nenu.hisserver.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/Physician")
public class PhysicianController {

    @Autowired
    private RegisterService registerService;
    @Autowired
    private DiseaseService diseaseService;
    @Autowired
    private MedicalRecordService medicalRecordService;
    @Autowired
    private MedicalTechnologyService medicalTechnologyService;
    @Autowired
    private CheckRequestService checkRequestService;
    @Autowired
    private DrugService drugService;
    @Autowired
    private PrescriptionService prescriptionService;

    /**
     * 根据医生id查询今日已看诊人数 -3 表示已看诊 -1表示未看
     */
    @GetMapping("/Register/findAlreadyCountByEmployee")
    public Result getAllCount(Integer id, Integer state) {
        log.info("正在获取看诊人数，状态{}{}", id, state);
        return Result.success(registerService.getAllCountByIdAndState(id, state));
    }

    /**
     * 分页查询--获取所有疾病信息
     */
    @GetMapping("/getAllDisease")
    public Result getAllDisease(Integer id, String diseaseName, Integer pageNumber, Integer pageSize) {
        log.info("分页查询开始diseaseId:{}, diseaseName:{}, pageNumber:{}, pageSize:{}", id, pageNumber, pageSize, diseaseName);
        return Result.success(diseaseService.getAllDisease(id, diseaseName, pageNumber, pageSize));
    }

    /**
     * 分页查询获取检查项目id
     */
    @GetMapping("/MedicalTechnology/findMedicalTechnologyByIdAndName")
    public Result getAllMedicalTechnology(Integer id, String name, Integer pageNumber, Integer pageSize) {
        log.info("检查项目分页查询开始,ID:{},name:{},pageNumber:{}, pageSize:{}", id, name, pageNumber, pageSize);
        return Result.success(medicalTechnologyService.getAllMedicalTechnology(id, name, pageNumber, pageSize));
    }

    /**
     * 1.添加病历并获取病历id
     * 2.添加病历id和疾病id
     */
    @Transactional
    @PostMapping("/MedicalRecordDisease/addMedicalRecordDisease")
    public Result addDiseaseAndMedicalRecord(@RequestBody MyMedicalRecordAndDisease myMedicalRecordAndDisease) {
        try {
            // 添加病历并获取病历id
            log.info("病历表：{}", myMedicalRecordAndDisease.getMedicalRecord());
            Integer medicalRecordId = medicalRecordService.addMedicalRecord(myMedicalRecordAndDisease.getMedicalRecord());

            // 添加病历id和疾病id
            log.info("病历表id：{}疾病ids{}", medicalRecordId, myMedicalRecordAndDisease.getDiseaseIdList().toString());
            medicalRecordService.addMedicalRecordAndDisease(medicalRecordId, myMedicalRecordAndDisease.getDiseaseIdList());

            return Result.success();
        } catch (Exception e) {
            System.out.println(e);
            return Result.error("添加失败");
        }
    }

    /**
     * 添加检查信息CheckRequest
     */
    @PostMapping("/MedicalTechnology/addCheckInfo")
    public Result addCheckInfo(@RequestBody CheckRequest checkRequest) {
        checkRequestService.addCheckInfo(checkRequest);
        return Result.success();
    }

    /**
     * 分页查询所有已接诊病人
     */
    @GetMapping("/getAllRegister")
    public Result getAllDealedRegister(Integer empId, Integer pageNumber, Integer pageSize, String caseNumber, String realName) {
        log.info("获取所有状态为已接诊人员，empId：{}, pageNumber：{}, pageSize：{}, caseNumber：{}, realName：{},", empId, pageNumber, pageSize, caseNumber, realName);
        PageBean p = (registerService.findAllRegistersByEmployee(empId, pageNumber, pageSize, caseNumber, realName, 2));
        if (p.getRows().isEmpty()) {
            return Result.error("没有已接诊人员");
        } else {
            return Result.success(p);
        }
    }


    /**
     * 根据所有caseNumber查找所有已出结果检查项目
     */
    @GetMapping("/getAllMedicalTechnology")
    public Result getAllMedicalTechnology(String caseNumber) {
        log.info("根据所有caseNumber查找所有已出结果检查项目，caseNumber：{}", caseNumber);
        List<MedicalTechnology> medicalTechnologyList = checkRequestService.findMedicalTechnologyByCaseNumber(caseNumber, "已出结果");
        if (medicalTechnologyList.isEmpty()) {
            return Result.error("没有已出结果的项目");
        } else {
            return Result.success(medicalTechnologyList);
        }
    }

    /**
     * 根据registerId查找所有已出结果项目细节
     */
    @GetMapping("/getAllMedicalTechnologyDetail")
    public Result getAllMedicalTechnologyDetail(Integer registerId, Integer medicalTechnologyId) {
        log.info("根据caseNumber查找所有已出结果项目细节,caseNumber：{},medicalTechnologyId：{}", registerId, medicalTechnologyId);
        return Result.success(checkRequestService.getAllMedicalTechnologyDetail(registerId, medicalTechnologyId, "已出结果"));
    }

    /**
     * 根据registerId更新MedicalRecord
     */
    @PutMapping("/updateDiagnosisAndCure")
    public Result updateDiagnosisAndCure(@RequestBody MedicalRecord medicalRecord) {
        log.info("提交确诊信息,diagnosis:{},cure:{}", medicalRecord.getDiagnosis(), medicalRecord.getCure());
        medicalRecordService.updateMedicalRecord(medicalRecord);
        return Result.success();
    }

    /**
     * 根据名称和记助码分页查询药品
     */
    @GetMapping("/getAllDrug")
    public Result getAllDrug(String drugName, String drugCode, Integer pageSize, Integer pageNumber) {
        log.info("根据名称和记助码获取药品，drugName:{},drugCode:{},pageSize:{},pageNumber:{}", drugName, drugCode, pageSize, pageNumber);
        PageBean drugInfoList = drugService.getAllDrug(drugName, drugCode, pageSize, pageNumber);
        if (drugInfoList.getTotal() == 0) {
            return Result.error("没找到对应的药品");
        } else {
            return Result.success(drugInfoList);
        }

    }

    /**
     * 插入prescription表
     */
    @PostMapping("/insertPrescription")
    public Result insertPrescription(@RequestBody List<Prescription> prescriptionList) {
        log.info("插入开立处方，prescriptionList：{}",prescriptionList);
        prescriptionService.insert(prescriptionList);
        return Result.success();
    }
}

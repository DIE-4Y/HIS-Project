import request from '@/utils/request.js'
import { ca } from 'element-plus/es/locales.mjs';


// 获取所有疾病
export function getAllDiseaseService(pageInfo) {
    return request.get("/Physician/getAllDisease", { params: pageInfo })
}

// 添加病历id和病历表
export function addMedicalRecordDiseaseService(medicalRecord, diseaseIdList) {
    const data = {
        medicalRecord: medicalRecord,
        diseaseIdList: diseaseIdList
    };
    return request.post("/Physician/MedicalRecordDisease/addMedicalRecordDisease", data)
}

// 获取所有检查项目
export function getAllMedicalTechnologyService(pageInfo) {
    return request.get("/Physician/MedicalTechnology/findMedicalTechnologyByIdAndName", { params: pageInfo })
}

// 添加检查信息
export function addCheckRequestService(checkRequest) {
    return request.post("/Physician/MedicalTechnology/addCheckInfo", checkRequest)
}

// 获取所有状态为已接诊人员的病人
export function getAllRegisterService(empId, pageNumber, pageSize, caseNumber, realName) {
    return request.get('/Physician/getAllRegister', { params: { empId: empId, pageNumber: pageNumber, pageSize: pageSize, caseNumber: caseNumber, realName: realName } })
}

// 根据所有caseNumber查找所有已出结果检查项目
export function getAllMedicalTechnologyServiceChecked(caseNumber) {
    return request.get('/Physician/getAllMedicalTechnology', { params: { caseNumber: caseNumber } })
}

// 根据病人id查询已出结果的详细信息
export function getAllMedicalTechnologyDetailService(registerId, medicalTechnologyId) {
    return request.get('/Physician/getAllMedicalTechnologyDetail', { params: { registerId: registerId, medicalTechnologyId: medicalTechnologyId } })
}

// 提交诊断结果
export function updateDiagnosisAndCureService(medicalRecord) {
    return request.put('/Physician/updateDiagnosisAndCure', medicalRecord)
}

// 根据名称和记助码分页查询药品
export function getAllDrugService(drugName, drugCode, pageSize, pageNumber) {
    return request.get('/Physician/getAllDrug', { params: { drugName: drugName, drugCode: drugCode, pageSize: pageSize, pageNumber: pageNumber } })
}

// 开立处方插入prescription表
export function insertPrescriptionService(prescriptionList) {
    return request.post('/Physician/insertPrescription', prescriptionList)
}
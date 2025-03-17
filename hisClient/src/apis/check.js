import request from '@/utils/request.js'

// 获取所有已看诊人数
export function getAllCheckedCountService() {
    return request.get('/check/getAllCheckedCountById')
}

// 获取所有待看诊人数
export function getAllPeopleInLineService() {
    return request.get('/check/getAllPeopleInLine')
}

// // 模糊查询所有待看诊人数
// export function findByCaseNumberAndNameService(caseNumber, name, state) {
//     return request.get('/check/findByCaseNumberAndName', { params: { caseNumber: caseNumber, name: name, state: state } })
// }

// 模糊查询所有待看诊人数
export function findByCaseNumberAndNameService(caseNumber, name, pageSize, pageNumber, state) {
    return request.get('/check/findByCaseNumberAndName', { params: { caseNumber: caseNumber, name: name, pageSize: pageSize, pageNumber: pageNumber, state: state } })
}

// 获取检验项目
export function findMedicalTechnologyByCaseNumberService(caseNumber) {
    return request.get('/check/findMedicalTechnologyByCaseNumber', { params: { caseNumber: caseNumber } })
}

// 根据部门类型获取所有员工
export function getAllEmpByTypeService(deptType) {
    return request.get('/check/getAllEmpByType', { params: { deptType: deptType } })
}

// 根据部门类型获取所有部门
export function getAllDeptByTypeService(deptType) {
    return request.get('/check/getAllDeptByType', { params: { deptType: deptType } })
}

// 根据部门id获取所对应的员工
export function getAllEmpByDeptIdService(deptId) {
    return request.get('/check/getAllEmpByDeptId', { params: { deptId: deptId } })
}

// 提交信息开始检查
export function startCheckService(startCheckSubmit) {
    return request.post('/check/startCheck', startCheckSubmit)
}

// 获取所有未交费项目
export const getAllMedicalTechnologyService = (caseNumber, name) => {
    return request.get('/check/getAllCheckedMedicalTechnology', { params: { caseNumber: caseNumber, name: name } });
}

// 提交检查
export const updateInputCheckService = (registerId, empId, medicalTechnologyIdList, checkResult) => {
    return request.put('check/updateInputCheck', {
        registerId: registerId,
        empId: empId,
        medicalTechnologyIdList: medicalTechnologyIdList,
        checkResult: checkResult
    })
}
import request from '@/utils/request.js'

// 获取所有部门
export function findAllDepartmentService() {
    //发送异步请求 令前端等待
    return request.get('registration/findAllDepartment');
}

// 获取所有号别
export function findAllSettleNameService() {
    return request.get('/registration/findAllSettleName');
}

// 获取所有挂号级别
export function findAllRegistLevelService() {
    return request.get('registration/findAllRegistLevel');
}

// 获取最大号别
export function findMaxCaseNumberService() {
    return request.get('/registration/findMaxCaseNumber');
}

// 发送请求获取所有在职医生的信息
export function findAllDutyEmployeeService(deptmentId, registLevelId, visitDate, noon) {
    return request.get('registration/findAllDutyEmployee', { params: { deptmentId: deptmentId, registLevelId: registLevelId, visitDate: visitDate, noon: noon } });
}

// 添加患者挂号信息
export function addRegisterService(register){
    return request.post('/registration/addRegister', register);
}

// 修改visitState为已接诊
export function updateVisitStateService(caseNumber, realName) {
    let data = {
        caseNumber: caseNumber,
        realName: realName
    }
    return request.put('registration/updateVisitState', data)
}

// 登录 获取用户所有信息
export const empLoginService = (loginData) => {
    return request.post('/login/employeeLogin', loginData);
}

// 获取已看诊人数
export const getAllCountService = (empid, state) => {
    return request.get('/Physician/Register/findAlreadyCountByEmployee', { params: { id: empid, state: state } });
}

// 模糊查询看诊人员
export const getAllRegister = (pageInform) => {
    return request.get('/registration/findAllRegistersByEmployee', { params: pageInform })
}

// 获取所有未交费项目
export const getAllMedicalTechnologyService = (caseNumber, name) => {
    return request.get('/registration/getAllMedicalTechnology', { params: { caseNumber: caseNumber, name: name } });
}

// 修改缴费状态
export const updateCheckRequestService = (checkRequestIdList) => {
    return request.post('/registration/settlementCheckRequest', checkRequestIdList)
}
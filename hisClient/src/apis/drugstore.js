import request from '@/utils/request.js'

// 分页查询所有已缴费人员
export function getAllRegisterByStateService(caseNumber, realName, pageNumber, pageSize) {
    return request.get('/drugstore/getAllRegisterByState', { params: { caseNumber: caseNumber, realName: realName, pageNumber: pageNumber, pageSize: pageSize } });
};

// 根据患者id获取所有已缴费药品
export function getAllDrugByRegisterIdService(registerId) {
    return request.get('/drugstore/getAllDrugByRegisterId', { params: { registerId: registerId } });
};

// 根据registerId和drugId修改为已发药状态
export function updatePrescriptionStateService(prescription){
    return request.put('/drugstore/updatePrescriptionState',prescription);
};
package edu.nenu.hisserver.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import edu.nenu.hisserver.mapper.CheckRequestMapper;
import edu.nenu.hisserver.pojo.*;
import edu.nenu.hisserver.service.CheckRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CheckRequestServiceImpl implements CheckRequestService {

    @Autowired
    private CheckRequestMapper checkRequestMapper;

    @Override
    public void update(Integer id, String checkState) {
        checkRequestMapper.updateState(id, checkState);
    }

    @Override
    public void addCheckInfo(CheckRequest checkRequest) {
        checkRequest.setCreationTime(LocalDateTime.now());
        checkRequest.setCheckState("已开立");
        checkRequestMapper.insertCheckRequestInfo(checkRequest);
    }

    /**
     * 根据caseNumber和check_state状态获取所有项目
     */
    @Override
    public List<Map<String, Object>> getAllMedicalTechnology(String caseNumber, String name, String state) {
        return checkRequestMapper.getAllMedicalTechnology(caseNumber, name, state);
    }

    /**
     * 修改缴费状态
     */
    @Override
    public void settlementCheckRequest(List<Integer> checkRequestIdList) {

        checkRequestMapper.updateSettlementState(checkRequestIdList, "已缴费");
    }

    // 根据id获取所有已看诊人数
    @Override
    public Integer getAllCheckedCount() {
        // 获取当前日期的起始时间和结束时间
        LocalDate targetDate = LocalDate.now();
        LocalDateTime startOfDay = targetDate.atStartOfDay();
        LocalDateTime endOfDay = targetDate.plusDays(1).atStartOfDay();
        String state = "执行完成";
        return checkRequestMapper.getAllCheckedCount(state, startOfDay, endOfDay);
    }

    // 获取所有排队人员
    @Override
    public PageBean getAllPeopleInLine() {
        String state = "已缴费";
        List<Register> registerList = checkRequestMapper.getAllPeopleInLine(state);
        return new PageBean((long) registerList.size(), registerList);
    }

    @Override
    public PageBean findByCaseNumberAndName(String caseNumber, String name, Integer pageSize, Integer pageNumber, String state) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Register> registerList = checkRequestMapper.findByCaseNumberAndName(caseNumber, name, state);
        Page<Register> p = (Page<Register>) registerList;
        PageBean pList = new PageBean(p.getTotal(), p.getResult());
        return pList;
    }

    @Override
    public List<MedicalTechnology> findMedicalTechnologyByCaseNumber(String caseNumber, String state) {
        return checkRequestMapper.findMedicalTechnologyByCaseNumber(caseNumber, state);
    }

    @Override
    public void updateCheckState(StartCheckSubmit startCheckSubmit) {
        startCheckSubmit.setCheckTime(LocalDateTime.now());
        checkRequestMapper.updateCheckState(startCheckSubmit);
    }

    // 修改再次确认状态
    @Override
    public void updateInputCheck(Integer registerId, Integer empId, List<Integer> medicalTechnologyIdList, String checkResult) {
        checkRequestMapper.updateInputCheck(registerId, empId, medicalTechnologyIdList, checkResult);
    }

    // 获取所有状态为已出结果的项目详细信息
    @Override
    public Map<String, Object> getAllMedicalTechnologyDetail(Integer registerId, Integer medicalTechnologyId, String checkState) {
        return checkRequestMapper.getAllMedicalTechnologyDetail(registerId, medicalTechnologyId, checkState);
    }

}

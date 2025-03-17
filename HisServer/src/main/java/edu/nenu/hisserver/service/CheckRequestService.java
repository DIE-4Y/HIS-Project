package edu.nenu.hisserver.service;

import edu.nenu.hisserver.pojo.*;

import java.util.List;
import java.util.Map;

public interface CheckRequestService {

    void update(Integer id, String checkState);

    void addCheckInfo(CheckRequest checkRequest);

    List<Map<String, Object>> getAllMedicalTechnology(String caseNumber, String name, String state);

    void settlementCheckRequest(List<Integer> checkRequestIdList);

    Integer getAllCheckedCount();

    PageBean getAllPeopleInLine();

    PageBean findByCaseNumberAndName(String caseNumber, String name, Integer pageSize, Integer pageNumber, String state);

    List<MedicalTechnology> findMedicalTechnologyByCaseNumber(String caseNumber, String state);

    void updateCheckState(StartCheckSubmit startCheckSubmit);

    void updateInputCheck(Integer registerId, Integer empId, List<Integer> medicalTechnologyIdList, String checkResult);

    Map<String, Object>   getAllMedicalTechnologyDetail(Integer registerId,Integer medicalTechnologyId, String checkState);
}

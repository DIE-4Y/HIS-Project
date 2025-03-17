package edu.nenu.hisserver.service;

import edu.nenu.hisserver.pojo.DrugInfo;
import edu.nenu.hisserver.pojo.PageBean;
import edu.nenu.hisserver.pojo.Register;

import java.util.List;
import java.util.Map;

public interface DrugstoreService {
    PageBean getAllRegisterByState(String caseNumber, String realName, Integer pageNumber, Integer pageSize, String state);

    List<Map<String, Object>> getAllDrugByRegisterId(Integer registerId);
}

package edu.nenu.hisserver.service;

import edu.nenu.hisserver.pojo.DrugInfo;
import edu.nenu.hisserver.pojo.PageBean;

import java.util.List;

public interface DrugService {
    PageBean getAllDrug(String drugName, String drugCode, Integer pageSize, Integer pageNumber);
}

package edu.nenu.hisserver.service;

import edu.nenu.hisserver.pojo.MedicalRecordDisease;
import edu.nenu.hisserver.pojo.PageBean;


public interface DiseaseService {
    PageBean getAllDisease(Integer id, String diseaseName, Integer pageNumber, Integer pageSize);

}

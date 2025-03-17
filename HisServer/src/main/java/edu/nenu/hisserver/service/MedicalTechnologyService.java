package edu.nenu.hisserver.service;

import edu.nenu.hisserver.pojo.MedicalTechnology;
import edu.nenu.hisserver.pojo.PageBean;

import java.util.List;

public interface MedicalTechnologyService {

    PageBean getAllMedicalTechnology(Integer id, String name, Integer pageNumber, Integer pageSize);
}

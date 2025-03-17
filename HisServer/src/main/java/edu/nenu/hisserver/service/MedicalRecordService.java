package edu.nenu.hisserver.service;

import edu.nenu.hisserver.pojo.MedicalRecord;
import edu.nenu.hisserver.pojo.MedicalTechnology;

import java.util.List;

public interface MedicalRecordService {
    Integer addMedicalRecord(MedicalRecord medicalRecord);

    void addMedicalRecordAndDisease(Integer medicalRecordId, List<Integer> diseaseIdList);

    void updateMedicalRecord(MedicalRecord medicalRecord);
}

package edu.nenu.hisserver.service.impl;

import edu.nenu.hisserver.mapper.MedicalRecordMapper;
import edu.nenu.hisserver.pojo.MedicalRecord;
import edu.nenu.hisserver.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {

    @Autowired
    private MedicalRecordMapper medicalRecordMapper;

    @Override
    public Integer addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordMapper.insertMedicalRecord(medicalRecord);
        return medicalRecordMapper.findLatestInsertId(medicalRecord);
    }

    @Override
    public void addMedicalRecordAndDisease(Integer medicalRecordId, List<Integer> diseaseIdList) {
        medicalRecordMapper.insertByMedicalIdAndDiseaseId(medicalRecordId, diseaseIdList);
    }

    @Override
    public void updateMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordMapper.updateMedicalRecord(medicalRecord);
    }

}

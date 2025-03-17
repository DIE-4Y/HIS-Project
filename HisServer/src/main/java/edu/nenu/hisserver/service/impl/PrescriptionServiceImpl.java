package edu.nenu.hisserver.service.impl;

import edu.nenu.hisserver.mapper.PrescriptionMapper;
import edu.nenu.hisserver.pojo.Prescription;
import edu.nenu.hisserver.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {
    @Autowired
    private PrescriptionMapper prescriptionMapper;

    @Override
    public void insert(List<Prescription> prescriptionList) {
        for (Prescription p :prescriptionList) {
            p.setCreationTime(LocalDateTime.now());
            p.setDrugState("已开立");
        }
        prescriptionMapper.insert(prescriptionList);
    }

    @Override
    public void updatePrescriptionStateByRegisterIdAndDrugId(Prescription prescription) {
        prescriptionMapper.updateState(prescription);
    }
}

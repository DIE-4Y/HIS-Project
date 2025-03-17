package edu.nenu.hisserver.service;

import edu.nenu.hisserver.pojo.Prescription;

import java.util.List;

public interface PrescriptionService {
    void insert(List<Prescription> prescriptionList);

    void updatePrescriptionStateByRegisterIdAndDrugId(Prescription prescription);
}

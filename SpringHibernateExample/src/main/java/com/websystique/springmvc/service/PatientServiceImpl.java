package com.websystique.springmvc.service;


import com.websystique.springmvc.dao.PatientDao;
import com.websystique.springmvc.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("patientService")
@Transactional
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientDao dao;

    @Override
    public Patient findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void savePatient(Patient patient) {
        dao.savePatient(patient);
    }

    @Override
    public void updatePatient(Patient patient) {
        //
    }

    @Override
    public void deletePatientById(int id) {
        dao.deletePatientById(id);
    }

    @Override
    public List<Patient> findAllPatients() {
        return dao.findAllPatients();
    }

    @Override
    public Patient findPatientByName(String name) {
        return dao.findPatientByName(name);
    }

    @Override
    public boolean isPatientNameUnique(Integer id, String name) {
        Patient patient = findPatientByName(name);
        return ( patient == null || ((id != null) && (patient.getId() == id)));
    }
}

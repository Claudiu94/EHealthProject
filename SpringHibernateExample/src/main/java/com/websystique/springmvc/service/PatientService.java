package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Patient;

import java.util.List;

public interface PatientService {
    Patient findById(int id);

    void savePatient(Patient patient);

    void updatePatient(Patient patient);

    void deletePatientById(int id);

    List<Patient> findAllPatients();

    Patient findPatientByName(String name);

    boolean isPatientNameUnique(Integer id, String name);
}

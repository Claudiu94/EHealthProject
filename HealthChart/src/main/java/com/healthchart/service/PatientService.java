package com.healthchart.service;

import com.healthchart.model.Patient;

import java.util.List;

public interface PatientService {

    Patient findById(int id);

    void savePatient(Patient patient);

    void updatePatient(Patient patient);

    void deletePatientByName(int id);

    List<Patient> findAllPatients();

    Patient findPatientByName(String name);

    boolean isPatientNameUnique(Integer id, String name);
}

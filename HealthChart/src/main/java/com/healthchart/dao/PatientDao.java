package com.healthchart.dao;

import com.healthchart.model.Patient;

import java.util.List;

public interface PatientDao {

    Patient findById(int id);

    void savePatient(Patient patient);

    void deletePatientById(int id);

    List<Patient> findAllPatients();

    Patient findPatientByName(String name);
}

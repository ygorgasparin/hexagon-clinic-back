package com.hexagon.clinic.service;

import com.hexagon.clinic.model.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> findAll(String filter, String sort);

    Patient save(Patient patient);

    Patient findById(int id);

    void deleteById(int id);

    Patient updateById(int id, Patient patient);
}

package com.hexagon.clinic.service;

import com.hexagon.clinic.model.Doctor;

import java.util.List;

public interface DoctorService {

    List<Doctor> findAll(String filter, String sort);

    Doctor save(Doctor doctor);

    Doctor findById(int id);

    void deleteById(int id);

    Doctor updateById(int id, Doctor doctor);
}

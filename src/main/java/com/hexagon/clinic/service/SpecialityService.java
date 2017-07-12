package com.hexagon.clinic.service;

import com.hexagon.clinic.model.Speciality;

import java.util.List;

public interface SpecialityService {

    List<Speciality> findAll(String filter, String sort);

    Speciality save(Speciality speciality);

    Speciality findById(int id);

    void deleteById(int id);

    Speciality updateById(int id, Speciality speciality);

}

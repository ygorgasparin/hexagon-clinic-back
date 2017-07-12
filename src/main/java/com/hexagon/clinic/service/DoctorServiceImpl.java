package com.hexagon.clinic.service;

import com.hexagon.clinic.dao.DoctorDAO;
import com.hexagon.clinic.dao.FilterStruct;
import com.hexagon.clinic.dao.OrderStruct;
import com.hexagon.clinic.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("doctorService")
@Transactional
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorDAO doctorDAO;

    @Override
    public List<Doctor> findAll(String filter, String sort) {

        FilterStruct filterStruct = new FilterStruct(filter);
        OrderStruct orderStruct = new OrderStruct(sort);

        return doctorDAO.findAll(filterStruct, orderStruct);
    }

    @Override
    public Doctor save(Doctor doctor) {
        return doctorDAO.create(doctor);
    }

    @Override
    public Doctor findById(int id) {
        return doctorDAO.findById(id);
    }

    @Override
    public Doctor updateById(int id, Doctor doctor) {
        doctor.setId(id);
        return doctorDAO.update(doctor);
    }

    @Override
    public void deleteById(int id) {
        doctorDAO.deleteById(id);
    }


}

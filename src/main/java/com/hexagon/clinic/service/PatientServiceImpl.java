package com.hexagon.clinic.service;

import com.hexagon.clinic.dao.FilterStruct;
import com.hexagon.clinic.dao.OrderStruct;
import com.hexagon.clinic.dao.PatientDAO;
import com.hexagon.clinic.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("patientService")
@Transactional
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientDAO patientDAO;

    @Override
    public List<Patient> findAll(String filter, String sort) {

        FilterStruct filterStruct = new FilterStruct(filter);
        OrderStruct orderStruct = new OrderStruct(sort);

        return patientDAO.findAll(filterStruct, orderStruct);
    }

    @Override
    public Patient save(Patient patient) {
        return patientDAO.create(patient);
    }

    @Override
    public Patient findById(int id) {
        return patientDAO.findById(id);
    }

    @Override
    public Patient updateById(int id, Patient patient) {
        patient.setId(id);
        return patientDAO.update(patient);
    }

    @Override
    public void deleteById(int id) {
        patientDAO.deleteById(id);
    }


}

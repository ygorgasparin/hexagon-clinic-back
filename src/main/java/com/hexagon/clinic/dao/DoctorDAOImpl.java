package com.hexagon.clinic.dao;

import com.hexagon.clinic.model.Doctor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("doctorDAO")
public class DoctorDAOImpl extends GenericDAO<Doctor> implements DoctorDAO {

    @Override
    public Class<Doctor> getClazz() {
        return Doctor.class;
    }

}

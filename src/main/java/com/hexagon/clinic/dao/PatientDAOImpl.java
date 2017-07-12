package com.hexagon.clinic.dao;

import com.hexagon.clinic.model.Doctor;
import com.hexagon.clinic.model.Patient;
import org.springframework.stereotype.Repository;

@Repository("patientDAO")
public class PatientDAOImpl extends GenericDAO<Patient> implements PatientDAO {

    @Override
    public Class<Patient> getClazz() {
        return Patient.class;
    }

}

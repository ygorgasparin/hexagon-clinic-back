package com.hexagon.clinic.dao;

import com.hexagon.clinic.model.Speciality;
import org.springframework.stereotype.Repository;

@Repository("specialityDAO")
public class SpecialityDAOImpl extends GenericDAO<Speciality> implements SpecialityDAO {
    @Override
    public Class<Speciality> getClazz() {
        return Speciality.class;
    }
}

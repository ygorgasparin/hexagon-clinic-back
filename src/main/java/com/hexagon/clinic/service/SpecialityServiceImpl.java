package com.hexagon.clinic.service;

import com.hexagon.clinic.dao.FilterStruct;
import com.hexagon.clinic.dao.OrderStruct;
import com.hexagon.clinic.dao.SpecialityDAO;
import com.hexagon.clinic.model.Speciality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("specialityService")
@Transactional
public class SpecialityServiceImpl implements SpecialityService {

    @Autowired
    SpecialityDAO specialityDAO;

    @Override
    public List<Speciality> findAll(String filter, String sort) {
        FilterStruct filterStruct = new FilterStruct(filter);
        OrderStruct orderStruct = new OrderStruct(sort);
        return specialityDAO.findAll(filterStruct, orderStruct);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specialityDAO.create(speciality);
    }

    @Override
    public Speciality findById(int id) {
        return specialityDAO.findById(id);
    }

    @Override
    public Speciality updateById(int id, Speciality speciality) {
        speciality.setId(id);
        return specialityDAO.update(speciality);
    }

    @Override
    public void deleteById(int id) {
        specialityDAO.deleteById(id);
    }
}

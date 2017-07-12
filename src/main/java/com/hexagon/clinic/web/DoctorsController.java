package com.hexagon.clinic.web;

import com.hexagon.clinic.model.Doctor;
import com.hexagon.clinic.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Doctor API Class, every call to '/api/doctors/*' should be implemented on this class
 */
@Controller
@RequestMapping("doctors")
public class DoctorsController {

    @Autowired
    DoctorService doctorService;

    /**
     * Find all doctors with filter and sort options
     *
     * @param filter
     * @param sort
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Doctor> getAll(@RequestParam(value = "filter", required = false) String filter,
                               @RequestParam(value = "sort", required = false) String sort) {
        List<Doctor> doctors = doctorService.findAll(filter, sort);
        return doctors;
    }

    /**
     * Create a new doctor
     *
     * @param doctor
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Doctor addNew(@RequestBody Doctor doctor) {
        return doctorService.save(doctor);
    }

    /**
     * Find the doctor with this id. If not found return empty
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Doctor getById(@PathVariable int id) {
        return doctorService.findById(id);
    }


    /**
     * Update all information's of this object id
     *
     * @param id
     * @param doctor
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Doctor updateById(@PathVariable int id, @RequestBody Doctor doctor) {
        return doctorService.updateById(id, doctor);
    }


    /**
     * Delete object with this id
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteById(@PathVariable int id) {
        doctorService.deleteById(id);
        return "";
    }

}

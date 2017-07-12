package com.hexagon.clinic.web;

import com.hexagon.clinic.model.Patient;
import com.hexagon.clinic.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Patients API Class, every call to '/api/patients/*' should be implemented on this class
 */
@Controller
@RequestMapping("patients")
public class PatientsController {

    @Autowired
    PatientService patientService;


    /**
     * Find all patients with filter and sort options
     *
     * @param filter
     * @param sort
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Patient> getAll(@RequestParam(value = "filter", required = false) String filter,
                                @RequestParam(value = "sort", required = false) String sort) {
        List<Patient> patients = patientService.findAll(filter, sort);
        return patients;
    }

    /**
     * Create a new patient
     *
     * @param patient
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Patient addNew(@RequestBody Patient patient) {
        return patientService.save(patient);
    }


    /**
     * Find the patient with this id. If not found return empty
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Patient getById(@PathVariable int id) {
        return patientService.findById(id);
    }

    /**
     * Update all information's of this object id
     *
     * @param id
     * @param patient
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Patient updateById(@PathVariable int id, @RequestBody Patient patient) {
        return patientService.updateById(id, patient);
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
        patientService.deleteById(id);
        return "";
    }
}

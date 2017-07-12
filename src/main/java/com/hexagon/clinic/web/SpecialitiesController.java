package com.hexagon.clinic.web;

import com.hexagon.clinic.model.Speciality;
import com.hexagon.clinic.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Specialities API Class, every call to '/api/specialities/*' should be implemented on this class
 */
@Controller
@RequestMapping("specialities")
public class SpecialitiesController {

    @Autowired
    SpecialityService specialityService;

    /**
     * Find all specialities with filter and sort options
     *
     * @param filter
     * @param sort
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Speciality> getAll(@RequestParam(value = "filter", required = false) String filter,
                                   @RequestParam(value = "sort", required = false) String sort) {
        List<Speciality> specialities = specialityService.findAll(filter, sort);
        return specialities;
    }

    /**
     * Create a new speciality
     *
     * @param speciality
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Speciality addNew(@RequestBody Speciality speciality) {
        return specialityService.save(speciality);
    }


    /**
     * Find the speciality with this id. If not found return empty
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Speciality getById(@PathVariable int id) {
        return specialityService.findById(id);
    }

    /**
     * Update all information's of this object id
     *
     * @param id
     * @param speciality
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Speciality updateById(@PathVariable int id, @RequestBody Speciality speciality) {
        return specialityService.updateById(id, speciality);
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
        specialityService.deleteById(id);
        return "";
    }
}

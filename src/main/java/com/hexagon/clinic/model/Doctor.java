package com.hexagon.clinic.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor extends BaseModel implements Serializable {

    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @Column(name = "phone", length = 60)
    private String phone;

    @Column(name = "cpf", length = 60)
    private String cpf;

    @Column(name = "crm", length = 60)
    private String crm;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "doctor_speciality",
            joinColumns = {@JoinColumn(name = "doctor_id")},
            inverseJoinColumns = {@JoinColumn(name = "speciality_id")})
    private List<Speciality> doctorSpecialities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public List<Speciality> getDoctorSpecialities() {
        return doctorSpecialities;
    }

    public void setDoctorSpecialities(List<Speciality> doctorSpecialities) {
        this.doctorSpecialities = doctorSpecialities;
    }
}

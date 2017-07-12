package com.hexagon.clinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "patient")
public class Patient extends BaseModel implements Serializable {

    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @Column(name = "phone", nullable = false, length = 60)
    private String phone;

    @Column(name = "cpf", nullable = false, length = 60)
    private String cpf;

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
}

package com.hexagon.clinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Speciality")
public class Speciality extends BaseModel implements Serializable {

    @Column(name = "name", nullable = false, length = 60)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

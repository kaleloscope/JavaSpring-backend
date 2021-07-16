package com.example.demo.district;

import javax.persistence.*;

@Entity
@Table(name = "district")
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int code;
    private String description;
    private boolean activeStatus;

    public District() {
    }

    public District(int id, String name, int code, String description, boolean activeStatus) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.activeStatus = activeStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean  activeStatus) {
        this.activeStatus = activeStatus;
    }
}

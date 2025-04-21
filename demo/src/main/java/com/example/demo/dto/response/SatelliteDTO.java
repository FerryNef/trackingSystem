package com.example.demo.dto.response;

import java.time.LocalDate;

public class SatelliteDTO {
    private Long id;
    private String name;
    private LocalDate launchDate;
    private String orbitType;
    private boolean decommissioned;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLaunchDate(LocalDate launchDate) {
        this.launchDate = launchDate;
    }

    public void setOrbitType(String orbitType) {
        this.orbitType = orbitType;
    }

    public void setDecommissioned(boolean decommissioned) {
        this.decommissioned = decommissioned;
    }

    public Long getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public String getOrbitType() {
        return orbitType;
    }

    public boolean isDecommissioned() {
        return decommissioned;
    }
}

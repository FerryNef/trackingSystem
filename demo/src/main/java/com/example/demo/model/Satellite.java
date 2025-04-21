package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Satellite {
    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Past
    private LocalDate launchDate;

    @Pattern(regexp = "LEO|MEO|GEO")
    private String orbitType;

    private boolean decommissioned;

    @ManyToMany(mappedBy = "satellites")
    private List<Astronaut> astronauts;

    public Long getId () {
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

    public List<Astronaut> getAstronauts() {
        return astronauts;
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

    public void setAstronauts(List<Astronaut> astronauts) {
        this.astronauts = astronauts;
    }
}

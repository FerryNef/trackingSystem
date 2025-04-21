package com.example.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

public class AstronautResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private int experienceYears;
    private List<SatelliteDTO> satellites;

    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getExperienceYears() { return experienceYears; }
    public List<SatelliteDTO> getSatellites() { return satellites; }

    public void setId(Long id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setExperienceYears(int experienceYears) { this.experienceYears = experienceYears; }
    public void setSatellites(List<SatelliteDTO> satellites) { this.satellites = satellites; }
}


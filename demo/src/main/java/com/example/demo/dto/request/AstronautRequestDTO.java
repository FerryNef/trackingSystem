package com.example.demo.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public class AstronautRequestDTO {
    @NotBlank
    @Size(min = 2, max = 20)
    private String firstName;

    @NotBlank @Size(min = 2, max = 20)
    private String lastName;

    @Min(0) @Max(50)
    private int experienceYears;

    private List<Long> satelliteIds;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public List<Long> getSatelliteIds() {
        return satelliteIds;
    }


}

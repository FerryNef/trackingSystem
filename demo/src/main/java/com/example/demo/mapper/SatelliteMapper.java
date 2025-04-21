package com.example.demo.mapper;

import com.example.demo.dto.response.SatelliteDTO;
import com.example.demo.model.Satellite;
import org.springframework.stereotype.Component;

@Component
public class SatelliteMapper {


    public SatelliteDTO toSatelliteDTO(Satellite satellite) {
        SatelliteDTO dto = new SatelliteDTO();
        dto.setId(satellite.getId());
        dto.setName(satellite.getName());
        dto.setLaunchDate(satellite.getLaunchDate());
        dto.setOrbitType(satellite.getOrbitType());
        dto.setDecommissioned(satellite.isDecommissioned());
        return dto;
    }

}

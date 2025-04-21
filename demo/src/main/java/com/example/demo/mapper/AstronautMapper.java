package com.example.demo.mapper;

import com.example.demo.dto.request.AstronautRequestDTO;
import com.example.demo.dto.response.AstronautResponseDTO;
import com.example.demo.dto.response.SatelliteDTO;
import com.example.demo.model.Astronaut;
import com.example.demo.model.Satellite;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AstronautMapper {

    public Astronaut toEntity(AstronautRequestDTO dto, List<Satellite> satellites) {
        Astronaut astronaut = new Astronaut();
        astronaut.setFirstName(dto.getFirstName());
        astronaut.setLastName(dto.getLastName());
        astronaut.setExperienceYears(dto.getExperienceYears());
        astronaut.setSatellites(new HashSet<>(satellites));
        return astronaut;
    }


    public AstronautResponseDTO toResponse(Astronaut entity) {
        List<SatelliteDTO> satelliteDTOs = entity.getSatellites().stream()
                .map(this::toSatelliteDTO)
                .collect(Collectors.toList());

        AstronautResponseDTO dto = new AstronautResponseDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setExperienceYears(entity.getExperienceYears());
        dto.setSatellites(satelliteDTOs);
        return dto;
    }

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

package com.example.demo.controller;

import com.example.demo.dto.request.AstronautRequestDTO;
import com.example.demo.dto.response.AstronautResponseDTO;
import com.example.demo.dto.response.SatelliteDTO;
import com.example.demo.exception.SatelliteNotFoundException;
import com.example.demo.mapper.SatelliteMapper;
import com.example.demo.model.Satellite;
import com.example.demo.repository.SatelliteRepository;
import com.example.demo.service.AstronautService;
import com.example.demo.service.SatelliteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    @RequestMapping("/api/v1/astronauts")
    public class AstronautController {

        @Autowired
        private AstronautService astronautService;

        @Autowired
        private SatelliteRepository satelliteRepo;

        @Autowired
        private SatelliteMapper mapper;




        @PostMapping
        public ResponseEntity<AstronautResponseDTO> create(@Valid @RequestBody AstronautRequestDTO dto) {
            return new ResponseEntity<>(astronautService.createAstronaut(dto), HttpStatus.CREATED);
        }

        @GetMapping
        public ResponseEntity<List<AstronautResponseDTO>> getAllSorted(
                @RequestParam(defaultValue = "experienceYears") String sort,
                @RequestParam(defaultValue = "asc") String order) {
            return ResponseEntity.ok(astronautService.getAllAstronautsSorted(sort, order));
        }

    @PutMapping("/api/v1/satellites/{id}")
    public ResponseEntity<SatelliteDTO> update( @PathVariable Long id, @Valid @RequestBody SatelliteDTO dto
    ) {
        Satellite satellite = satelliteRepo.findById(id)
                .orElseThrow(() -> new SatelliteNotFoundException(id));

        if (satellite.isDecommissioned()) {
            throw new IllegalStateException("Cannot update a decommissioned satellite");
        }

        satellite.setName(dto.getName());
        satellite.setLaunchDate(dto.getLaunchDate());
        satellite.setOrbitType(dto.getOrbitType());

        Satellite saved = satelliteRepo.save(satellite);
        SatelliteDTO responseDto = mapper.toSatelliteDTO(saved);


        return ResponseEntity.ok(responseDto);
        }
    }


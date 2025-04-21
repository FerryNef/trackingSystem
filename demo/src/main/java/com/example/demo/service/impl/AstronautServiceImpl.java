package com.example.demo.service.impl;

import com.example.demo.dto.request.AstronautRequestDTO;
import com.example.demo.dto.response.AstronautResponseDTO;
import com.example.demo.exception.SatelliteNotFoundException;
import com.example.demo.mapper.AstronautMapper;
import com.example.demo.model.Astronaut;
import com.example.demo.model.Satellite;
import com.example.demo.repository.AstronautRepository;
import com.example.demo.repository.SatelliteRepository;
import com.example.demo.service.AstronautService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AstronautServiceImpl implements AstronautService {


    private final AstronautRepository astronautRepo;

    private final SatelliteRepository satelliteRepo;
    private final AstronautMapper mapper;

    @Override
    public AstronautResponseDTO createAstronaut(AstronautRequestDTO dto) {

        List<Satellite> satellites = satelliteRepo.findAllById(dto.getSatelliteIds());


        Set<Long> foundIds = satellites.stream()
                .map(Satellite::getId)
                .collect(Collectors.toSet());

        for (Long id : dto.getSatelliteIds()) {
            if (!foundIds.contains(id)) {
                throw new SatelliteNotFoundException(id);
            }
        }


        Astronaut astronaut = mapper.toEntity(dto, satellites);


        Astronaut saved = astronautRepo.save(astronaut);
        return mapper.toResponse(saved);
    }

    @Override
    public List<AstronautResponseDTO> getAllAstronautsSorted(String sort, String order) {
        Sort sortBy = Sort.by(Sort.Direction.fromString(order), sort);
        return astronautRepo.findAll(sortBy).stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }




}


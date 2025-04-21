package com.example.demo.service;

import com.example.demo.dto.request.AstronautRequestDTO;
import com.example.demo.dto.response.AstronautResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AstronautService {
    AstronautResponseDTO createAstronaut(AstronautRequestDTO dto);
    List<AstronautResponseDTO> getAllAstronautsSorted(String sort, String order);
}

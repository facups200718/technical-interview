package com.boxcustodia.entrevistatecnica.controller;

import com.boxcustodia.entrevistatecnica.dto.in.JwtAuthenticationInRequestDTO;
import org.springframework.http.ResponseEntity;

public interface UserController {
    ResponseEntity login(JwtAuthenticationInRequestDTO loginDto);
}

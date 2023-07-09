package com.boxcustodia.entrevistatecnica.dto.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInResponseDTO {
    private String username;
    private String password;
    private LocalDateTime lastLogin;
}
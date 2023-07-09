package com.boxcustodia.entrevistatecnica.dto.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JwtAuthenticationInResponseDTO {
    private String token;
}

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
public class DocumentByHashInResponseDTO {
    private String fileName;
    private String hash;
    private LocalDateTime lastUpload;
}

package com.boxcustodia.entrevistatecnica.dto.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentInResponseDTO {
    private String fileName;
    private String hashSha256;
    private String hashSha512;
    private LocalDate lastUpload;
}

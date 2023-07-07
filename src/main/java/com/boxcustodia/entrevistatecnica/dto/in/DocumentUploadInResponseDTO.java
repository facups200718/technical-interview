package com.boxcustodia.entrevistatecnica.dto.in;

import com.boxcustodia.entrevistatecnica.dto.model.DocumentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DocumentUploadInResponseDTO {
    private String algorithm;
    private List<DocumentDTO> documents;
}

package com.boxcustodia.entrevistatecnica.repository;

import com.boxcustodia.entrevistatecnica.dto.in.DocumentInResponseDTO;
import com.boxcustodia.entrevistatecnica.dto.in.DocumentUploadInResponseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DocumentRepository {
    DocumentUploadInResponseDTO uploadDocuments(String hashType, List<MultipartFile> documents);
    List<DocumentInResponseDTO> findAllDocuments();
}

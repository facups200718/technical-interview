package com.boxcustodia.entrevistatecnica.repository.impl;

import com.boxcustodia.entrevistatecnica.dto.in.DocumentUploadInResponseDTO;
import com.boxcustodia.entrevistatecnica.repository.DocumentRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Repository
public class DocumentRepositoryImpl implements DocumentRepository {
    @Override
    public DocumentUploadInResponseDTO uploadDocuments(String hashType, List<MultipartFile> documents) {
        return null;
    }
}

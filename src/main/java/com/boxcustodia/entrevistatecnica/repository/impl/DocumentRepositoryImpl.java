package com.boxcustodia.entrevistatecnica.repository.impl;

import com.boxcustodia.entrevistatecnica.dto.in.DocumentInResponseDTO;
import com.boxcustodia.entrevistatecnica.dto.in.DocumentUploadInResponseDTO;
import com.boxcustodia.entrevistatecnica.entity.DocumentEntity;
import com.boxcustodia.entrevistatecnica.mapper.DocumentMapper;
import com.boxcustodia.entrevistatecnica.repository.DocumentRepository;
import com.boxcustodia.entrevistatecnica.repository.DocumentCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DocumentRepositoryImpl implements DocumentRepository {
    private final DocumentCrudRepository documentCrudRepository;
    private final DocumentMapper documentMapper;

    @Override
    public DocumentUploadInResponseDTO uploadDocuments(String hashType, List<MultipartFile> documents) {
        return null;
    }

    @Override
    public List<DocumentInResponseDTO> findAllDocuments() {
        List<DocumentEntity> documentEntities = (List<DocumentEntity>) documentCrudRepository.findAll();
        return documentMapper.toDTOs(documentEntities);
    }
}

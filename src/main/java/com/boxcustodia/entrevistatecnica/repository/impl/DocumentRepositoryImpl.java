package com.boxcustodia.entrevistatecnica.repository.impl;

import com.boxcustodia.entrevistatecnica.dto.in.DocumentByHashInResponseDTO;
import com.boxcustodia.entrevistatecnica.dto.in.DocumentInResponseDTO;
import com.boxcustodia.entrevistatecnica.dto.in.DocumentUploadInResponseDTO;
import com.boxcustodia.entrevistatecnica.dto.model.DocumentDTO;
import com.boxcustodia.entrevistatecnica.entity.DocumentEntity;
import com.boxcustodia.entrevistatecnica.enums.HashType;
import com.boxcustodia.entrevistatecnica.mapper.DocumentMapper;
import com.boxcustodia.entrevistatecnica.repository.DocumentRepository;
import com.boxcustodia.entrevistatecnica.repository.DocumentCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DocumentRepositoryImpl implements DocumentRepository {
    private final DocumentCrudRepository documentCrudRepository;
    private final DocumentMapper documentMapper;

    @Override
    public void uploadDocuments(String hashType, DocumentDTO hashedDocument) {
        var documentEntity = DocumentEntity.builder()
                .fileName(hashedDocument.getFileName())
                .hashSha256(HashType.SHA256.getValue().equals(hashType)
                        ? hashedDocument.getHash() : null)
                .hashSha512(HashType.SHA512.getValue().equals(hashType)
                        ? hashedDocument.getHash() : null)
                .lastUpload(LocalDateTime.now())
                .build();

        documentCrudRepository.save(documentEntity);
    }

    @Override
    public List<DocumentInResponseDTO> findAllDocuments() {
        var documentEntities = (List<DocumentEntity>) documentCrudRepository.findAll();
        return documentMapper.toDTOs(documentEntities);
    }

    @Override
    public DocumentByHashInResponseDTO findDocumentByHash(String hashTpye, String hash) throws Exception {
        Boolean is256 = HashType.SHA256.getValue().equals(hashTpye);
        var documentEntity = is256
                ? documentCrudRepository.findByHashSha256(hash)
                : documentCrudRepository.findByHashSha512(hash);

        if (documentEntity.isEmpty()) throw new Exception();

        DocumentByHashInResponseDTO response = documentMapper.byHashToDTO(documentEntity.get());
        response.setHash(is256 ? documentEntity.get().getHashSha256() : documentEntity.get().getHashSha512());
        return response;
    }
}

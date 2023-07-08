package com.boxcustodia.entrevistatecnica.repository;

import com.boxcustodia.entrevistatecnica.dto.in.DocumentByHashInResponseDTO;
import com.boxcustodia.entrevistatecnica.dto.in.DocumentInResponseDTO;
import com.boxcustodia.entrevistatecnica.dto.model.DocumentDTO;

import java.util.List;

public interface DocumentRepository {
    void uploadDocuments(String hashType, DocumentDTO hashedDocument);
    List<DocumentInResponseDTO> findAllDocuments();
    DocumentByHashInResponseDTO findDocumentByHash(String hashTpye, String hash) throws Exception;
}

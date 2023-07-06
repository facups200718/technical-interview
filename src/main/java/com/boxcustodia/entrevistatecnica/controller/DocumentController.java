package com.boxcustodia.entrevistatecnica.controller;

import com.boxcustodia.entrevistatecnica.dto.in.DocumentsInRequestDTO;
import org.springframework.http.ResponseEntity;

public interface DocumentController {
    ResponseEntity uploadDocuments(String hashType, DocumentsInRequestDTO documents);
    ResponseEntity getAllDocuments();
    ResponseEntity getDocumentByHash(String hashType, String hash);
}

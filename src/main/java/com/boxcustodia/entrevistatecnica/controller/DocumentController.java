package com.boxcustodia.entrevistatecnica.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;

public interface DocumentController {
    ResponseEntity uploadDocuments(String hashType, List<String> documents);
    ResponseEntity getAllDocuments();
    ResponseEntity getDocumentByHash(String hashType, String hash);
}

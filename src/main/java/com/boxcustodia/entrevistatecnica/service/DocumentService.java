package com.boxcustodia.entrevistatecnica.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DocumentService {
    ResponseEntity uploadDocuments(String hashType, List<MultipartFile> documents);
    ResponseEntity getDocuments(String hashType, String hash);
}

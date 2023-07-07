package com.boxcustodia.entrevistatecnica.service.impl;

import com.boxcustodia.entrevistatecnica.dto.in.DocumentUploadInResponseDTO;
import com.boxcustodia.entrevistatecnica.dto.model.DocumentDTO;
import com.boxcustodia.entrevistatecnica.enums.HashType;
import com.boxcustodia.entrevistatecnica.repository.DocumentRepository;
import com.boxcustodia.entrevistatecnica.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    private static final String ERROR_MESSAGE = "Se produjo un error.";

    @Override
    public ResponseEntity uploadDocuments(String hashType, List<MultipartFile> documents) {
        Boolean validHash = HashType.isValid(hashType);
        Boolean emptyDocument = documents.isEmpty();

        if (Boolean.TRUE.equals(validHash) && Boolean.FALSE.equals(emptyDocument)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(upsertDocuments(hashType, documents));
        }

        return ResponseEntity.badRequest().body(ERROR_MESSAGE);
    }

    private DocumentUploadInResponseDTO upsertDocuments(String hashType, List<MultipartFile> documents) {
        List<DocumentDTO> hashedDocuments = new ArrayList<>();
        try {
            // Obtiene el algoritmo para el hashType que le pasamos
            var messageDigest = MessageDigest.getInstance(hashType);

            for (MultipartFile document : documents) {
                byte[] fileBytes = document.getBytes();
                byte[] hashBytes = messageDigest.digest(fileBytes);
                String hash = bytesToHex(hashBytes);
                var hashedDocument = DocumentDTO.builder()
                        .hash(hash)
                        .fileName(document.getOriginalFilename())
                        .build();
                hashedDocuments.add(hashedDocument);
            }
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }

        return DocumentUploadInResponseDTO.builder()
                .algorithm(hashType)
                .documents(hashedDocuments)
                .build();
    }

    private static String bytesToHex(byte[] bytes) {
        var result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02X", b));
        }
        return result.toString();
    }

    @Override
    public ResponseEntity getDocuments(String hashType, String hash) {
        return null;
    }
}

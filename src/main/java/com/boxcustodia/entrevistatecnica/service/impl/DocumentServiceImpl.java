package com.boxcustodia.entrevistatecnica.service.impl;

import com.boxcustodia.entrevistatecnica.dto.in.DocumentUploadInResponseDTO;
import com.boxcustodia.entrevistatecnica.dto.model.DocumentDTO;
import com.boxcustodia.entrevistatecnica.enums.HashType;
import com.boxcustodia.entrevistatecnica.repository.DocumentRepository;
import com.boxcustodia.entrevistatecnica.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository documentRepository;

    private static final String ERROR_MESSAGE = "Se produjo un error.";
    private static final String NOT_FOUND_ERROR_MESSAGE = "No hay ningún documento con ese nombre.";

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
                Byte[] hashBytes = ArrayUtils.toObject(messageDigest.digest(fileBytes));
                String hash = bytesToHex(hashBytes);
                var hashedDocument = DocumentDTO.builder()
                        .hash(hash)
                        .fileName(document.getOriginalFilename())
                        .build();

                documentRepository.uploadDocuments(hashType, hashedDocument);
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

    private static String bytesToHex(Byte[] bytes) {
        var result = new StringBuilder();
        Arrays.stream(bytes).forEach(b -> result.append(String.format("%02X", b)));
        return result.toString();
    }

    @Override
    public ResponseEntity getAllDocuments() {
        return ResponseEntity.ok(documentRepository.findAllDocuments());
    }

    @Override
    public ResponseEntity findDocumentByHash(String hashType, String hash) {
        if (!HashType.isValid(hashType)) {
            return ResponseEntity.badRequest().body(ERROR_MESSAGE);
        }

        try {
            return ResponseEntity.ok(documentRepository.findDocumentByHash(hashType, hash));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(NOT_FOUND_ERROR_MESSAGE);
        }
    }
}

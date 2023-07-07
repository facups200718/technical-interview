package com.boxcustodia.entrevistatecnica.controller.impl;

import com.boxcustodia.entrevistatecnica.controller.DocumentController;

import com.boxcustodia.entrevistatecnica.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class DocumentControllerImpl implements DocumentController {

    @Autowired
    private DocumentService documentService;

    @Override
    @PostMapping("/documents/hash")
    public ResponseEntity uploadDocuments(@RequestParam String hashType,
                                          @RequestParam(name = "documents") List<MultipartFile> documents) {
        return documentService.uploadDocuments(hashType, documents);
    }

    @Override
    @GetMapping("/documents")
    public ResponseEntity getDocuments(@RequestParam(required = false) String hashType,
                                       @RequestParam(required = false) String hash) {
        return documentService.getDocuments(hashType, hash);
    }
}

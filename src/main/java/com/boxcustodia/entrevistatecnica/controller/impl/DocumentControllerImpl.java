package com.boxcustodia.entrevistatecnica.controller.impl;

import com.boxcustodia.entrevistatecnica.controller.DocumentController;

import com.boxcustodia.entrevistatecnica.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/documents")
@RequiredArgsConstructor
public class DocumentControllerImpl implements DocumentController {
    private final DocumentService documentService;

    @Override
    @PostMapping("/hash")
    public ResponseEntity uploadDocuments(@RequestParam String hashType,
                                          @RequestParam(name = "documents") List<MultipartFile> documents) {
        return documentService.uploadDocuments(hashType, documents);
    }

    @Override
    @GetMapping
    public ResponseEntity getAllDocuments() {
        return documentService.getAllDocuments();
    }

    @Override
    @GetMapping(params = {"hashType", "hash"})
    public ResponseEntity findDocumentByHash(@RequestParam String hashType,
                                             @RequestParam String hash) {
        return null;
    }
}

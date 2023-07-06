package com.boxcustodia.entrevistatecnica.controller.impl;

import com.boxcustodia.entrevistatecnica.controller.DocumentController;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class DocumentControllerImpl implements DocumentController {
    @Override
    @PostMapping("/documents/hash")
    public ResponseEntity uploadDocuments(@RequestParam String hashType, @RequestBody List<String> documents) {
        return null;
    }

    @Override
    @GetMapping("/documents")
    public ResponseEntity getAllDocuments() {
        return null;
    }

    @Override
    @GetMapping("/document")
    public ResponseEntity getDocumentByHash(@RequestParam String hashType, @RequestParam String hash) {
        return null;
    }


}

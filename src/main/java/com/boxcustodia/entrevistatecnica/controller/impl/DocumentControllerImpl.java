package com.boxcustodia.entrevistatecnica.controller.impl;

import com.boxcustodia.entrevistatecnica.controller.DocumentController;
import com.boxcustodia.entrevistatecnica.dto.in.DocumentsInRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/documents")
public class DocumentControllerImpl implements DocumentController {
    @Override
    @PostMapping("/hash")
    public ResponseEntity uploadDocuments(@RequestParam String hashType, @RequestBody DocumentsInRequestDTO documents) {
        return null;
    }

    @Override
    @GetMapping("")
    public ResponseEntity getAllDocuments() {
        return null;
    }

    @Override
    @GetMapping("")
    public ResponseEntity getDocumentByHash(@RequestParam String hashType, @RequestParam String hash) {
        return null;
    }


}

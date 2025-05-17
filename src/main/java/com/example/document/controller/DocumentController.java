package com.example.document.controller;

import com.example.document.dto.DocumentUploadRequest;
import com.example.document.entity.Document;
import com.example.document.service.DocumentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @Operation(summary = "Upload a document file", requestBody = @RequestBody(content = @Content(mediaType = "multipart/form-data", schema = @Schema(implementation = DocumentUploadRequest.class))))
    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public Document uploadDocument(@RequestParam String title, @RequestParam String author, @RequestParam String type, @Parameter(description = "Document file", required = true) @RequestParam MultipartFile file) throws IOException {
        return documentService.saveDocument(title, author, type, file);
    }

    @GetMapping("/filter")
    public Page<Document> filterDocuments(@RequestParam(defaultValue = "") String author, @RequestParam(defaultValue = "") String type, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return documentService.filterDocuments(author, type, PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Document getById(@PathVariable UUID id) {
        return documentService.getById(id).orElseThrow(() -> new RuntimeException("Document not found"));
    }
}

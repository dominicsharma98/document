package com.example.document.controller;

import com.example.document.entity.Document;
import com.example.document.service.DocumentService;
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

    @PostMapping("/upload")
    public Document uploadDocument(
            @RequestParam String title,
            @RequestParam String author,
            @RequestParam String type,
            @RequestParam MultipartFile file
    ) throws IOException {
        return documentService.saveDocument(title, author, type, file);
    }

    @GetMapping("/filter")
    public Page<Document> filterDocuments(
            @RequestParam(defaultValue = "") String author,
            @RequestParam(defaultValue = "") String type,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return documentService.filterDocuments(author, type, PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Document getById(@PathVariable UUID id) {
        return documentService.getById(id)
                .orElseThrow(() -> new RuntimeException("Document not found"));
    }
}

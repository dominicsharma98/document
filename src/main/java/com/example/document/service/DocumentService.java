package com.example.document.service;

import com.example.document.entity.Document;
import com.example.document.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DocumentService {
    private final DocumentRepository documentRepository;

    public Document saveDocument(String title, String author, String type, MultipartFile file) throws IOException {
        String content = new String(file.getBytes(), StandardCharsets.UTF_8);

        Document document = Document.builder()
                .title(title)
                .author(author)
                .type(type)
                .content(content)
                .build();

        return documentRepository.save(document);
    }

    public List<Document> searchByKeyword(String keyword) {
        return documentRepository.searchByKeyword(keyword);
    }

    @Transactional(readOnly = true)
    public Page<Document> filterDocuments(String author, String type, Pageable pageable) {
        return documentRepository.findByAuthorIgnoreCaseContainingAndTypeIgnoreCaseContaining(author, type, pageable);
    }

    public Optional<Document> getById(UUID id) {
        return documentRepository.findById(id);
    }
}

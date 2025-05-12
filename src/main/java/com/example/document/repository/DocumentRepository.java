package com.example.document.repository;

import com.example.document.entity.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface DocumentRepository extends JpaRepository<Document, UUID> {
    // Full-text search using ILIKE (PostgreSQL)
    @Query(value = "SELECT * FROM documents WHERE to_tsvector('english', content) @@ plainto_tsquery('english', :keyword)", nativeQuery = true)
    List<Document> searchByKeyword(String keyword);

    // Filter by metadata + pagination
    Page<Document> findByAuthorIgnoreCaseContainingAndTypeIgnoreCaseContaining(String author, String type, Pageable pageable);

}

package com.example.document.service;

import com.example.document.entity.Document;
import com.example.document.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QAService {

    private final DocumentRepository documentRepository;

    public List<String> getAnswersForQuestion(String question) {
        List<Document> docs = documentRepository.searchByKeyword(question);

        return docs.stream()
                .map(doc -> extractSnippet(doc.getContent(), question))
                .toList();
    }

    private String extractSnippet(String content, String keyword) {
        int index = content.toLowerCase().indexOf(keyword.toLowerCase());
        if (index == -1) return "";

        int start = Math.max(0, index - 50);
        int end = Math.min(content.length(), index + keyword.length() + 50);

        return content.substring(start, end) + "...";
    }
}

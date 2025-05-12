package com.example.document.controller;

import com.example.document.service.QAService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/qa")
@RequiredArgsConstructor
public class QAController {

    private final QAService qaService;

    @PostMapping("/ask")
    public List<String> askQuestion(@RequestParam String question) {
        return qaService.getAnswersForQuestion(question);
    }
}

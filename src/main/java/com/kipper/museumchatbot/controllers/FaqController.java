package com.kipper.museumchatbot.controllers;

import com.kipper.museumchatbot.dto.MessageRequest;
import com.kipper.museumchatbot.dto.MessageResponse;
import com.kipper.museumchatbot.services.FaqService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class FaqController {
    private FaqService faqService;

    public FaqController(FaqService faqService) {
        this.faqService = faqService;
    }

    @PostMapping
    public ResponseEntity<MessageResponse> answerQuestion(@RequestBody MessageRequest request) {
        String answer = this.faqService.getAnswers(request.message());
        MessageResponse response = new MessageResponse(answer);
        return ResponseEntity.ok(response);
    }
}
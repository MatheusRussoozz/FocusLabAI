package com.br.russodev.FocusLabAI.Quiz.DTO.GeminiDTOs;

import java.util.List;

public record GeminiQuestionDTO(

        String question,
        List<String> options,
        String correct

) {
}

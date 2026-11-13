package com.br.russodev.FocusLabAI.Quiz.DTO.QuizDTOs;

import com.br.russodev.FocusLabAI.Subject.Entity.SubjectEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record QuizRequestDTO(
        @NotNull(message = "The subject ID is required.")
        @Positive(message = "The subject ID must be positive.")
        Long subjectId

) {
}

package com.br.russodev.FocusLabAI.StudySession.DTO;

import com.br.russodev.FocusLabAI.Subject.Entity.SubjectEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record StudySessionRequestDTO(

        @NotNull(message = "The subject ID is required.")
        @Positive(message = "The subject ID must be positive.")
        Long subjectId,
        @NotNull(message = "The date field must be filled in.")
        LocalDateTime date,
        @NotNull(message = "The minutes field must be filled in.")
        @Positive(message = "Minutes must be greater than zero.")
        Integer minutes,
        @NotBlank(message = "The notes field must be filled in.")
        String notes



) {
}

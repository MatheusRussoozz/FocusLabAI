package com.br.russodev.FocusLabAI.StudySession.DTO;

import com.br.russodev.FocusLabAI.Subject.Entity.SubjectEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record StudySessionRequestDTO(

        @NotBlank(message = "The subject field must be filled in.")
        SubjectEntity subject,
        @NotBlank(message = "The date field must be filled in.")
        LocalDateTime date,
        @NotBlank(message = "The minutes field must be filled in.")
        Integer minutes,
        @NotBlank(message = "The notes field must be filled in.")
        String notes



) {
}

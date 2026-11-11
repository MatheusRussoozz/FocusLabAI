package com.br.russodev.FocusLabAI.StudySession.DTO;

import com.br.russodev.FocusLabAI.Subject.DTO.SubjectResponseDTO;
import com.br.russodev.FocusLabAI.Subject.Entity.SubjectEntity;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record StudySessionResponseDTO(

        SubjectResponseDTO subject,
        LocalDateTime date,
        Integer minutes,
        String notes

) {
}

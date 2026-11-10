package com.br.russodev.FocusLabAI.Subject.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import org.antlr.v4.runtime.misc.NotNull;


public record SubjectRequestDTO(

        @NotBlank(message = "The name field must be filled in.")
        String name,
        @NotBlank(message = "The descripiton field must be filled in.")
        String description,
        @NotBlank(message = "The Weekly Goal field must be filled in.")
        String weeklyGoal

) {
}

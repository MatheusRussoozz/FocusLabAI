package com.br.russodev.FocusLabAI.Quiz.DTO.OptionsDTOs;

import com.br.russodev.FocusLabAI.Quiz.Entity.QuestionEntity;

public record OptionsResponseDTO(

        Long id,
        Long questionId,
        String option

) {
}

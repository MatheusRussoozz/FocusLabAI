package com.br.russodev.FocusLabAI.Quiz.DTO.QuestionDTOs;

import com.br.russodev.FocusLabAI.Quiz.DTO.OptionsDTOs.OptionsResponseDTO;
import com.br.russodev.FocusLabAI.Quiz.Entity.OptionsEntity;
import com.br.russodev.FocusLabAI.Quiz.Entity.QuizEntity;

import java.util.List;

public record QuestionResponseDTO(
        Long id,
        Long quizId,
        String question,
        List<OptionsResponseDTO> options

){


}

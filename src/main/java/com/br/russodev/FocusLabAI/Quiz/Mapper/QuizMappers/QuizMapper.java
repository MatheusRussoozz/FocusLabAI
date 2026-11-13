package com.br.russodev.FocusLabAI.Quiz.Mapper.QuizMappers;

import com.br.russodev.FocusLabAI.Quiz.DTO.QuestionDTOs.QuestionResponseDTO;
import com.br.russodev.FocusLabAI.Quiz.DTO.QuizDTOs.QuizRequestDTO;


import com.br.russodev.FocusLabAI.Quiz.DTO.QuizDTOs.QuizResponseDTO;
import com.br.russodev.FocusLabAI.Quiz.Entity.QuizEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class QuizMapper {


    public QuizResponseDTO toResponse(QuizEntity quizEntity, List<QuestionResponseDTO> questions){
        return new QuizResponseDTO(

                quizEntity.getId(),
                quizEntity.getSubject().getId(),
                questions,
                quizEntity.getDate()

        );
    }

}

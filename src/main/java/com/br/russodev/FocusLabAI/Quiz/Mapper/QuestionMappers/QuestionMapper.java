package com.br.russodev.FocusLabAI.Quiz.Mapper.QuestionMappers;

import com.br.russodev.FocusLabAI.Quiz.DTO.QuestionDTOs.QuestionResponseDTO;
import com.br.russodev.FocusLabAI.Quiz.Entity.QuestionEntity;
import com.br.russodev.FocusLabAI.Quiz.Mapper.OptionsMappers.OptionsMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class QuestionMapper {
    private final OptionsMapper optionsMapper;

    public QuestionMapper(OptionsMapper optionsMapper) {
        this.optionsMapper = optionsMapper;
    }

    public QuestionResponseDTO toResponse(QuestionEntity questionEntity){
        return new QuestionResponseDTO(
                questionEntity.getId(),
                questionEntity.getQuiz().getId(),
                questionEntity.getQuestion(),
                questionEntity.getOptions().stream()
                        .map(optionsMapper::toResponse)
                        .collect(Collectors.toList())

        );
    }


}

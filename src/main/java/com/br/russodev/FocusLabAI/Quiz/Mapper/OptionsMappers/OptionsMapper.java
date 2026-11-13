package com.br.russodev.FocusLabAI.Quiz.Mapper.OptionsMappers;

import com.br.russodev.FocusLabAI.Quiz.DTO.OptionsDTOs.OptionsResponseDTO;
import com.br.russodev.FocusLabAI.Quiz.Entity.OptionsEntity;
import org.springframework.stereotype.Component;

@Component
public class OptionsMapper {

    public OptionsResponseDTO toResponse(OptionsEntity optionsEntity){
        return new OptionsResponseDTO(
                optionsEntity.getId(),
                optionsEntity.getQuestion().getId(),
                optionsEntity.getOption()

        );
    }

}

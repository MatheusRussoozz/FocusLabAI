package com.br.russodev.FocusLabAI.Subject.Mapper;

import com.br.russodev.FocusLabAI.Subject.DTO.SubjectRequestDTO;
import com.br.russodev.FocusLabAI.Subject.DTO.SubjectResponseDTO;
import com.br.russodev.FocusLabAI.Subject.Entity.SubjectEntity;
import org.springframework.stereotype.Component;

@Component
public class SubjectMapper {

    public SubjectEntity toEntity(SubjectRequestDTO requestDTO){
        return new SubjectEntity(

                requestDTO.name(),
                requestDTO.description(),
                requestDTO.weeklyGoal()

        );
    }

    public SubjectResponseDTO toResponse(SubjectEntity subjectEntity){
        return new SubjectResponseDTO(

                subjectEntity.getName(),
                subjectEntity.getDescription(),
                subjectEntity.getWeeklyGoal()

        );
    }

}

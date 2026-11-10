package com.br.russodev.FocusLabAI.StudySession.Mapper;

import com.br.russodev.FocusLabAI.StudySession.DTO.StudySessionRequestDTO;
import com.br.russodev.FocusLabAI.StudySession.DTO.StudySessionResponseDTO;
import com.br.russodev.FocusLabAI.StudySession.Entity.StudySessionEntity;
import org.springframework.stereotype.Component;

@Component
public class StudySessionMapper {

    public StudySessionEntity toRequest(StudySessionRequestDTO requestDTO){
        return new StudySessionEntity(

                requestDTO.subject(),
                requestDTO.date(),
                requestDTO.minutes(),
                requestDTO.notes()

        );
    }

    public StudySessionResponseDTO toResponse(StudySessionEntity sessionEntity){
        return new StudySessionResponseDTO(

                sessionEntity.getSubject(),
                sessionEntity.getDate(),
                sessionEntity.getMinutes(),
                sessionEntity.getNotes()

        );

    }


}

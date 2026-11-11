package com.br.russodev.FocusLabAI.StudySession.Mapper;

import com.br.russodev.FocusLabAI.StudySession.DTO.StudySessionRequestDTO;
import com.br.russodev.FocusLabAI.StudySession.DTO.StudySessionResponseDTO;
import com.br.russodev.FocusLabAI.StudySession.Entity.StudySessionEntity;
import com.br.russodev.FocusLabAI.Subject.Mapper.SubjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudySessionMapper {
    private final SubjectMapper subjectMapper;

    public StudySessionEntity toRequest(StudySessionRequestDTO requestDTO){
        return new StudySessionEntity(
                requestDTO.date(),
                requestDTO.minutes(),
                requestDTO.notes()

        );
    }

    public StudySessionResponseDTO toResponse(StudySessionEntity sessionEntity){
        return new StudySessionResponseDTO(

                subjectMapper.toResponse(sessionEntity.getSubject()),
                sessionEntity.getDate(),
                sessionEntity.getMinutes(),
                sessionEntity.getNotes()

        );

    }


}

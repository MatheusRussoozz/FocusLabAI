package com.br.russodev.FocusLabAI.StudySession.Service;

import com.br.russodev.FocusLabAI.Exceptions.StudySessionException;
import com.br.russodev.FocusLabAI.StudySession.DTO.StudySessionRequestDTO;
import com.br.russodev.FocusLabAI.StudySession.DTO.StudySessionResponseDTO;
import com.br.russodev.FocusLabAI.StudySession.Entity.StudySessionEntity;
import com.br.russodev.FocusLabAI.StudySession.Mapper.StudySessionMapper;
import com.br.russodev.FocusLabAI.StudySession.Repository.StudySessionRepository;
import com.br.russodev.FocusLabAI.Subject.Entity.SubjectEntity;
import com.br.russodev.FocusLabAI.Subject.Repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudySessionService {

    private final StudySessionRepository studySessionRepository;
    private final SubjectRepository subjectRepository;
    private final StudySessionMapper studySessionMapper;

    public StudySessionResponseDTO insert(StudySessionRequestDTO requestDTO){
        Optional<SubjectEntity> findBySubject = subjectRepository.findById(requestDTO.subjectId());
        if (findBySubject.isPresent()){
            if (requestDTO.date().isAfter(LocalDateTime.now())){
                throw new StudySessionException("You cannot register future dates.");
            }
            StudySessionEntity newSession = studySessionMapper.toRequest(requestDTO);
            newSession.setSubject(findBySubject.get());
            StudySessionEntity save =  studySessionRepository.save(newSession);
            return studySessionMapper.toResponse(save);

        }
        throw new StudySessionException("The ID must refer to an existing subject.");
    }

    public List<StudySessionResponseDTO> findAll(){
        List<StudySessionEntity> entityList = studySessionRepository.findAll();
            return entityList.stream()
                    .map(studySessionMapper::toResponse)
                    .collect(Collectors.toList());

    }

    public List<StudySessionResponseDTO> findBySubjectSession(Long id){
        List<StudySessionEntity> findSubject = studySessionRepository.findBySubject_id(id);
            return findSubject.stream()
                    .map(studySessionMapper::toResponse)
                    .collect(Collectors.toList());

    }



}

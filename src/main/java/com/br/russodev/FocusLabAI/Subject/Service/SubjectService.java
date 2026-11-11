package com.br.russodev.FocusLabAI.Subject.Service;

import com.br.russodev.FocusLabAI.StudySession.Repository.StudySessionRepository;
import com.br.russodev.FocusLabAI.Subject.DTO.SubjectRequestDTO;
import com.br.russodev.FocusLabAI.Subject.DTO.SubjectResponseDTO;
import com.br.russodev.FocusLabAI.Subject.Entity.SubjectEntity;
import com.br.russodev.FocusLabAI.Exceptions.SubjectException;
import com.br.russodev.FocusLabAI.Exceptions.SubjectNotFoundException;
import com.br.russodev.FocusLabAI.Subject.Mapper.SubjectMapper;
import com.br.russodev.FocusLabAI.Subject.Repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;
    private final StudySessionRepository studySessionRepository;


    public List<SubjectResponseDTO> subjectList(){
        List<SubjectEntity> findSubject = subjectRepository.findAll();
            return findSubject.stream()
                    .map(subjectMapper::toResponse)
                    .collect(Collectors.toList());

    }

    public SubjectResponseDTO subjectFindById(Long id){
        Optional<SubjectEntity> findSubject = subjectRepository.findById(id);
        if (findSubject.isPresent()){
           return subjectMapper.toResponse(findSubject.get());

        }else {
            throw new SubjectNotFoundException();
        }
    }

    public SubjectResponseDTO createSubject(SubjectRequestDTO requestDTO){

        SubjectEntity subject = subjectMapper.toEntity(requestDTO);
        SubjectEntity subjectSave = subjectRepository.save(subject);
        return subjectMapper.toResponse(subjectSave);

    }

    public SubjectResponseDTO updateSubject(Long id, SubjectRequestDTO requestDTO){
        Optional<SubjectEntity> findSubject = subjectRepository.findById(id);
        if (findSubject.isPresent()){
                findSubject.get().setName(requestDTO.name());
                findSubject.get().setDescription(requestDTO.description());
                findSubject.get().setWeeklyGoal(requestDTO.weeklyGoal());
                SubjectEntity saveSubject = subjectRepository.save(findSubject.get());
                return subjectMapper.toResponse(saveSubject);
        }
        else {
            throw new SubjectNotFoundException();
        }

    }

    public void deleteSubject(Long id){
        Optional<SubjectEntity> findSubject = subjectRepository.findById(id);
        if (findSubject.isPresent()){
            if (studySessionRepository.existsBySubject_id(id)){
                throw new SubjectException("Cannot delete this subject because it has associated study sessions.");
            }
            subjectRepository.delete(findSubject.get());
        }else{
            throw new SubjectNotFoundException();
        }
    }




}

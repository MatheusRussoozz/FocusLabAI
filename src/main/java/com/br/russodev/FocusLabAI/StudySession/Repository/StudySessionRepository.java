package com.br.russodev.FocusLabAI.StudySession.Repository;

import com.br.russodev.FocusLabAI.StudySession.Entity.StudySessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudySessionRepository extends JpaRepository<StudySessionEntity, Long> {

     boolean existsBySubject_id(Long id);
     List<StudySessionEntity> findBySubject_id(Long id);

}


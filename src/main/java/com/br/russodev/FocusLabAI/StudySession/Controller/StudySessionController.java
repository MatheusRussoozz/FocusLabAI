package com.br.russodev.FocusLabAI.StudySession.Controller;

import com.br.russodev.FocusLabAI.StudySession.DTO.StudySessionRequestDTO;
import com.br.russodev.FocusLabAI.StudySession.DTO.StudySessionResponseDTO;
import com.br.russodev.FocusLabAI.StudySession.Service.StudySessionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/session")
public class StudySessionController {

    private final StudySessionService studySessionService;

    public StudySessionController(StudySessionService studySessionService) {
        this.studySessionService = studySessionService;
    }

    @GetMapping()
    public ResponseEntity<List<StudySessionResponseDTO>> findAll(){
        return ResponseEntity.ok(studySessionService.findAll());
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<List<StudySessionResponseDTO>> findBySubject(@PathVariable Long id){
        return ResponseEntity.ok(studySessionService.findBySubjectSession(id));
    }

    @PostMapping()
    public ResponseEntity<StudySessionResponseDTO> insert (@RequestBody @Valid StudySessionRequestDTO requestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(studySessionService.insert(requestDTO));
    }


}

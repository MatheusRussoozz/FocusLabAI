package com.br.russodev.FocusLabAI.Subject.Controller;

import com.br.russodev.FocusLabAI.Subject.DTO.SubjectRequestDTO;
import com.br.russodev.FocusLabAI.Subject.DTO.SubjectResponseDTO;
import com.br.russodev.FocusLabAI.Subject.Service.SubjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping()
    public ResponseEntity<List<SubjectResponseDTO>> list(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(subjectService.subjectList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectResponseDTO> listById (@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(subjectService.subjectFindById(id));
    }

    @PostMapping()
    public ResponseEntity<SubjectResponseDTO> insert(@RequestBody @Valid SubjectRequestDTO requestDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(subjectService.createSubject(requestDTO));

    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectResponseDTO> update(@PathVariable Long id, @RequestBody @Valid SubjectRequestDTO requestDTO){

        return ResponseEntity.status(HttpStatus.OK)
                .body(subjectService.updateSubject(id, requestDTO));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        subjectService.deleteSubject(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

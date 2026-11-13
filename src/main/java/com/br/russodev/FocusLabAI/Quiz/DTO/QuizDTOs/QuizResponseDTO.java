    package com.br.russodev.FocusLabAI.Quiz.DTO.QuizDTOs;

    import com.br.russodev.FocusLabAI.Quiz.DTO.QuestionDTOs.QuestionResponseDTO;
    import com.br.russodev.FocusLabAI.Subject.Entity.SubjectEntity;

    import java.time.LocalDateTime;
    import java.util.List;

    public record QuizResponseDTO(
            Long id,
            Long subjectId,
            List<QuestionResponseDTO> questions,
            LocalDateTime date

    ) {
    }

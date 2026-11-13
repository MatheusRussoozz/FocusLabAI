package com.br.russodev.FocusLabAI.Quiz.Entity;

import com.br.russodev.FocusLabAI.Subject.Entity.SubjectEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuizEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "subject_id", nullable = false)
    private SubjectEntity subject;

    @Column(name = "date")
    private LocalDateTime date = LocalDateTime.now();


    public QuizEntity(SubjectEntity subject) {
        this.subject = subject;
    }
}

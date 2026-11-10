package com.br.russodev.FocusLabAI.StudySession.Entity;

import com.br.russodev.FocusLabAI.Subject.Entity.SubjectEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "study_session" )
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudySessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "subject_id",nullable = false)
    private SubjectEntity subject;

    @Column(name ="date")
    private LocalDateTime date;

    @Column(name = "minutes")
    private Integer minutes;

    @Column(name = "notes")
    private String notes;

    public StudySessionEntity(SubjectEntity subject, LocalDateTime date, Integer minutes, String notes) {
        this.subject = subject;
        this.date = date;
        this.minutes = minutes;
        this.notes = notes;
    }
}

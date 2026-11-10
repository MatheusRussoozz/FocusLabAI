package com.br.russodev.FocusLabAI.Subject.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "subject")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "weekly_goal")
    private String weeklyGoal;


    public SubjectEntity(String name, String description, String weeklyGoal) {
        this.name = name;
        this.description = description;
        this.weeklyGoal = weeklyGoal;
    }
}

package com.pca.schoolcalendar.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "academic_subject")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AcademicSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "course_academic_subject",
            joinColumns = @JoinColumn(name = "fk_id_academic_subject", nullable = false),
            inverseJoinColumns = @JoinColumn(name="fk_id_course", nullable = false))
    private List<Course> courses;
}

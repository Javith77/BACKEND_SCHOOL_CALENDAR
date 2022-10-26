package com.pca.schoolcalendar.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "academic_subject")
@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class AcademicSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "academicSubjects")
    private List<Teacher> teachers;

//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "academicSubjects")
//    private List<Course> courses;
}

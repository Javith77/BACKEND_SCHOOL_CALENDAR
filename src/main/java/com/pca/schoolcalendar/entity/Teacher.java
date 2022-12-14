package com.pca.schoolcalendar.entity;

import com.pca.schoolcalendar.dto.AcademicSubjectDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "teacher")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type_document")
    private String typeDocument;

    @Column(name = "document")
    private String document;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "genre")
    private String genre;

    @Column(name = "address")
    private String address;

    @Column(name = "academic_level")
    private String academicLevel;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "academic_subject_teacher",
            joinColumns = @JoinColumn(name = "fk_id_teacher", nullable = false),
            inverseJoinColumns = @JoinColumn(name="fk_id_academic_subject", nullable = false))
    private List<AcademicSubject> academicSubjects;

}

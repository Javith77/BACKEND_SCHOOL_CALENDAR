package com.pca.schoolcalendar.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.pca.schoolcalendar.entity.AcademicSubject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDTO {

    private Integer id;

    private String academicSubjet;

    @NotNull
    private Integer idCourse;

    @NotNull
    private Integer idAcademicSubject;

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+5")
    @NotNull
    private Date start;

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+5")
    @NotNull
    private Date end;

    @JsonIgnore
    private CourseDTO course;

    @JsonIgnore
    private AcademicSubject academicSubject;

}

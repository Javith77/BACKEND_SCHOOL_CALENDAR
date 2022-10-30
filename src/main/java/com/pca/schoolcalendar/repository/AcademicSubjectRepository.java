package com.pca.schoolcalendar.repository;

import com.pca.schoolcalendar.entity.AcademicSubject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademicSubjectRepository extends CrudRepository<AcademicSubject, Integer> {

    @Query(value = "SELECT * FROM schoolcalendar.academic_subject acs " +
            "INNER JOIN schoolcalendar.course_academic_subject cas ON cas.fk_id_academic_subject = acs.id " +
            "WHERE cas.fk_id_course = ?1",
    nativeQuery = true)
    List<AcademicSubject> findAllByCourseNotNull(Integer idCourse);

    List<AcademicSubject> findAllByTeachersNotNull();
}

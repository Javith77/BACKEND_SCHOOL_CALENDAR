package com.pca.schoolcalendar.repository;

import com.pca.schoolcalendar.entity.AcademicSubject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademicSubjectRepository extends CrudRepository<AcademicSubject, Integer> {

    List<AcademicSubject> findAllByTeachersNotNull();
}

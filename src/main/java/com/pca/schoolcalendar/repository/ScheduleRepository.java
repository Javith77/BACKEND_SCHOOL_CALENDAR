package com.pca.schoolcalendar.repository;

import com.pca.schoolcalendar.entity.Schedule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {

    @Query(value = "SELECT * FROM schoolcalendar.schedule sc " +
            "INNER JOIN schoolcalendar.course co ON co.id = sc.fk_id_course " +
            "INNER JOIN schoolcalendar.academic_subject asu ON asu.id = sc.fk_id_academic_subject " +
            "WHERE co.id = ?1",
            nativeQuery = true)
    List<Schedule> findAllByCourse(Integer idCourse);

    @Query(value = "SELECT COUNT(sc.id) FROM schoolcalendar.schedule sc " +
            "WHERE sc.fk_id_course = ?1 " +
            "AND ((?2 >= cast(sc.start_date as timestamp(0)) AND ?2 < cast (sc.end_date as timestamp(0))) " +
            "OR (?3 > cast(sc.start_date as timestamp(0)) AND ?3 <= cast (sc.end_date as timestamp(0)))) ",
            nativeQuery = true)
    Integer countByTimeRange(Integer idCourse, Date start, Date end);
}

package com.pca.schoolcalendar.repository;

import com.pca.schoolcalendar.entity.Schedule;
import org.springframework.data.repository.CrudRepository;

public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {
}

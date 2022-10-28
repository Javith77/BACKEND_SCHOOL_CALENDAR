package com.pca.schoolcalendar.service;

import com.pca.schoolcalendar.dto.ScheduleDTO;
import com.pca.schoolcalendar.response.MessageResponse;

import java.util.List;

public interface IScheduleService {

    MessageResponse save(ScheduleDTO scheduleDTO);

    MessageResponse update(Integer id, ScheduleDTO scheduleDTO);

    MessageResponse delete(Integer id);

    List<ScheduleDTO> findAllByIdCourse(Integer idCourse);

    List<ScheduleDTO> findAll();

}

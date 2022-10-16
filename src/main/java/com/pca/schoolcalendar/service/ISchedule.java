package com.pca.schoolcalendar.service;

import com.pca.schoolcalendar.dto.ScheduleDTO;
import com.pca.schoolcalendar.response.MessageResponse;

import java.util.List;

public interface ISchedule {

    MessageResponse save(ScheduleDTO scheduleDTO);

    MessageResponse update(Integer id, ScheduleDTO scheduleDTO);

    MessageResponse delete(Integer id);

    ScheduleDTO findById(Integer id);

    List<ScheduleDTO> findAll();

}

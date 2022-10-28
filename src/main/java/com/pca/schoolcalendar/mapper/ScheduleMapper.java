package com.pca.schoolcalendar.mapper;

import com.pca.schoolcalendar.dto.ScheduleDTO;
import com.pca.schoolcalendar.entity.Schedule;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ScheduleMapper {

    private final ModelMapper modelmapper;


    /**
     * convert Entity to Dto
     * @param schedule entity
     * @return ScheduleDTO dto
     */
    public ScheduleDTO mapToDto(Schedule schedule) {
        return modelmapper.map(schedule, ScheduleDTO.class);
    }

    /**
     * convert Dto to Entity
     * @param scheduleDto dto
     * @return Schedule entity
     */
    public Schedule mapToEntity(ScheduleDTO scheduleDto) {
        return modelmapper.map(scheduleDto, Schedule.class);
    }
}

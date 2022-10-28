package com.pca.schoolcalendar.service.implementation;

import com.pca.schoolcalendar.dto.ScheduleDTO;
import com.pca.schoolcalendar.entity.AcademicSubject;
import com.pca.schoolcalendar.entity.Course;
import com.pca.schoolcalendar.entity.Schedule;
import com.pca.schoolcalendar.exception.ResourceNotFoundException;
import com.pca.schoolcalendar.mapper.ScheduleMapper;
import com.pca.schoolcalendar.repository.AcademicSubjectRepository;
import com.pca.schoolcalendar.repository.CourseRepository;
import com.pca.schoolcalendar.repository.ScheduleRepository;
import com.pca.schoolcalendar.response.MessageResponse;
import com.pca.schoolcalendar.service.IScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ScheduleImpl implements IScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final AcademicSubjectRepository academicSubjectRepository;
    private final CourseRepository courseRepository;
    private final ScheduleMapper scheduleMapper;
    private static final String RESOURCE_NAME = "Schedule";
    private static final String RESOURCE_ACADEMIC_SUBJECT = "AcademicSubject";
    private static final String RESOURCE_NAME_COURSE = "Course";

    @Override
    public MessageResponse save(ScheduleDTO scheduleDto) {
        Optional<Course> course = courseRepository.findById(scheduleDto.getIdCourse());
        if(course.isEmpty()){
            throw new ResourceNotFoundException(RESOURCE_NAME_COURSE, "id", scheduleDto.getIdCourse());
        }

        Optional<AcademicSubject> academicSubject = academicSubjectRepository.findById(scheduleDto.getIdAcademicSubject());
        if(academicSubject.isEmpty()){
            throw new ResourceNotFoundException(RESOURCE_ACADEMIC_SUBJECT, "id", scheduleDto.getIdAcademicSubject());
        }

        Schedule schedule = scheduleMapper.mapToEntity(scheduleDto);
        schedule.setCourse(course.get());
        schedule.setAcademicSubject(academicSubject.get());

        Schedule scheduleSaved = scheduleRepository.save(schedule);
        return new MessageResponse(HttpStatus.CREATED.value(), new Date(),
                "Registro guardado con éxito",
                scheduleMapper.mapToDto(scheduleSaved));
    }

    @Override
    public MessageResponse update(Integer id, ScheduleDTO scheduleDTO) {
        return null;
    }

    @Override
    public MessageResponse delete(Integer id) {
        return null;
    }

    @Override
    public List<ScheduleDTO> findAllByIdCourse(Integer idCourse) {
        List<Schedule> schedules = scheduleRepository.findAllByCourse(idCourse);
        //convert list entity to dto
        return schedules.stream()
                .map(scheduleMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDTO> findAll() {
        return null;
    }
}

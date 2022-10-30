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

import java.time.*;
import java.util.*;
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
    private static final LocalDate INITIAL_PERIOD = LocalDate.of(2022, Month.SEPTEMBER, 1);
    private static final LocalDate FINAL_PERIOD = LocalDate.of(2022, Month.NOVEMBER, 25);
//    private static final String INITIAL_PERIOD = "2022-02-08";
//    private static final String FINAL_PERIOD = "2022-11-25";

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
        List<Schedule> schedules = this.propagateDates(schedule);
        scheduleRepository.saveAll(schedules);

        return new MessageResponse(HttpStatus.CREATED.value(), new Date(),
                "Registro guardado con éxito",
                scheduleMapper.mapToDto(schedule));
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

    private List<Schedule> propagateDates(Schedule schedule){
        List<Schedule> schedulesList = new ArrayList<>();
        LocalDate initialDate = INITIAL_PERIOD;
        LocalDate localDate = this.convertToLocalDate(schedule.getStart());
        int dayOfWeek = this.getDayOfWeek(localDate);
        do {
            if(this.getDayOfWeek(initialDate) == dayOfWeek){
                Date newStartDate = this.convertToDate(schedule.getStart(), initialDate);
                Date newEndDate = this.convertToDate(schedule.getEnd(), initialDate);
                schedulesList.add(new Schedule(schedule.getId(), newStartDate, newEndDate, schedule.getCourse(), schedule.getAcademicSubject()));
                //plus 7 days a week
                initialDate = initialDate.plusDays(7);
            }else{
                //plus 1 day
                initialDate = initialDate.plusDays(1);
            }
        } while (initialDate.isAfter(INITIAL_PERIOD) && initialDate.isBefore(FINAL_PERIOD));

        return schedulesList;
    }

    private int getDayOfWeek(LocalDate date){
        DayOfWeek day = date.getDayOfWeek();
        return day.getValue();
    }

    private Date convertToDate(Date start, LocalDate initialDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        calendar.set(initialDate.getYear(), initialDate.getMonthValue() -1, initialDate.getDayOfMonth());
        return calendar.getTime();
    }

    private LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}

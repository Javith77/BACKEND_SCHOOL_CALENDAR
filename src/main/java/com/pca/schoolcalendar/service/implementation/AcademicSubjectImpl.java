package com.pca.schoolcalendar.service.implementation;

import com.pca.schoolcalendar.dto.AcademicSubjectDTO;
import com.pca.schoolcalendar.dto.AssignmentsDTO;
import com.pca.schoolcalendar.entity.AcademicSubject;
import com.pca.schoolcalendar.entity.Course;
import com.pca.schoolcalendar.exception.ResourceNotFoundException;
import com.pca.schoolcalendar.mapper.AcademicSubjectMapper;
import com.pca.schoolcalendar.repository.AcademicSubjectRepository;
import com.pca.schoolcalendar.repository.CourseRepository;
import com.pca.schoolcalendar.response.MessageResponse;
import com.pca.schoolcalendar.service.IAcademicSubjectService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Slf4j
@Service
public class AcademicSubjectImpl implements IAcademicSubjectService {

    private final AcademicSubjectRepository academicSubjectRepository;
//    private final CourseRepository courseRepository;
    private final AcademicSubjectMapper academicSubjectMapper;
    private static final String RESOURCE_NAME = "AcademicSubject";
    private static final String RESOURCE_NAME_COURSE = "Course";

    @Override
    public MessageResponse save(AcademicSubjectDTO academicSubjectDto) {
        //convert dto to entity
        AcademicSubject academicSubject = academicSubjectMapper.mapToEntity(academicSubjectDto);
        AcademicSubject newStudent = academicSubjectRepository.save(academicSubject);
        return new MessageResponse(HttpStatus.CREATED.value(), new Date(),
                "Registro guardado con éxito",
                academicSubjectMapper.mapToDto(newStudent));
    }

    @Override
    public MessageResponse update(Integer id, AcademicSubjectDTO academicSubjectDto) {
        Optional<AcademicSubject> academicSubject = academicSubjectRepository.findById(id);
        if(academicSubject.isEmpty()){
            throw new ResourceNotFoundException(RESOURCE_NAME, "id", id);
        }
        //update data
        academicSubject.get().setDescription(academicSubjectDto.getDescription());
        //save data
        academicSubjectRepository.save(academicSubject.get());
        return new MessageResponse(HttpStatus.CREATED.value(), new Date(),
                "Registro actualizado con éxito",
                academicSubjectMapper.mapToDto(academicSubject.get()));
    }

    @Override
    public MessageResponse delete(Integer id) {
        AcademicSubject academicSubject = academicSubjectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(RESOURCE_NAME, "id", id));
        academicSubjectRepository.delete(academicSubject);
        return new MessageResponse(HttpStatus.OK.value(), new Date(),
                "Registro eliminado con éxito",
                academicSubjectMapper.mapToDto(academicSubject));
    }

    @Override
    public AcademicSubjectDTO findById(Integer id) {
        AcademicSubject academicSubject = academicSubjectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(RESOURCE_NAME, "id", id));
        //convert entity to dto and return
        return academicSubjectMapper.mapToDto(academicSubject);
    }

    @Override
    public List<AcademicSubjectDTO> findAllByIdCourse(Integer idCourse) {
        List<AcademicSubject> academicSubject = academicSubjectRepository.findAllByCourseNotNull(idCourse);
        //convert list entity to dto
        return academicSubject.stream()
                .distinct()
                .map(academicSubjectMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AcademicSubjectDTO> findAllWithTeacherAssigned() {
        List<AcademicSubject> academicSubject = academicSubjectRepository.findAllByTeachersNotNull();
        //convert list entity to dto
        return academicSubject.stream()
                .distinct()
                .map(academicSubjectMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AcademicSubjectDTO> findAll() {
        List<AcademicSubject> academicSubject = (List<AcademicSubject>) academicSubjectRepository.findAll();
        //convert list entity to dto
        return academicSubject.stream()
                .map(academicSubjectMapper::mapToDto)
                .collect(Collectors.toList());
    }
}

package com.pca.schoolcalendar.service.implementation;

import com.pca.schoolcalendar.dto.AcademicSubjectDTO;
import com.pca.schoolcalendar.dto.TeacherDTO;
import com.pca.schoolcalendar.entity.AcademicSubject;
import com.pca.schoolcalendar.entity.Student;
import com.pca.schoolcalendar.entity.Teacher;
import com.pca.schoolcalendar.exception.ResourceNotFoundException;
import com.pca.schoolcalendar.mapper.AcademicSubjectMapper;
import com.pca.schoolcalendar.mapper.StudentMapper;
import com.pca.schoolcalendar.mapper.TeacherMapper;
import com.pca.schoolcalendar.repository.AcademicSubjectRepository;
import com.pca.schoolcalendar.repository.StudentRepository;
import com.pca.schoolcalendar.repository.TeacherRepository;
import com.pca.schoolcalendar.response.MessageResponse;
import com.pca.schoolcalendar.service.ITeacherService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Slf4j
@Service
public class TeacherImpl implements ITeacherService {

    private final TeacherRepository teacherRepository;
    private final AcademicSubjectRepository academicSubjectRepository;
    private final TeacherMapper teacherMapper;
    private final AcademicSubjectMapper academicSubjectMapper;
    private static final String RESOURCE_NAME = "Teacher";

    @Transactional
    @Override
    public MessageResponse save(TeacherDTO teacherDto) {
        List<Integer> ids = teacherDto.getAcademicSubjects().stream()
                .map(AcademicSubjectDTO::getId)
                .collect(Collectors.toList());

        //convert dto to entity
        Teacher teacher = teacherMapper.mapToEntity(teacherDto);
        teacher.setAcademicSubjects(new ArrayList<>());
        Teacher teacherSaved = teacherRepository.save(teacher);

        Iterable<AcademicSubject> academicSubjects = academicSubjectRepository.findAllById(ids);
        //add academic subjects
        academicSubjects.forEach(academicSubject -> teacher.getAcademicSubjects().add(academicSubject));

        log.info("TEACHER:: ", teacherSaved);
        teacherRepository.save(teacherSaved);
        return new MessageResponse(HttpStatus.CREATED.value(), new Date(),
                "Registro guardado con éxito", teacherMapper.mapToDto(teacherSaved));
    }

    @Override
    public MessageResponse update(Integer id, TeacherDTO teacherDto) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if(teacher.isEmpty()){
            throw new ResourceNotFoundException(RESOURCE_NAME, "id", id);
        }
        //remove old items
        teacher.get().setAcademicSubjects(new ArrayList<>());
        //get ids
        List<Integer> ids = teacherDto.getAcademicSubjects().stream()
                .map(AcademicSubjectDTO::getId)
                .collect(Collectors.toList());
        //get all academic subjects with ids
        Iterable<AcademicSubject> academicSubjects = academicSubjectRepository.findAllById(ids);
        //add new academic subjects
        academicSubjects.forEach(academicSubject -> teacher.get().getAcademicSubjects().add(academicSubject));
        //update data
        teacher.get().setTypeDocument(teacherDto.getTypeDocument());
        teacher.get().setDocument(teacherDto.getDocument());
        teacher.get().setName(teacherDto.getName());
        teacher.get().setLastName(teacherDto.getLastName());
        teacher.get().setGenre(teacherDto.getGenre());
        teacher.get().setAddress(teacherDto.getAddress());
        teacher.get().setAcademicLevel(teacherDto.getAcademicLevel());
        //save data
        teacherRepository.save(teacher.get());
        return new MessageResponse(HttpStatus.CREATED.value(), new Date(), "Registro actualizado con éxito", teacherMapper.mapToDto(teacher.get()));
    }

    @Override
    public MessageResponse delete(Integer id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(RESOURCE_NAME, "id", id));
        teacherRepository.delete(teacher);
        return new MessageResponse(HttpStatus.OK.value(), new Date(), "Registro eliminado con éxito", teacherMapper.mapToDto(teacher));
    }

    @Override
    public TeacherDTO findById(Integer id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(RESOURCE_NAME, "id", id));
        //convert entity to dto and return
        return teacherMapper.mapToDto(teacher);
    }

    @Override
    public List<TeacherDTO> findAll() {
        List<Teacher> teachers = (List<Teacher>) teacherRepository.findAll();
        //convert list entity to dto
        return teachers.stream()
                .map(teacherMapper::mapToDto)
                .collect(Collectors.toList());
    }
}

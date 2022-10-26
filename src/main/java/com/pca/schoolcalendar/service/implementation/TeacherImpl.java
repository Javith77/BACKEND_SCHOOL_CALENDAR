package com.pca.schoolcalendar.service.implementation;

import com.pca.schoolcalendar.dto.TeacherDTO;
import com.pca.schoolcalendar.entity.Student;
import com.pca.schoolcalendar.entity.Teacher;
import com.pca.schoolcalendar.exception.ResourceNotFoundException;
import com.pca.schoolcalendar.mapper.StudentMapper;
import com.pca.schoolcalendar.mapper.TeacherMapper;
import com.pca.schoolcalendar.repository.StudentRepository;
import com.pca.schoolcalendar.repository.TeacherRepository;
import com.pca.schoolcalendar.response.MessageResponse;
import com.pca.schoolcalendar.service.ITeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TeacherImpl implements ITeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    private static final String RESOURCE_NAME = "Teacher";

    @Override
    public MessageResponse save(TeacherDTO teacherDto) {
        //convert dto to entity
        Teacher teacher = teacherMapper.mapToEntity(teacherDto);
        Teacher newTeacher = teacherRepository.save(teacher);
        return new MessageResponse(HttpStatus.CREATED.value(), new Date(),
                "Registro guardado con éxito", teacherMapper.mapToDto(newTeacher));
    }

    @Override
    public MessageResponse update(Integer id, TeacherDTO teacherDto) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if(teacher.isEmpty()){
            throw new ResourceNotFoundException(RESOURCE_NAME, "id", id);
        }
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

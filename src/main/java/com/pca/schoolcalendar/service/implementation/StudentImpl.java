package com.pca.schoolcalendar.service.implementation;

import com.pca.schoolcalendar.dto.AssignmentsDTO;
import com.pca.schoolcalendar.dto.StudentDTO;
import com.pca.schoolcalendar.entity.Course;
import com.pca.schoolcalendar.entity.Student;
import com.pca.schoolcalendar.exception.ResourceNotFoundException;
import com.pca.schoolcalendar.mapper.StudentMapper;
import com.pca.schoolcalendar.repository.CourseRepository;
import com.pca.schoolcalendar.repository.StudentRepository;
import com.pca.schoolcalendar.response.MessageResponse;
import com.pca.schoolcalendar.service.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class StudentImpl implements IStudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final StudentMapper studentMapper;
    private static final String RESOURCE_NAME = "Student";
    private static final String RESOURCE_NAME_COURSE = "Course";

    @Override
    public MessageResponse save(StudentDTO StudentDTO) {
        //convert dto to entity
        Student student = studentMapper.mapToEntity(StudentDTO);
        Student newStudent = studentRepository.save(student);
        return new MessageResponse(HttpStatus.CREATED.value(), new Date(), "Registro guardado con éxito", studentMapper.mapToDto(newStudent));
    }

    @Override
    public MessageResponse update(Integer id, StudentDTO studentDto) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isEmpty()){
            throw new ResourceNotFoundException(RESOURCE_NAME, "id", id);
        }
        //update data
        student.get().setTypeDocument(studentDto.getTypeDocument());
        student.get().setDocument(studentDto.getDocument());
        student.get().setName(studentDto.getName());
        student.get().setLastName(studentDto.getLastName());
        student.get().setGenre(studentDto.getGenre());
        student.get().setAddress(studentDto.getAddress());
        //save data
        studentRepository.save(student.get());
        return new MessageResponse(HttpStatus.CREATED.value(), new Date(), "Registro actualizado con éxito", studentMapper.mapToDto(student.get()));
    }

    @Override
    public MessageResponse updateCourseAssignments(Integer idCourse, List<AssignmentsDTO> assignments) {
        Optional<Course> course = courseRepository.findById(idCourse);
        if(course.isEmpty()){
            throw new ResourceNotFoundException(RESOURCE_NAME_COURSE, "id", idCourse);
        }
        assignments.forEach(assignment -> {
                    Student student = studentMapper.mapToEntity(this.findById(assignment.getId()));
                    student.setCourse(assignment.isCheck() ? course.get() : null);
                    studentRepository.save(student);
                });

        return new MessageResponse(HttpStatus.CREATED.value(), new Date(), "Registros actualizados con éxito", null);
    }

    @Override
    public MessageResponse delete(Integer id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(RESOURCE_NAME, "id", id));
        studentRepository.delete(student);
        return new MessageResponse(HttpStatus.OK.value(), new Date(), "Registro eliminado con éxito", studentMapper.mapToDto(student));
    }

    @Override
    public StudentDTO findById(Integer id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(RESOURCE_NAME, "id", id));
        //convert entity to dto and return
        return studentMapper.mapToDto(student);
    }

    @Override
    public List<StudentDTO> findAll() {
        List<Student> students = (List<Student>) studentRepository.findAll();
        //convert list entity to dto
        return students.stream()
                .map(studentMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> findUnassignedCourse() {
        List<Student> students = studentRepository.findStudentByCourseIsNull();
        //convert list entity to dto
        return students.stream()
                .map(studentMapper::mapToDto)
                .collect(Collectors.toList());
    }
}

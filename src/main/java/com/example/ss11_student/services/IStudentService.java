package com.example.ss11_student.services;

import com.example.ss11_student.dto.StudentDTO;
import com.example.ss11_student.model.Student;
import java.util.List;

public interface IStudentService {
    List<StudentDTO> findAll();

    void save(Student student);

    Boolean deleteById(Long id);

    List<Student> findByName(String name);

    Student findById(Long id);

    void update(Long id, Student student);
}

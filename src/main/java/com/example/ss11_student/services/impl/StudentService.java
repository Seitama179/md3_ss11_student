package com.example.ss11_student.services.impl;

import com.example.ss11_student.dto.StudentDTO;
import com.example.ss11_student.model.Student;
import com.example.ss11_student.repositories.IStudentRepository;
import com.example.ss11_student.repositories.impl.StudentRepository;
import com.example.ss11_student.services.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {

    private static IStudentRepository studentRepository = new StudentRepository();

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Boolean deleteById(Long id) {
        return studentRepository.deleteById(id);
    }

    @Override
    public List<StudentDTO> findByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void update(Long id, Student student) {
        studentRepository.update(id,student);
    }
}

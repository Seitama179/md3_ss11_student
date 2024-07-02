package com.example.ss11_student.repositories;

import com.example.ss11_student.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();

    void save(Student student);

    Boolean deleteById(Long id);

    List<Student> findByName(String name);

    Student findById(Long id);

    void update(Long id, Student student);
}

package com.example.ss11_student.services.impl;

import com.example.ss11_student.model.Classroom;
import com.example.ss11_student.repositories.IClassroomRepository;
import com.example.ss11_student.repositories.impl.ClassroomRepository;
import com.example.ss11_student.services.IClassroomService;

import java.util.List;

public class ClassroomService implements IClassroomService {
    private IClassroomRepository classroomRepository = new ClassroomRepository();

    @Override
    public List<Classroom> findAll() {
        return classroomRepository.findAll();
    }
}

package com.example.ss11_student.repositories;

import com.example.ss11_student.model.Classroom;

import java.util.List;

public interface IClassroomRepository {

    List<Classroom> findAll();

}

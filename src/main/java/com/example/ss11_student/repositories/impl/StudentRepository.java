package com.example.ss11_student.repositories.impl;

import com.example.ss11_student.model.Student;
import com.example.ss11_student.repositories.IStudentRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {

    private static List<Student> students;

//    static {
//        students = new ArrayList<>();
//        students.add(new Student(1L, "haiTT", "QN", 10.0f));
//        students.add(new Student(2L, "Bảo Ngọc", "HN", 8.0f));
//        students.add(new Student(3L, "Bảo Kỳ", "DN", 6.0f));
//        students.add(new Student(5L, "Cook", "Bếp", 2f));
//    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement("select * from students");
            ResultSet resultSet = preparedStatement.executeQuery();
            Long id;
            String name;
            String address;
            Float point;
            while (resultSet.next()) {
                id = resultSet.getLong("id");
                name = resultSet.getString("name");
                address = resultSet.getString("address");
                point = resultSet.getFloat("point");
                students.add(new Student(id, name, address, point));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public void save(Student student) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection()
                    .prepareStatement("INSERT INTO students (name, address, point) VALUES (?, ?, ?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getAddress());
            preparedStatement.setFloat(3, student.getPoint());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean deleteById(Long id) {
        boolean isDelete;
        try {
            PreparedStatement statement = BaseRepository.getConnection()
                    .prepareStatement("DELETE FROM students WHERE id=?");
            statement.setLong(1, id);
            isDelete = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isDelete;
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                result.add(student);
            }
        }
        return result;
    }

    @Override
    public Student findById(Long id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void update(Long id, Student student) {
        for (Student student1 : students) {
            if (student1.getId().equals(id)) {
                student1.setName(student.getName());
                student1.setAddress(student.getAddress());
                student1.setPoint(student.getPoint());
            }
        }
    }
}

package com.example.ss11_student.model;

public class Student {

    private Long id;
    private String name;
    private String address;
    private Float point;
    private Long idClass;

    public Student() {
    }

    public Student(Long id, String name, String address, Float point, Long idClass) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.point = point;
        this.idClass = idClass;
    }

    public Student(String name, String address, Float point, Long idClass) {
        this.name = name;
        this.address = address;
        this.point = point;
        this.idClass = idClass;
    }

    public Student(Long id, String name, String address, Float point) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.point = point;
    }

    public Student(String name, String address, Float point) {
        this.name = name;
        this.address = address;
        this.point = point;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getPoint() {
        return point;
    }

    public void setPoint(Float point) {
        this.point = point;
    }

    public Long getIdClass() { return idClass; }

    public void setIdClass(Long idClass) { this.idClass = idClass; }
}

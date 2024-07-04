package com.example.ss11_student.dto;

public class StudentDTO {
    private Long id;
    private String name;
    private String address;
    private Float point;
    private String className;

    public StudentDTO() {
    }

    public StudentDTO(Long id, String name, String address, Float point, String className) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.point = point;
        this.className = className;
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}

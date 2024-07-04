package com.example.ss11_student.model;

public class Classroom {
    private long idClass;
    private String name;

    public Classroom() {
    }

    public Classroom(long idClass, String name) {
        this.idClass = idClass;
        this.name = name;
    }

    public long getIdClass() {
        return idClass;
    }

    public void setIdClass(long idClass) {
        this.idClass = idClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

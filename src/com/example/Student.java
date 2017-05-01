package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bsheen on 4/27/17.
 */
public class Student {

    private int id;
    private String name;
    private List<Clas> studentClasList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Clas> getStudentClasList() {
        return studentClasList;
    }

    public void setStudentClasList(List<Clas> studentClasList) {
        this.studentClasList = studentClasList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

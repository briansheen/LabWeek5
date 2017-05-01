package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bsheen on 4/27/17.
 */
public class Clas {

    private int id;
    private String name;
    private List<Student> clasStudentList = new ArrayList<>();


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

    public List<Student> getClasStudentList() {
        return clasStudentList;
    }

    public void setClasStudentList(List<Student> clasStudentList) {
        this.clasStudentList = clasStudentList;
    }

    @Override
    public String toString() {
        return "Clas{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

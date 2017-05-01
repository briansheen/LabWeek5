package com.example;

import javax.sound.midi.Soundbank;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bsheen on 4/27/17.
 */
public class StudentDao {

    public static void addStudent(Connection connection, Student student) throws SQLException {
        ResultSet rs = null;
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, student.getName());
        preparedStatement.executeUpdate();
        rs = preparedStatement.getGeneratedKeys();
        rs.next();
        student.setId(rs.getInt(1));
        System.out.println("Student " + student.getName() + " created with Student ID: " + student.getId());
    }

    public static List<Student> printStudents(Connection connection) throws SQLException {
        ResultSet rs = null;
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student");
        rs = preparedStatement.executeQuery();
        List<Student> studentList = new ArrayList<>();
        while (rs.next()) {
            Student student = new Student();
            student.setId(rs.getInt(1));
            student.setName(rs.getString(2));
            studentList.add(student);
        }
        return studentList;
    }

    public static void assignStu2Clas(Connection connection, Student student, Clas clas) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO clasassign (student_id, clas_id) VALUES (?, ?)");
        preparedStatement.setString(1, String.valueOf(student.getId()));
        preparedStatement.setString(2, String.valueOf(clas.getId()));
        preparedStatement.executeUpdate();
    }

    public static Student printStuClas(Connection connection, Student student) throws SQLException {
        ResultSet rs = null;
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT s.id, s.name, c.id, c.name FROM student s, clas c, clasassign ca WHERE s.id = ? and s.id = ca.student_id and c.id = ca.clas_id");
        preparedStatement.setString(1, String.valueOf(student.getId()));
        rs = preparedStatement.executeQuery();
        while (rs.next()) {
            Clas clas = new Clas();
            clas.setId(rs.getInt(3));
            clas.setName(rs.getString(4));
            student.getStudentClasList().add(clas);
        }
        return student;
    }

    public static void deleteStudent(Connection connection, Student student) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM student WHERE student.id = ?");
        preparedStatement.setString(1,String.valueOf(student.getId()));
        preparedStatement.executeUpdate();
    }

    public static void removeStuClas(Connection connection, Student student, Clas clas) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM clasassign WHERE student_id = ? AND clas_id = ?");
        preparedStatement.setString(1, String.valueOf(student.getId()));
        preparedStatement.setString(2, String.valueOf(clas.getId()));
        preparedStatement.executeUpdate();
    }

}

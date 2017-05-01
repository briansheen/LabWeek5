package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bsheen on 4/27/17.
 */
public class ClasDao {

    public static void addClas(Connection connection, Clas clas) throws SQLException {
        ResultSet rs = null;
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO clas (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, clas.getName());
        preparedStatement.executeUpdate();
        rs = preparedStatement.getGeneratedKeys();
        rs.next();
        clas.setId(rs.getInt(1));
        System.out.println("Class " + clas.getName() + " created with Class ID: " + clas.getId());
    }

    public static List<Clas> printClases(Connection connection) throws SQLException {
        ResultSet rs = null;
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM clas");
        rs = preparedStatement.executeQuery();
        List<Clas> clasList = new ArrayList<>();
        while (rs.next()) {
            Clas clas = new Clas();
            clas.setId(rs.getInt(1));
            clas.setName(rs.getString(2));
            clasList.add(clas);
        }
        return clasList;
    }

    public static Clas printClasStu(Connection connection, Clas clas) throws SQLException {
        ResultSet rs = null;
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT c.id, c.name, s.id, s.name FROM student s, clas c, clasassign ca WHERE c.id = ? and s.id = ca.student_id and c.id = ca.clas_id");
        preparedStatement.setString(1, String.valueOf(clas.getId()));
        rs = preparedStatement.executeQuery();
        while (rs.next()) {
            Student student = new Student();
            student.setId(rs.getInt(3));
            student.setName(rs.getString(4));
            clas.getClasStudentList().add(student);
        }
        return clas;
    }

    public static void deleteClas(Connection connection, Clas clas) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM clas WHERE clas.id = ?");
        preparedStatement.setString(1,String.valueOf(clas.getId()));
        preparedStatement.executeUpdate();
    }
}


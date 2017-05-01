package com.example;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by bsheen on 4/27/17.
 */
public class SchoolService {

    public static void addStudent(Student student) throws EnrollmentException {
        Connection connection = null;
        try {
            connection = DatabaseUtils.getInstance().getConnection();
            connection.setAutoCommit(false);
            StudentDao.addStudent(connection, student);
            connection.commit();
        } catch (SQLException e) {
            System.out.println("SQL Exception in SchoolService.addStudent. " + e.getMessage());
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e1) {
                System.out.println("SQL Exception in SchoolService.addStudent Rollback. " + e1.getMessage());
            }
            throw new EnrollmentException("Could not add Student\n");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("SQL Exception in SchoolService.addStudent Close. " + e.getMessage());
            }

        }
    }

    public static void addClas(Clas clas) throws EnrollmentException {
        Connection connection = null;
        try {
            connection = DatabaseUtils.getInstance().getConnection();
            connection.setAutoCommit(false);
            ClasDao.addClas(connection, clas);
            connection.commit();
        } catch (SQLException e) {
            System.out.println("SQL Exception in SchoolService.addClas. " + e.getMessage());
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e1) {
                System.out.println("SQL Exception in SchoolService.addClas Rollback. " + e1.getMessage());
            }
            throw new EnrollmentException("Could not add class\n");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("SQL Exception in SchoolService.addClas Close. " + e.getMessage());
            }

        }
    }

    public static List<Student> printStudents() throws EnrollmentException {
        Connection connection = null;
        try {
            connection = DatabaseUtils.getInstance().getConnection();
            connection.setAutoCommit(false);
            List<Student> studentList = StudentDao.printStudents(connection);
            connection.commit();
            return studentList;
        } catch (SQLException e) {
            System.out.println("SQL Exception in SchoolService.printStudents. " + e.getMessage());
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e1) {
                System.out.println("SQL Exception in SchoolService.printStudents Rollback. " + e1.getMessage());
            }
            throw new EnrollmentException("Could not read students at this time.\n");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("SQL Exception in SchoolService.printStudents Close. " + e.getMessage());
            }
        }
    }

    public static List<Clas> printClases() throws EnrollmentException {
        Connection connection = null;
        try {
            connection = DatabaseUtils.getInstance().getConnection();
            connection.setAutoCommit(false);
            List<Clas> clasList = ClasDao.printClases(connection);
            connection.commit();
            return clasList;
        } catch (SQLException e) {
            System.out.println("SQL Exception in SchoolService.printClases. " + e.getMessage());
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e1) {
                System.out.println("SQL Exception in SchoolService.printClases Rollback. " + e1.getMessage());
            }
            throw new EnrollmentException("Could not read classes at this time.\n");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("SQL Exception in SchoolService.printClases Close. " + e.getMessage());
            }
        }
    }

    public static void assignStu2Clas(Student student, Clas clas) throws EnrollmentException {
        Connection connection = null;
        try {
            connection = DatabaseUtils.getInstance().getConnection();
            connection.setAutoCommit(false);
            StudentDao.assignStu2Clas(connection, student, clas);
            connection.commit();
        } catch (SQLException e) {
            System.out.println("SQL Exception in SchoolService.assigneStu2Clas. " + e.getMessage());
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e1) {
                System.out.println("SQL Exception in SchoolService.assignStu2Clas Rollback. " + e1.getMessage());
            }
            throw new EnrollmentException("Could not enroll Student in that Class\n");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("SQL Exception in SchoolService.assignStu2Clas Close. " + e.getMessage());
            }
        }
    }

    public static Student printStuClas(Student student) throws EnrollmentException {
        Connection connection = null;
        try {
            connection = DatabaseUtils.getInstance().getConnection();
            connection.setAutoCommit(false);
            student = StudentDao.printStuClas(connection, student);
            connection.commit();
            return student;
        } catch (SQLException e) {
            System.out.println("SQL Exception in SchoolService.printStuClas. " + e.getMessage());
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e1) {
                System.out.println("SQL Exception in SchoolService.printStuClas Rollback. " + e1.getMessage());
            }
            throw new EnrollmentException("Could not get Student's Classes\n");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("SQL Exception in SchoolService.printStuClas Close. " + e.getMessage());
            }
        }
    }

    public static Clas printClasStu(Clas clas) throws EnrollmentException {
        Connection connection = null;
        try {
            connection = DatabaseUtils.getInstance().getConnection();
            connection.setAutoCommit(false);
            clas = ClasDao.printClasStu(connection, clas);
            connection.commit();
            return clas;
        } catch (SQLException e) {
            System.out.println("SQL Exception in SchoolService.printClasStu. " + e.getMessage());
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e1) {
                System.out.println("SQL Exception in SchoolService.printClasStu Rollback. " + e1.getMessage());
            }
            throw new EnrollmentException("Could not get Class's Students\n");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("SQL Exception in SchoolService.printClasStu Close. " + e.getMessage());
            }
        }
    }

    public static void deleteStudent(Student student) throws EnrollmentException{
        Connection connection = null;
        try {
            connection = DatabaseUtils.getInstance().getConnection();
            connection.setAutoCommit(false);
            StudentDao.deleteStudent(connection, student);
            connection.commit();
        } catch (SQLException e) {
            System.out.println("SQL Exception in SchoolService.deleteStudent. " + e.getMessage());
            try{
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println("SQL Exception in SchoolService.deleteStudent Rollback. " + e1.getMessage());
            }
            throw new EnrollmentException("Cannot delete Student if enrolled in a Class\n");
        } finally {
            try{
                connection.close();
            } catch(SQLException e){
                System.out.println("SQL Exception in SchoolService.deleteStudent Close. " + e.getMessage());
            }
        }
    }

    public static void deleteClas(Clas clas) throws EnrollmentException{
        Connection connection = null;
        try {
            connection = DatabaseUtils.getInstance().getConnection();
            connection.setAutoCommit(false);
            ClasDao.deleteClas(connection, clas);
            connection.commit();
        } catch (SQLException e) {
            System.out.println("SQL Exception in SchoolService.deleteClas. " + e.getMessage());
            try{
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println("SQL Exception in SchoolService.deleteClas Rollback. " + e1.getMessage());
            }
            throw new EnrollmentException("Cannot delete Class if Students are enrolled\n");
        } finally {
            try{
                connection.close();
            } catch(SQLException e){
                System.out.println("SQL Exception in SchoolService.deleteClas Close. " + e.getMessage());
            }
        }
    }

    public static void removeStuClas(Student student, Clas clas) throws EnrollmentException {
        Connection connection = null;
        try {
            connection = DatabaseUtils.getInstance().getConnection();
            connection.setAutoCommit(false);
            StudentDao.removeStuClas(connection, student, clas);
            connection.commit();
        } catch (SQLException e) {
            System.out.println("SQL Exception in SchoolService.removeStuClas. " + e.getMessage());
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e1) {
                System.out.println("SQL Exception in SchoolService.removeStuClas Rollback. " + e1.getMessage());
            }
            throw new EnrollmentException("Could not remove Student from Class\n");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("SQL Exception in SchoolService.removeStuClas Close. " + e.getMessage());
            }
        }
    }

}

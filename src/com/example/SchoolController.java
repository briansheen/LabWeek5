package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by bsheen on 4/27/17.
 */
public class SchoolController {

    public static void main(String[] args) {
        Scanner s = null;
        s = new Scanner(System.in);
        String selection = null;
        System.out.println("What would you like to do?");
        System.out.println("1. Add a student");
        System.out.println("2. Create a class");
        System.out.println("3. Enroll a student into a class");
        System.out.println("4. Retrieve a student with his/her classes");
        System.out.println("5. Retrieve a class with it's students");
        System.out.println("6. List all students");
        System.out.println("7. List all classes");
        System.out.println("8. Remove a student from a class");
        System.out.println("9. Delete a student");
        System.out.println("10. Delete a class");
        System.out.print("Enter option number: ");
        while (s.hasNext()) {
            selection = s.nextLine();
            switch (selection) {
                case "1":
                    Student student = new Student();
                    System.out.print("Enter student name: ");
                    selection = s.nextLine();
                    student.setName(selection);
                    try {
                        SchoolService.addStudent(student);
                    } catch (EnrollmentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "2":
                    Clas clas = new Clas();
                    System.out.print("Enter class name: ");
                    selection = s.nextLine();
                    clas.setName(selection);
                    try {
                        SchoolService.addClas(clas);
                    } catch (EnrollmentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "3":
                    List<Clas> clasList = null;
                    List<Student> studentList = null;
                    try {
                        studentList = SchoolService.printStudents();
                        for (Student stu : studentList) {
                            System.out.println(stu);
                        }
                        System.out.print("Enter the Student ID you want to enroll: ");
                        selection = s.nextLine();
                        student = new Student();
                        for (int i = 0; i < studentList.size(); ++i) {
                            if (studentList.get(i).getId() == Integer.valueOf(selection)) {
                                student = studentList.get(i);
                            }
                        }
                        clasList = SchoolService.printClases();
                        for (Clas c : clasList) {
                            System.out.println(c);
                        }
                        System.out.print("Enter the Class you want to enroll the Student in: ");
                        selection = s.nextLine();
                        clas = new Clas();
                        for (int i = 0; i < clasList.size(); ++i) {
                            if (clasList.get(i).getId() == Integer.valueOf(selection)) {
                                clas = clasList.get(i);
                            }
                        }
                        SchoolService.assignStu2Clas(student, clas);
                        System.out.println("Student " + student.getName() + " has been enrolled in " + clas.getName() + ".\n");
                    } catch (EnrollmentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "4":
                    try {
                        studentList = SchoolService.printStudents();
                        for (Student stu : studentList) {
                            System.out.println(stu);
                        }
                        System.out.print("Enter the Student ID whose classes you want to see: ");
                        selection = s.nextLine();
                        student = new Student();
                        for (int i = 0; i < studentList.size(); ++i) {
                            if (studentList.get(i).getId() == Integer.valueOf(selection)) {
                                student = studentList.get(i);
                            }
                        }
                        student = SchoolService.printStuClas(student);
                        System.out.println(student);
                        for (Clas c : student.getStudentClasList()) {
                            System.out.println(c);
                        }
                        System.out.println();
                    } catch (EnrollmentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "5":
                    try {
                        clasList = SchoolService.printClases();
                        for (Clas c : clasList) {
                            System.out.println(c);
                        }
                        System.out.print("Enter the Class ID whose students you want to see: ");
                        selection = s.nextLine();
                        clas = new Clas();
                        for (int i = 0; i < clasList.size(); ++i) {
                            if (clasList.get(i).getId() == Integer.valueOf(selection)) {
                                clas = clasList.get(i);
                            }
                        }
                        clas = SchoolService.printClasStu(clas);
                        System.out.println(clas);
                        for (Student stu : clas.getClasStudentList()) {
                            System.out.println(stu);
                        }
                        System.out.println();
                    } catch (EnrollmentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "6":
                    try {
                        studentList = SchoolService.printStudents();
                        for (Student stu : studentList) {
                            System.out.println(stu);
                        }
                        System.out.println();
                    } catch (EnrollmentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "7":
                    try {
                        clasList = SchoolService.printClases();
                        for (Clas c : clasList) {
                            System.out.println(c);
                        }
                        System.out.println();
                    } catch (EnrollmentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "8":
                    try {
                        studentList = SchoolService.printStudents();
                        for (Student stu : studentList) {
                            System.out.println(stu);
                        }
                        System.out.print("Enter the Student ID you want to remove from a class: ");
                        selection = s.nextLine();
                        student = new Student();
                        for (int i = 0; i < studentList.size(); ++i) {
                            if (studentList.get(i).getId() == Integer.valueOf(selection)) {
                                student = studentList.get(i);
                            }
                        }
                        student = SchoolService.printStuClas(student);
                        List<Clas> clases = student.getStudentClasList();
                        for (Clas c : clases) {
                            System.out.println(c);
                        }
                        System.out.print("Enter the Class ID you want to remove Student from: ");
                        selection = s.nextLine();
                        clas = new Clas();
                        for (int i = 0; i < clases.size(); ++i) {
                            if (clases.get(i).getId() == Integer.valueOf(selection)) {
                                clas = clases.get(i);
                            }
                        }
                        SchoolService.removeStuClas(student, clas);
                        if(student.getName()!=null && clas.getName()!= null){
                            System.out.println("Student " + student.getName() + " has been removed from " + clas.getName() + "\n");
                        } else{
                            System.out.println("Student or Class does not exist, please try again.");
                        }
                    } catch (EnrollmentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "9":
                    try {
                        studentList = SchoolService.printStudents();
                        for (Student stu : studentList) {
                            System.out.println(stu);
                        }
                        System.out.print("Enter the Student ID you want to delete: ");
                        selection = s.nextLine();
                        student = new Student();
                        for (int i = 0; i < studentList.size(); ++i) {
                            if (studentList.get(i).getId() == Integer.valueOf(selection)) {
                                student = studentList.get(i);
                            }
                        }
                        SchoolService.deleteStudent(student);
                        System.out.println("Student " + student.getName() + " has been deleted\n");
                    } catch (EnrollmentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "10":
                    try {
                        clasList = SchoolService.printClases();
                        for (Clas c : clasList) {
                            System.out.println(c);
                        }
                        System.out.print("Enter the Class ID you want to delete: ");
                        selection = s.nextLine();
                        clas = new Clas();
                        for (int i = 0; i < clasList.size(); ++i) {
                            if (clasList.get(i).getId() == Integer.valueOf(selection)) {
                                clas = clasList.get(i);
                            }
                        }
                        SchoolService.deleteClas(clas);
                        System.out.println("Class " + clas.getName() + " has been deleted\n");
                    } catch (EnrollmentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Incorrect input, please try again\n");
                    break;
            }

            selection = null;
            System.out.println("What would you like to do?");
            System.out.println("1. Add a student");
            System.out.println("2. Create a class");
            System.out.println("3. Enroll a student into a class");
            System.out.println("4. Retrieve a student with his/her classes");
            System.out.println("5. Retrieve a class with it's students");
            System.out.println("6. List all students");
            System.out.println("7. List all classes");
            System.out.println("8. Remove a student from a class");
            System.out.println("9. Delete a student");
            System.out.println("10. Delete a class");
            System.out.print("Enter option number: ");
        }
    }
}

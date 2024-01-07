package org.example;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
public class Discipline {
    private String name;
    private List<Student> students;

    public Discipline(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }
}

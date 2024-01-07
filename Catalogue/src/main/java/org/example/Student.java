package org.example;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
public class Student {
    private String name;
    private Map<String, List<Grade>> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<String, List<Grade>> getGrades() {
        return grades;
    }

    public void addGrade(String discipline, double value) {
        grades.computeIfAbsent(discipline, k -> new ArrayList<>()).add(new Grade(value));
    }
}

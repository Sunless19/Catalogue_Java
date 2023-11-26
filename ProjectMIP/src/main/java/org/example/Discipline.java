package org.example;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Discipline {
    private String m_name;
    private List<Grade> m_grades;
    private float m_average;

    public float getM_average() {
        return m_average;
    }

    public String getM_name() {
        return m_name;
    }

    public List<Grade> getM_grades() {
        return m_grades;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public void setM_grades(List<Grade> m_grades) {
        this.m_grades = m_grades;
    }

    public void setM_average() {
        float sum = 0;

        for (Grade grade : m_grades) {
            sum = sum + grade.getM_value();
        }

        m_average = sum / m_grades.size();
    }
    public void addGrade(Integer value, String name){
        Grade grade=new Grade();
        grade.setM_value(value);
        Date current=new Date();
        grade.setM_date(current);
        grade.setM_studentName(name);
        if (this.m_grades == null) {
            this.m_grades = new ArrayList<>();
        }
        this.m_grades.add(grade);
    }

}
package org.example;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Student {
    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }
    public void addGrade(Discipline discipline, Integer value) {

    }

    public List<Grade> getM_grades() {
        return m_grades;
    }

    public void setM_grades(List<Grade> m_grades) {
        this.m_grades = m_grades;
    }

    public void addGrade(Integer value, String discipline){
        Grade x=new Grade();
        x.setM_value(value);
        Date data=new Date();
        x.setM_date(data);
        Discipline disciplineObj = new Discipline();
        disciplineObj.setM_name(discipline);
        disciplineObj.addGrade(value);
        x.setM_discipline(disciplineObj);
        if (this.m_grades == null) {
            this.m_grades = new ArrayList<>();
        }
        m_grades.add(x);
    }

    private List<Grade> m_grades;
    private String m_name;
}

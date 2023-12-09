package org.example;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Grade> m_grades;
    private String m_name;

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public List<Grade> getM_grades() {
        return m_grades;
    }

    public void setM_grades(List<Grade> m_grades) {
        this.m_grades = m_grades;
    }

    public void addGrade(Integer value, Discipline discipline){
        Grade x=new Grade();
        x.setM_value(value);
        Date data=new Date();
        x.setM_date(data);
        x.setM_discipline(discipline);
        x.setM_studentName(this.m_name);
        discipline.addGrade(value,this.m_name);
        if (this.m_grades == null) {
            this.m_grades = new ArrayList<>();
        }
        m_grades.add(x);
    }

    public void removeGrade(Integer value, Discipline discipline) {
        m_grades.removeIf(grade -> grade.getM_value().equals(value) && grade.getM_discipline().equals(discipline));
    }


}

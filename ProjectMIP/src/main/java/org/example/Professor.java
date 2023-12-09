package org.example;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String m_name;
    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Discipline> m_disciplines;
    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public List<Discipline> getM_disciplines() {
        return m_disciplines;
    }

    public void setM_disciplines(List<Discipline> m_disciplines) {
        this.m_disciplines = m_disciplines;
    }
    public void addGrade(Integer value, Discipline discipline,Student student){
        Grade x=new Grade();
        x.setM_value(value);
        Date data=new Date();
        x.setM_date(data);
        x.setM_discipline(discipline);
        x.setM_studentName(student.getM_name());
        student.addGrade(value,discipline);
    }
    public void removeGrade(Integer value, Discipline discipline,Student student) {
    if(m_disciplines.contains(discipline))
    {
        for(Grade discord: discipline.getM_grades())
        {
            if(discord.getM_value().equals(value)&&discord.getM_studentName().equals(student.getM_name())) {
                discipline.getM_grades().remove(discord);
                student.removeGrade(value,discipline);
            }
        }
    }
    else System.out.println("Profesorul nu are dreptul sa modifice disciplina respectiva.\n");
    }


}

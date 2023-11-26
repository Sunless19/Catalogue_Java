package org.example;

import java.util.Date;

public class Grade {
    private Integer m_value;

    private Date m_date;

    private Discipline m_discipline;

    public String getM_studentName() {
        return m_studentName;
    }

    public void setM_studentName(String m_studentName) {
        this.m_studentName = m_studentName;
    }

    private String m_studentName;

    public Discipline getM_discipline() {
        return m_discipline;
    }

    public void setM_discipline(Discipline m_discipline) {
        this.m_discipline = m_discipline;
    }

    public Integer getM_value() {
        return m_value;
    }

    public void setM_value(Integer m_value) {
        this.m_value = m_value;
    }

    public Date getM_date() {
        return m_date;
    }

    public void setM_date(Date m_date) {
        this.m_date = m_date;
    }

}

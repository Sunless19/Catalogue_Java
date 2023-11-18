package org.example;
import java.util.ArrayList;

public class Discipline {
    private String m_name;
    private ArrayList<Integer> m_note;
    private float m_average;

    public float getM_average() {
        return m_average;
    }

    public String getM_name() {
        return m_name;
    }

    public ArrayList<Integer> getM_note() {
        return m_note;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public void setM_note(ArrayList<Integer> m_note) {
        this.m_note = m_note;
    }

    public void setM_average()
    {
        Integer sum=0;


        for (Integer integer : m_note) {
            sum = sum + integer;
        }

        m_average=sum/m_note.size();
    }

}
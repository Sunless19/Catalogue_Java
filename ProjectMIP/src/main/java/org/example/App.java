package org.example;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Student sergiu = new Student();
        Student andrei = new Student();
        List<Discipline> disciplineList = new ArrayList<>();
        sergiu.setM_name("Serj");
        andrei.setM_name("Andrej");
        Discipline e=new Discipline();
        e.setM_name("Engleza");
        Discipline r=new Discipline();
        r.setM_name("Romana");
        Discipline j=new Discipline();
        j.setM_name("Jmekeria");
        sergiu.addGrade(7, e);
        sergiu.addGrade(10, e);
        sergiu.addGrade(5, e);
        sergiu.addGrade(8, r);
        sergiu.addGrade(2, r);
        sergiu.addGrade(10, j);
        sergiu.addGrade(10, j);
        andrei.addGrade(3, e);
        andrei.addGrade(2, e);
        andrei.addGrade(3, e);
        andrei.addGrade(4, r);
        andrei.addGrade(4, r);
        andrei.addGrade(10, j);
        andrei.addGrade(10, j);
        System.out.println(sergiu.getM_name());//ok
        //System.out.println(sergiu.getM_grades());//ok
        for (Grade x : sergiu.getM_grades()) {
            System.out.println(x.getM_value() + " " + x.getM_date() + " " + x.getM_discipline().getM_name() + "\n");
            if (!disciplineList.contains(x.getM_discipline())) disciplineList.add(x.getM_discipline());
        }
        for (Grade x : andrei.getM_grades()) {
            System.out.println(x.getM_value() + " " + x.getM_date() + " " + x.getM_discipline().getM_name() + "\n");
            if (!disciplineList.contains(x.getM_discipline())) disciplineList.add(x.getM_discipline());
        }
        for (Discipline x : disciplineList) {
            x.setM_average();
            System.out.println(x.getM_name() + " " + x.getM_average() + " ");
            for (Grade g : x.getM_grades()) {
                System.out.println(g.getM_value() + " "+g.getM_date()+" "+g.getM_studentName());
            }
            System.out.println("\n");
        }
    }

}

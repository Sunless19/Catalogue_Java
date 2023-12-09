package org.example;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
        disciplineList.add(e);
        disciplineList.add(r);
        disciplineList.add(j);
        Professor gigi=new Professor();
        gigi.setM_disciplines(disciplineList);
        gigi.setM_name("Giani");
        gigi.addGrade(7,e,sergiu);
        gigi.addGrade(8,r,sergiu);
        gigi.addGrade(3,j,sergiu);
        gigi.addGrade(4,e,andrei);
        gigi.addGrade(8,r,andrei);
        gigi.addGrade(3,j,andrei);
        gigi.removeGrade(3,j,sergiu);
        gigi.addGrade(10,j,sergiu);
        for (Grade x : sergiu.getM_grades()) {
            System.out.println(x.getM_value() + " " + x.getM_date() + " " + x.getM_discipline().getM_name() + "\n");
        }
        for (Grade x : andrei.getM_grades()) {
            System.out.println(x.getM_value() + " " + x.getM_date() + " " + x.getM_discipline().getM_name() + "\n");
        }
        for (Discipline x : disciplineList) {
            x.setM_average();
            System.out.println(x.getM_name() + " " + x.getM_average() + " ");
            for (Grade g : x.getM_grades()) {
                System.out.println(g.getM_value() + " "+g.getM_date()+" "+g.getM_studentName());
            }
            System.out.println("\n");
        }
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("collegePersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        /* YOUR QUERIES HERE */

        StudentEntity resultList = (StudentEntity) entityManager
                .createNativeQuery("SELECT * FROM student WHERE id = 1", StudentEntity.class)
                .getSingleResult();

        /* YOUR QUERIES HERE */
        entityTransaction.commit();


        System.out.println(resultList);
        entityManager.close();
    }

}

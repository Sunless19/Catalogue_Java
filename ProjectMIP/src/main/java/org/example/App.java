package org.example;
import java.util.ArrayList;
public class App 
{

    public static void main( String[] args )
    {
        Student sergiu=new Student();
        //Discipline a=new Discipline();
        //Discipline b=new Discipline();
        //Discipline c=new Discipline();
        sergiu.setM_name("Serj");
        //a.setM_name("Germana");
        //b.setM_name("Romana");
        //c.setM_name("Engleza");
        sergiu.addGrade(7,"Engleza");
        sergiu.addGrade(8,"Romana");
        sergiu.addGrade(10,"Jmekerie");
        //sergiu.addGrade(a,7);
        //sergiu.addGrade(b,5);
        //sergiu.addGrade(c,10);
        //a.setM_average();
        //b.setM_average();
        //c.setM_average();
        System.out.println(sergiu.getM_name());//ok
        //System.out.println(sergiu.getM_grades());//ok
        for(Grade x: sergiu.getM_grades())
            System.out.println(x.getM_value()+" "+x.getM_date()+" "+x.getM_discipline().getM_name()+"\n");
    }

}

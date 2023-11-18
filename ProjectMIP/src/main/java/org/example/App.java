package org.example;
import java.util.ArrayList;
public class App 
{

    public static void main( String[] args )
    {
        Discipline a=new Discipline();
        a.setM_name("Germana");
        ArrayList<Integer> x=new ArrayList<>();
        x.add(5);
        x.add(4);
        x.add(3);
        x.add(2);
        x.add(1);
        a.setM_note(x);
        a.setM_average();
        System.out.println(a.getM_average());
        System.out.println(a.getM_name());
    }

}

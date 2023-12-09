package org.example;

/**
 * Unit test for simple MainApp.
 */
public class ScoalaApp {
    public static void main(String[] args) {
        Elev elev = new Elev("John Doe");
        Profesor profesor = new Profesor("Prof. Smith");

        Disciplina matematica = new Disciplina("Matematica");
        profesor.adaugaDisciplina(matematica);

        Nota notaMatematica = new Nota(8);
        elev.adaugaNota(matematica, notaMatematica);

        double medieFinalaMatematica = matematica.calculeazaMedieFinala();
        System.out.println("Medie finala la Matematica: " + medieFinalaMatematica);
    }
}

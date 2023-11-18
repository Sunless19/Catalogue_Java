package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ScoalaApp {
    public static void main(String[] args) {
        Elev elev = new Elev("John Doe");
        Profesor profesor = new Profesor("Prof. Smith");

        Disciplina matematica = new Disciplina("Matematica");
        profesor.adaugaDisciplina(matematica);

        Nota notaMatematica = new Nota(8);

        // Calcul medie finala pentru disciplina Matematica
        double medieFinalaMatematica = matematica.calculeazaMedieFinala();
        System.out.println("Medie finala la Matematica: " + medieFinalaMatematica);
    }
}

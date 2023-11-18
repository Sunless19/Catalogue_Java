package org.example;
import java.util.List;
import java.util.ArrayList;
public class Profesor {
    private String nume;
    private List<Disciplina> disciplinePredate = new ArrayList<>();

    public Profesor(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public List<Disciplina> getDisciplinePredate() {
        return disciplinePredate;
    }

    public void adaugaDisciplina(Disciplina disciplina) {
        disciplinePredate.add(disciplina);
    }
}

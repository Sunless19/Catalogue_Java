package org.example;
import java.util.ArrayList;
import java.util.List;
public class Disciplina {
    private String nume;
    private List<Nota> note = new ArrayList<>();

    public Disciplina(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public List<Nota> getNote() {
        return note;
    }

    public void adaugaNota(Nota nota) {
        note.add(nota);
    }

    public double calculeazaMedieFinala()
    {

        if (note.isEmpty())
        {
            return 0.0;
        }

        double suma = 0;
        for (Nota nota : note)
        {
            suma += nota.getValoare();
        }

        return suma / note.size();

    }
}

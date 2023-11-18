package org.example;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Elev {
    private String nume;
    private Map<Disciplina, List<Nota>> noteDiscipline = new HashMap<>();

    public Elev(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public Map<Disciplina, List<Nota>> getNoteDiscipline() {
        return noteDiscipline;
    }
    public void adaugaNota(Disciplina disciplina, Nota nota)
    {
        noteDiscipline.computeIfAbsent(disciplina, k -> new ArrayList<>()).add(nota);
    }

}

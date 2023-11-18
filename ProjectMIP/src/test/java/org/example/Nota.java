package org.example;
import java.util.Date;
public class Nota {
    private int valoare;
    private Date data;

    public Nota(int valoare) {
        this.valoare = valoare;
        this.data = new Date();
    }

    public int getValoare() {
        return valoare;
    }

    public Date getData() {
        return data;
    }
}

package entities;

import java.util.UUID;

public abstract class Game {

    private String id;
    private String titolo;
    private int annoPubblicazione;
    private double prezzo;

    public Game(String titolo, int annoPubblicazione, double prezzo) {
        if (prezzo <= 0) throw new IllegalArgumentException("Prezzo non valido");
        this.id = UUID.randomUUID().toString();
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo = prezzo;
    }

    public String getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setPrezzo(double prezzo) {
        if (prezzo <= 0) throw new IllegalArgumentException("Prezzo non valido");
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "ID=" + id + ", titolo=" + titolo + ", prezzo=" + prezzo;
    }
}

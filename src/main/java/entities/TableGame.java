package entities;
public class TableGame extends Game {

    private int numeroGiocatori;
    private int durataMinuti;

    public TableGame(String titolo, int anno, double prezzo, int numeroGiocatori, int durataMinuti) {
        super(titolo, anno, prezzo);

        if (numeroGiocatori < 2 || numeroGiocatori > 10)
            throw new IllegalArgumentException("Numero giocatori non valido");

        this.numeroGiocatori = numeroGiocatori;
        this.durataMinuti = durataMinuti;
    }

    public int getNumeroGiocatori() {
        return numeroGiocatori;
    }

    @Override
    public String toString() {
        return "Gioco da Tavolo → " + super.toString() +
                ", giocatori=" + numeroGiocatori;
    }
}
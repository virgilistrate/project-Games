package entities;

public class VideoGame extends Game {

    private String piattaforma;
    private int durataOre;
    private String genere;

    public VideoGame(String titolo, int anno, double prezzo, String piattaforma, int durataOre, String genere) {
        super(titolo, anno, prezzo);

        if (genere == null || genere.isBlank())
            throw new IllegalArgumentException("Genere non valido");

        this.piattaforma = piattaforma;
        this.durataOre = durataOre;
        this.genere = genere;
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    public int getDurataOre() {
        return durataOre;
    }

    public String getGenere() {
        return genere;
    }

    @Override
    public String toString() {
        return "Videogioco → " + super.toString() +
                ", piattaforma=" + piattaforma +
                ", genere=" + genere;
    }
}


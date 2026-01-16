package collezione;
import entities.*;

import java.util.*;
import java.util.stream.Collectors;

public class GamesCollection {

    private List<Game> giochi = new ArrayList<>();

    // AGGIUNTA
    public void aggiungiGioco(Game game) {
        boolean exists = giochi.stream().anyMatch(g -> g.getId().equals(game.getId()));
        if (exists) throw new IllegalArgumentException("Gioco già presente");
        giochi.add(game);
    }

    // RICERCA PER ID
    public Game cercaPerId(String id) {
        return giochi.stream()
                .filter(g -> g.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("ID non trovato"));
    }

    // RICERCA PER PREZZO
    public List<Game> cercaPerPrezzo(double prezzo) {
        return giochi.stream()
                .filter(g -> g.getPrezzo() < prezzo)
                .collect(Collectors.toList());
    }

    // RICERCA PER NUMERO GIOCATORI
    public List<TableGame> cercaPerNumeroGiocatori(int n) {
        return giochi.stream()
                .filter(g -> g instanceof TableGame)
                .map(g -> (TableGame) g)
                .filter(g -> g.getNumeroGiocatori() == n)
                .toList();
    }

    // RIMOZIONE
    public void rimuovi(String id) {
        boolean removed = giochi.removeIf(g -> g.getId().equals(id));
        if (!removed) throw new NoSuchElementException("ID non trovato");
    }

    // AGGIORNAMENTO
    public void aggiornaPrezzo(String id, double prezzo) {
        Game g = cercaPerId(id);
        g.setPrezzo(prezzo);
    }

    // STATISTICHE
    public void statistiche() {
        long videogiochi = giochi.stream().filter(g -> g instanceof VideoGame).count();
        long tavolo = giochi.stream().filter(g -> g instanceof TableGame).count();

        Game maxPrezzo = giochi.stream()
                .max(Comparator.comparing(Game::getPrezzo))
                .orElse(null);

        double media = giochi.stream()
                .mapToDouble(Game::getPrezzo)
                .average()
                .orElse(0);

        System.out.println("Videogiochi: " + videogiochi);
        System.out.println("Giochi da tavolo: " + tavolo);
        System.out.println("Gioco più costoso: " + maxPrezzo);
        System.out.println("Prezzo medio: " + media);
    }
}
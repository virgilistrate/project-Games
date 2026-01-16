package org.example;

import entities.*;
import collezione.GamesCollection;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        GamesCollection collezione = new GamesCollection();
        Scanner scanner = new Scanner(System.in);
        boolean continua = true;

        System.out.println("--- BENVENUTO NELLA GESTIONE COLLEZIONE GIOCHI ---");

        while (continua) {
            try {
                System.out.println("Cosa desideri fare?");
                System.out.println("1. Aggiungi Videogioco");
                System.out.println("2. Aggiungi Gioco da Tavolo");
                System.out.println("3. Ricerca per ID");
                System.out.println("4. Ricerca per Prezzo (inferiore a...)");
                System.out.println("5. Ricerca per Numero Giocatori");
                System.out.println("6. Rimuovi Gioco per ID");
                System.out.println("7. Aggiorna Prezzo per ID");
                System.out.println("8. Mostra Statistiche");
                System.out.println("0. Esci");
                System.out.print("Scelta: ");

                int scelta = Integer.parseInt(scanner.nextLine());

                switch (scelta) {
                    case 1: // AGGIUNGI VIDEOGIOCO
                        System.out.print("Titolo: ");
                        String titV = scanner.nextLine();
                        System.out.print("Anno: ");
                        int annoV = Integer.parseInt(scanner.nextLine());
                        System.out.print("Prezzo: ");
                        double prezzoV = Double.parseDouble(scanner.nextLine());
                        System.out.print("Piattaforma: ");
                        String pV = scanner.nextLine();
                        System.out.print("Durata (ore): ");
                        int oreV = Integer.parseInt(scanner.nextLine());
                        System.out.print("Genere: ");
                        String genV = scanner.nextLine();
                        collezione.aggiungiGioco(new VideoGame(titV, annoV, prezzoV, pV, oreV, genV));
                        System.out.println("Videogioco aggiunto con successo!");
                        break;

                    case 2: // AGGIUNGI GIOCO DA TAVOLO
                        System.out.print("Titolo: ");
                        String titT = scanner.nextLine();
                        System.out.print("Anno: ");
                        int annoT = Integer.parseInt(scanner.nextLine());
                        System.out.print("Prezzo: ");
                        double prezzoT = Double.parseDouble(scanner.nextLine());
                        System.out.print("Numero Giocatori (2-10): ");
                        int nG = Integer.parseInt(scanner.nextLine());
                        System.out.print("Durata (minuti): ");
                        int minT = Integer.parseInt(scanner.nextLine());
                        collezione.aggiungiGioco(new TableGame(titT, annoT, prezzoT, nG, minT));
                        System.out.println("Gioco da tavolo aggiunto!");
                        break;

                    case 3: // RICERCA PER ID
                        System.out.print("Inserisci ID: ");
                        String idCerca = scanner.nextLine();
                        Game trovato = collezione.cercaPerId(idCerca);
                        System.out.println("Risultato: " + trovato);
                        break;

                    case 4: // RICERCA PER PREZZO
                        System.out.print("Mostra giochi con prezzo inferiore a: ");
                        double pMax = Double.parseDouble(scanner.nextLine());
                        List<Game> perPrezzo = collezione.cercaPerPrezzo(pMax);
                        if (perPrezzo.isEmpty()) System.out.println("Nessun gioco trovato.");
                        else perPrezzo.forEach(System.out::println);
                        break;

                    case 5: // RICERCA PER GIOCATORI
                        System.out.print("Inserisci numero esatto di giocatori: ");
                        int nGioc = Integer.parseInt(scanner.nextLine());
                        List<TableGame> perGiocatori = collezione.cercaPerNumeroGiocatori(nGioc);
                        if (perGiocatori.isEmpty()) System.out.println("Nessun gioco da tavolo trovato.");
                        else perGiocatori.forEach(System.out::println);
                        break;

                    case 6: // RIMOZIONE
                        System.out.print("Inserisci ID da rimuovere: ");
                        String idRem = scanner.nextLine();
                        collezione.rimuovi(idRem);
                        System.out.println("Elemento rimosso.");
                        break;

                    case 7: // AGGIORNAMENTO
                        System.out.print("Inserisci ID da aggiornare: ");
                        String idAgg = scanner.nextLine();
                        System.out.print("Nuovo prezzo: ");
                        double nPrezzo = Double.parseDouble(scanner.nextLine());
                        collezione.aggiornaPrezzo(idAgg, nPrezzo);
                        System.out.println("Prezzo aggiornato.");
                        break;

                    case 8: // STATISTICHE
                        collezione.statistiche();
                        break;

                    case 0:
                        continua = false;
                        System.out.println("Chiusura programma...");
                        break;

                    default:
                        System.out.println("Scelta non valida.");
                }

            } catch (NumberFormatException e) {
                System.err.println("Errore: Inserisci un numero valido per prezzi, anni o scelte.");
            } catch (Exception e) {
                System.err.println("Errore: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
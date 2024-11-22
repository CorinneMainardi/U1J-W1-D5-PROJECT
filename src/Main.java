import it.epicode.immagini.Immagine;
import it.epicode.interfacce.IAudio;
import it.epicode.interfacce.ILuminosita;
import it.epicode.player_multimediale.PlayerMultimediale;
import it.epicode.registrazione.Audio;
import it.epicode.registrazione.Video;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<PlayerMultimediale> elementi = new ArrayList<>();

        // Creazione degli elementi
        for (int i = 0; i < 5; i++) {
            System.out.println("\nElemento " + (i + 1) + ": scegli tipo - 'a' per audio, 'v' per video, 'i' per immagine");
            String tipo = scanner.nextLine();

            System.out.println("Inserisci il titolo:");
            String titolo = scanner.nextLine();

            switch (tipo) {
                case "a":
                    System.out.println("Inserisci la durata dell'audio:");
                    int durataAudio = Integer.parseInt(scanner.nextLine());
                    elementi.add(new Audio(titolo, durataAudio, 10)); // Volume predefinito
                    break;

                case "v":
                    System.out.println("Inserisci la durata del video:");
                    int durataVideo = Integer.parseInt(scanner.nextLine());
                    elementi.add(new Video(titolo, durataVideo, 10, 5)); // Volume e luminosità predefiniti
                    break;

                case "i":
                    elementi.add(new Immagine(titolo, 6)); // Luminosità predefinita
                    break;

                default:
                    System.out.println("Tipo non valido, riprova.");
                    i--;
                    break;
            }
        }

        // Menu di esecuzione
        boolean continua = true;
        while (continua) {

            // Possibilità di rinominare un elemento
            System.out.println("Vuoi rinominare un elemento? (S/N):");
            String risposta = scanner.nextLine();

            if (risposta.equalsIgnoreCase("S")) {
                System.out.println("\nSeleziona un elemento da rinominare (1-5):");
                for (int i = 0; i < elementi.size(); i++) {
                    System.out.println((i + 1) + ": " + elementi.get(i).getTitolo());
                }

                int titoloNuovo = Integer.parseInt(scanner.nextLine());

                if (titoloNuovo >= 1 && titoloNuovo <= elementi.size()) {
                    PlayerMultimediale elementoRinomina = elementi.get(titoloNuovo - 1);

                    System.out.println("Inserisci il nuovo titolo:");
                    String nuovoTitolo = scanner.nextLine();
                    elementoRinomina.setTitolo(nuovoTitolo);
                    System.out.println("Elemento rinominato con successo!");
                } else {
                    System.out.println("Indice non valido. Riprovare.");
                }
            } else {
                System.out.println("Nessun elemento rinominato.");
            }

            // Menu di selezione delle azioni
            System.out.println("\nSeleziona un'opzione:");

            System.out.println("1-5: Esegui elemento");
            for (int i = 0; i < elementi.size(); i++) {
                System.out.println((i + 1) + ": " + elementi.get(i).getTitolo());
            }
            System.out.println("6: Alza volume");
            System.out.println("7: Abbassa volume");
            System.out.println("8: Alza luminosità");
            System.out.println("9: Abbassa luminosità");
            System.out.println("0: Esci");
            int scelta = Integer.parseInt(scanner.nextLine());

            // Uscita dal programma
            if (scelta == 0) {
                System.out.println("Uscita dal programma.");
                continua = false;

            } else if (scelta >= 1 && scelta <= 5) {
                PlayerMultimediale elemento = elementi.get(scelta - 1);

                if (elemento instanceof Audio) {
                    ((Audio) elemento).play();
                } else if (elemento instanceof Video) {
                    ((Video) elemento).play();
                } else if (elemento instanceof Immagine) {
                    ((Immagine) elemento).show();
                }

            } else if (scelta == 6 || scelta == 7 || scelta == 8 || scelta == 9) {
                System.out.println("Seleziona un elemento da modificare (1-5):");
                for (int i = 0; i < elementi.size(); i++) {
                    System.out.println((i + 1) + ": " + elementi.get(i).getTitolo());
                }
                int indice = Integer.parseInt(scanner.nextLine());

                if (indice >= 1 && indice <= 5) {
                    PlayerMultimediale elemento = elementi.get(indice - 1);

                    if (scelta == 6 && elemento instanceof IAudio) {
                        System.out.println("Il tuo volume è a: " + ((Audio) elemento).getVolume() + ". Di quanto vuoi alzare il volume?");
                        int incremento = Integer.parseInt(scanner.nextLine());
                        ((Audio) elemento).alzaVolume(incremento);
                        System.out.println("Il tuo volume è stato modificato con successo");

                    } else if (scelta == 7 && elemento instanceof IAudio) {
                        System.out.println("Il tuo volume è a: " + ((Audio) elemento).getVolume() + ". Di quanto vuoi abbassare il volume?");
                        int decremento = Integer.parseInt(scanner.nextLine());
                        ((Audio) elemento).abbassaVolume(decremento);
                        System.out.println("Il tuo volume è stato modificato con successo");

                    } else if (scelta == 8 && elemento instanceof ILuminosita) {
                        System.out.println("La tua luminosità è a: " + ((ILuminosita) elemento).getLuminosita() + ". Di quanto vuoi alzare la luminosità?");
                        int incremento = Integer.parseInt(scanner.nextLine());
                        ((ILuminosita) elemento).alzaLuminosita(incremento);
                        System.out.println("La tua luminosità è stata modificata con successo");
                    } else if (scelta == 9 && elemento instanceof ILuminosita) {
                        System.out.println("La tua luminosità è a: " + ((ILuminosita) elemento).getLuminosita() + ". Di quanto vuoi abbassare la luminosità?");
                        int decremento = Integer.parseInt(scanner.nextLine());
                        ((ILuminosita) elemento).abbassaLuminosita(decremento);
                        System.out.println("La tua luminosità è stata modificata con successo");
                    } else {
                        System.out.println("Operazione non valida per questo tipo di elemento.");
                    }
                } else {
                    System.out.println("Elemento non valido.");
                }

            } else {
                System.out.println("Scelta non valida, riprova.");
            }

            //possibilità di ripristinare alle impostazioni di default volume e luminosita
            System.out.println("Vuoi ripristinare i valori predefiniti (volume/luminosità)? (s/n)");
            String resetRisposta = scanner.nextLine();
            if (resetRisposta.equalsIgnoreCase("s")) {
                System.out.println("Seleziona un elemento da ripristinare (1-5):");
                for (int i = 0; i < elementi.size(); i++) {
                    System.out.println((i + 1) + ": " + elementi.get(i).getTitolo());
                }
                int indiceReset = Integer.parseInt(scanner.nextLine());
                if (indiceReset >= 1 && indiceReset <= 5) {
                    PlayerMultimediale elementoReset = elementi.get(indiceReset - 1);

                    if (elementoReset instanceof Audio) {
                        ((Audio) elementoReset).resetVolume();
                        System.out.println("Volume ripristinato!");
                    } else if (elementoReset instanceof Video) {
                        ((Video) elementoReset).resetLuminosita();
                        System.out.println("Luminosità ripristinata!");
                    } else if (elementoReset instanceof Immagine) {
                        ((Immagine) elementoReset).resetLuminosita();
                        System.out.println("Luminosità ripristinata!");
                    }

                } else {
                    System.out.println("Elemento non valido.");
                }
            }
        }

        scanner.close();
    }
}

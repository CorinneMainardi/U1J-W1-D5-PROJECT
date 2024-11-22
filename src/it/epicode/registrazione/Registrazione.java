package it.epicode.registrazione;

import it.epicode.interfacce.IAudio;
import it.epicode.player_multimediale.PlayerMultimediale;

public abstract class Registrazione extends PlayerMultimediale implements IAudio {
    int volume= 10;
    int durata;

    public Registrazione(String titolo, int durata, int volume) {
        super(titolo);
        if (durata > 0) {
            this.durata = durata;
        } else {
            throw new Error("la durata deve essere un numero maggiore di 0");

        }
        this.volume= volume;
    }

    //mi creo l'istanza del volume perché è in default
    public int getVolume() {
        return volume;
    }

    //mi creo una funzione di reset volume, qualora l'utente volesse tornare alle impostazioni di default
    public void resetVolume() {
        this.volume = 10;
    }


    //implimenta interfaccia IAudio
    public void abbassaVolume(int abbassa) {
        int volMin = 0;
        if (volume > volMin) {
            volume -= abbassa;
        } else {
            throw new Error("il volume è al minimo");
        }
    }

    //implimenta interfaccia IAudio
    public void alzaVolume(int alza) {
        int volumeMax = 20;


        if ((volume + alza) <= volumeMax) {
            volume += alza;
            if (volume + alza == volumeMax) System.out.println("il volume è stato impostato al massimo");
        } else {
            volume = volumeMax;
            System.out.println("Il volume è al massimo");
        }

    }
}


//
//    public void String play(String titolo, int durata, int volume) {
//        String playResult = "";
//        for (int i = 1; i < durata; i++) {
//            playResult += titolo;
//        }
//        for (int i = 0; i < volume; i++) {
//            playResult += "!";
//        }
//        return playResult;
//    }


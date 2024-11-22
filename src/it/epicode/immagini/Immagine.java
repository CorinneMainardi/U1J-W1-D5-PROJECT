package it.epicode.immagini;

import it.epicode.interfacce.ILuminosita;
import it.epicode.player_multimediale.PlayerMultimediale;

public class Immagine extends PlayerMultimediale implements ILuminosita {

    //luminosità impostata di default
    int luminosita = 6;



    public Immagine(String titolo, int luminosita) {
        super(titolo);

        this.luminosita = luminosita;
    }

    public void abbassaLuminosita(int abbassa) {
        int lumMin = 1;
        if(luminosita>lumMin){
            luminosita-=abbassa;
        }else {
            throw new Error("La luminosità è al minimo");
        }
    }
    public void alzaLuminosita(int alza) {
        int lumMax = 10;


        if((luminosita+alza)<= lumMax){
            luminosita +=alza;
            if(luminosita +alza== lumMax) System.out.println("il volume è stato impostato al massimo");
        }  else{
            luminosita = lumMax;
            System.out.println("Il volume è al massimo");
        }

    }
    public int getLuminosita() {
        return luminosita;
    }

    public void resetLuminosita() {
        this.luminosita = 6;
    }

    public void show(){
        System.out.println(getTitolo() + "!".repeat(luminosita));

    }
}



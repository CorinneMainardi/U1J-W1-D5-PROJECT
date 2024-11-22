package it.epicode.registrazione;

import it.epicode.interfacce.ILuminosita;

public class Video extends Registrazione implements ILuminosita {

    //luminosità di default
    int luminosita =3;

    public Video(String titolo, int durata, int volume, int luminosita) {

        super(titolo, durata, volume);
        this.luminosita =luminosita;

    }


    public void play(){

        for (int i = 0; i <durata; i++){
            System.out.println(getTitolo() + "!".repeat(volume)+ "*".repeat(luminosita));
        }

    }



    public int getLuminosita() {
        return luminosita;
    }
    public void resetLuminosita() {
        this.luminosita = 3;
    }

    public void abbassaLuminosita(int abbassa){

    }

    @Override
    public void alzaLuminosita(int alza) {
        int lumMax = 10;

        if((luminosita+alza)<= lumMax){
            luminosita +=alza;
            if(luminosita +alza== lumMax) System.out.println("il volume è stato impostato al massimo");
        }  else{
            luminosita = lumMax;
            System.out.println("La luminosità è al massimo");
        }

    }




}

package it.epicode.registrazione;

public class Audio extends Registrazione  {


    public Audio(String titolo, int durata, int volume) {
        super(titolo, durata, volume);
    }


    @Override
    public void play() {

        for (int i = 0; i <durata; i++){
            System.out.println(getTitolo() + "!".repeat(volume));
        }

    }
}


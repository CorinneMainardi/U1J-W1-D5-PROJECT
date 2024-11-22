package it.epicode.player_multimediale;

public abstract class PlayerMultimediale {
    private String titolo;


    public PlayerMultimediale(String titolo){
        this.titolo=titolo;


    }

    public String getTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
}




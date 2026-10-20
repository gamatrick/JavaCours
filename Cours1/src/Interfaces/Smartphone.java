package Interfaces;

public class Smartphone extends Phone implements Gps, MusicPlayer, VideoPlayer {

    @Override
    public Coordonnees obtenirPosition() {
        return new Coordonnees(42f, 2.8f);
    }

    /*
    @Override
    public MusicPlayer(){

    }
     */
}

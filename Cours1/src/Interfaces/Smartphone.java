package Interfaces;

public class Smartphone extends Phone implements Gps, MusicPlayer, VideoPlayer {

    @Override
    public Coordonnees obtenirPosition() {
        return new Coordonnees(latitude:42f, longitude:2.8f);
    }

    @Override
    public MusicPlayer(){

    }
}

package abstraction;

public class Ratel extends Animal {

    @Override
    public void faireSonBruit() {
        IO.println("Ratel attaque");
    }

    @Override
    public void poly() {
        //super.poly();
        IO.println("Ratel n'est pas poly");
    }
}

package abstraction;

public class Lion extends Animal {

    @Override
    public void faireSonBruit() {
        IO.println("mort");
    }

    @Override
    public void poly (){
        //super.poly();
        IO.println("Je suis le roi");
    }
}

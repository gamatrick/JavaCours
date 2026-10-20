package abstraction;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static void main(){

        List<Animal> animaux = new ArrayList<>();

        animaux.add(new Ratel());
        animaux.add(new Ratel());
        animaux.add(new Ratel());
        animaux.add(new Lion());
        animaux.add(new Lion());
        animaux.add(new Lion());

        // for each
        for (Animal animal : animaux){
            //animal.faireSonBruit();
            animal.poly();
        }
    }
}

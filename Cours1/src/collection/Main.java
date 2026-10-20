package collection;

import java.util.List;

public class Main {

    static void main() {

        List<Integer> nombres = List.of(7, 2, 9, 4, -3, 10, 1, -6, 8, 5);

        Nombres resultat = Separateurs.separerPairsImpairs(nombres);

        IO.println("Nombres de départ : " + nombres);
        IO.println("Pairs (décroissant) : " + resultat.pairs());
        IO.println("Impairs (croissant) : " + resultat.impairs());

    }
}
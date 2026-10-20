package collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Separateurs {

    public static Nombres separerPairsImpairs(List<Integer> nombres) {

        List<Integer> pairs = new ArrayList<>();
        List<Integer> impairs = new ArrayList<>();

        for (int nombre : nombres) {
            if (nombre % 2 == 0) {
                pairs.add(nombre);
            } else {
                impairs.add(nombre);
            }
        }

        pairs.sort(Comparator.reverseOrder());
        impairs.sort(Comparator.naturalOrder());

        return new Nombres(pairs, impairs);

    }
}
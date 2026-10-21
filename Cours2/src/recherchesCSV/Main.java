package recherchesCSV;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Travailleurs> travailleurs = AuTravail.lireFichier("/travailleurs.csv");

        System.out.println("Salaire moyen : " + AuTravail.salaireMoyen(travailleurs));

        System.out.println("Métier le plus représenté : " + AuTravail.metierLePlusRepresente(travailleurs));

        System.out.println("Les 5 prénoms les plus représentés :");
        for (String prenom : AuTravail.cinqPrenomsLesPlusRepresentes(travailleurs)) {
            System.out.println(prenom);
        }
    }
}
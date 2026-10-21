package recherchesCSV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuTravail {

    public static void main(String[] args) throws IOException {
        List<Travailleurs> travailleurs = lireFichier("/travailleurs.csv");

        // 1. Salaire moyen
        int total = 0;
        for (Travailleurs t : travailleurs) {
            total += t.getSalaire();
        }
        double moyenne = (double) total / travailleurs.size();
        System.out.println("Salaire moyen : " + moyenne);

        // 2. Métier le plus représenté
        Map<String, Integer> metiers = new HashMap<>();
        for (Travailleurs t : travailleurs) {
            metiers.put(t.getEmploi(), metiers.getOrDefault(t.getEmploi(), 0) + 1);
        }

        String metierMax = "";
        int nbMax = 0;
        for (String metier : metiers.keySet()) {
            if (metiers.get(metier) > nbMax) {
                nbMax = metiers.get(metier);
                metierMax = metier;
            }
        }
        System.out.println("Métier le plus représenté : " + metierMax + " (" + nbMax + ")");

        // 3. Les 5 prénoms les plus représentés
        Map<String, Integer> prenoms = new HashMap<>();
        for (Travailleurs t : travailleurs) {
            prenoms.put(t.getPrenom(), prenoms.getOrDefault(t.getPrenom(), 0) + 1);
        }

        List<String> listePrenoms = new ArrayList<>(prenoms.keySet());
        listePrenoms.sort((a, b) -> prenoms.get(b) - prenoms.get(a));

        System.out.println("Les 5 prénoms les plus représentés :");
        for (int i = 0; i < 5; i++) {
            String prenom = listePrenoms.get(i);
            System.out.println(prenom + " : " + prenoms.get(prenom));
        }
    }

    public static List<Travailleurs> lireFichier(String nomFichier) throws IOException {
        List<Travailleurs> travailleurs = new ArrayList<>();

        File fichier = new File(AuTravail.class.getResource(nomFichier).getPath());
        BufferedReader reader = new BufferedReader(new FileReader(fichier));

        reader.readLine(); // on saute la ligne d'en-tête
        String ligne;
        while ((ligne = reader.readLine()) != null) {
            String[] c = ligne.split(",");
            Travailleurs t = new Travailleurs(
                    Integer.parseInt(c[0]), c[1], c[2], c[3], c[4],
                    c[5], c[6], c[7], Integer.parseInt(c[8]));
            travailleurs.add(t);
        }
        reader.close();

        return travailleurs;
    }
}
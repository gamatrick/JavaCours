package recherchesCSV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AuTravail {

    // Lit le fichier CSV et le transforme en List<Travailleurs>
    public static List<Travailleurs> lireFichier(String nomFichier) throws IOException {
        List<Travailleurs> travailleurs = new ArrayList<>();

        File fichier = new File(Objects.requireNonNull(AuTravail.class.getResource(nomFichier)).getPath());
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

    // 1. Salaire moyen
    public static double salaireMoyen(List<Travailleurs> travailleurs) {
        int total = 0;
        for (Travailleurs t : travailleurs) {
            total += t.getSalaire();
        }
        return (double) total / travailleurs.size();
    }

    // 2. Métier le plus représenté
    public static String metierLePlusRepresente(List<Travailleurs> travailleurs) {
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
        return metierMax + " (" + nbMax + ")";
    }

    // 3. Les 5 prénoms les plus représentés
    public static List<String> cinqPrenomsLesPlusRepresentes(List<Travailleurs> travailleurs) {
        Map<String, Integer> prenoms = new HashMap<>();
        for (Travailleurs t : travailleurs) {
            prenoms.put(t.getPrenom(), prenoms.getOrDefault(t.getPrenom(), 0) + 1);
        }

        List<String> listePrenoms = new ArrayList<>(prenoms.keySet());
        listePrenoms.sort((a, b) -> prenoms.get(b) - prenoms.get(a));

        List<String> top5 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String prenom = listePrenoms.get(i);
            top5.add(prenom + " : " + prenoms.get(prenom));
        }
        return top5;
    }
}
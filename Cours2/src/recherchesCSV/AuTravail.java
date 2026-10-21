package recherchesCSV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AuTravail {

    private static final String NOM_FICHIER = "/travailleurs.csv";

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<Travailleur> travailleurs = lireCsv(NOM_FICHIER);
        System.out.println(travailleurs.size() + " travailleurs lus.\n");

        System.out.printf("Salaire moyen : %.2f%n%n", salaireMoyen(travailleurs));

        Map<String, Long> parEmploi = compter(travailleurs, Travailleur::getEmploi);
        long maxEmploi = parEmploi.values().stream().max(Long::compare).orElse(0L);
        List<String> metiers = parEmploi.entrySet().stream()
                .filter(e -> e.getValue() == maxEmploi)
                .map(Map.Entry::getKey)
                .sorted()
                .toList();
        System.out.println("Métier(s) le(s) plus représenté(s) (" + maxEmploi + " fois) : " + metiers + "\n");

        System.out.println("Les 5 prénoms les plus représentés :");
        top(compter(travailleurs, Travailleur::getPrenom), 5)
                .forEach(e -> System.out.println("  " + e.getKey() + " : " + e.getValue()));
    }

    public static List<Travailleur> lireCsv(String nomFichier) throws IOException, URISyntaxException {
        URL ressource = AuTravail.class.getResource(nomFichier);
        if (ressource == null) {
            throw new IOException("Fichier introuvable dans le classpath : " + nomFichier);
        }
        // toURI() gère les espaces et accents du chemin, contrairement à getPath()
        File fichier = new File(ressource.toURI());

        List<Travailleur> travailleurs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fichier, StandardCharsets.UTF_8))) {
            reader.readLine(); // ignore l'en-tête
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                if (!ligne.isBlank()) {
                    travailleurs.add(Travailleur.depuisLigneCsv(ligne));
                }
            }
        }
        return travailleurs;
    }

    public static double salaireMoyen(List<Travailleur> travailleurs) {
        return travailleurs.stream()
                .mapToInt(Travailleur::getSalaire)
                .average()
                .orElse(0);
    }

    public static Map<String, Long> compter(List<Travailleur> travailleurs, Function<Travailleur, String> critere) {
        return travailleurs.stream()
                .collect(Collectors.groupingBy(critere, Collectors.counting()));
    }

    // Trie par nombre d'occurrences décroissant, puis par ordre alphabétique en cas d'égalité
    public static List<Map.Entry<String, Long>> top(Map<String, Long> comptage, int n) {
        return comptage.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(n)
                .toList();
    }
}

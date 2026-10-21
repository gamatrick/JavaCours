package recherchesCSV;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Travailleur {

    private static final DateTimeFormatter FORMAT_DATE = DateTimeFormatter.ofPattern("ddMMyyyy");

    private final int id;
    private final String nom;
    private final String prenom;
    private final LocalDate dateDeNaissance;
    private final String emploi;
    private final String employeur;
    private final String codePostalHabitation;
    private final String codePostalEmploi;
    private final int salaire;

    public Travailleur(int id, String nom, String prenom, LocalDate dateDeNaissance, String emploi,
                       String employeur, String codePostalHabitation, String codePostalEmploi, int salaire) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.emploi = emploi;
        this.employeur = employeur;
        this.codePostalHabitation = codePostalHabitation;
        this.codePostalEmploi = codePostalEmploi;
        this.salaire = salaire;
    }

    // Construit un Travailleur à partir d'une ligne du CSV
    public static Travailleur depuisLigneCsv(String ligne) {
        String[] colonnes = ligne.split(",");
        if (colonnes.length != 9) {
            throw new IllegalArgumentException("Ligne CSV invalide : " + ligne);
        }
        // Les dates sans zéro initial (ex : 3111972) sont complétées pour obtenir ddMMyyyy
        String date = String.format("%8s", colonnes[3].trim()).replace(' ', '0');

        return new Travailleur(
                Integer.parseInt(colonnes[0].trim()),
                colonnes[1].trim(),
                colonnes[2].trim(),
                LocalDate.parse(date, FORMAT_DATE),
                colonnes[4].trim(),
                colonnes[5].trim(),
                colonnes[6].trim(),
                colonnes[7].trim(),
                Integer.parseInt(colonnes[8].trim())
        );
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public LocalDate getDateDeNaissance() { return dateDeNaissance; }
    public String getEmploi() { return emploi; }
    public String getEmployeur() { return employeur; }
    public String getCodePostalHabitation() { return codePostalHabitation; }
    public String getCodePostalEmploi() { return codePostalEmploi; }
    public int getSalaire() { return salaire; }

    @Override
    public String toString() {
        return prenom + " " + nom + " (" + emploi + ", " + salaire + ")";
    }
}

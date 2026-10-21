package recherchesCSV;

public class Travailleurs {
    private int id;
    private String nom;
    private String prenom;
    private String dateDeNaissance;
    private String emploi;
    private String employeur;
    private String codePostalHabitation;
    private String codePostalEmploi;
    private int salaire;

    public Travailleurs(int id, String nom, String prenom, String dateDeNaissance, String emploi,
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

    public String getPrenom() {
        return prenom;
    }

    public String getEmploi() {
        return emploi;
    }

    public int getSalaire() {
        return salaire;
    }
}
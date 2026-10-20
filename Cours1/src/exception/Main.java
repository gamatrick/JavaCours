package exception;

public class Main {

    static void main() {

        Cagette cagetteDePommes = new Cagette("pomme");

        try {
            cagetteDePommes.ajouter("pomme");
            cagetteDePommes.ajouter("pomme");
            cagetteDePommes.ajouter("poire");
            IO.println("Cette ligne n'est jamais affichée");
        } catch (MelangeFruitsException e) {
            IO.println("Erreur : " + e.getMessage());
            IO.println("Fruit refusé : " + e.getFruitRefuse());
        } finally {
            IO.println("Total dans la cagette : " + cagetteDePommes.getQuantite() + " pomme(s)");
        }

    }
}
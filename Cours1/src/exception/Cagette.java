package exception;

public class Cagette {

    private final String typeDeFruit;
    private int quantite = 0;

    public Cagette(String typeDeFruit) {

        this.typeDeFruit = typeDeFruit;

    }

    public void ajouter(String fruit) throws MelangeFruitsException {

        if (!fruit.equals(typeDeFruit)) {
            throw new MelangeFruitsException(
                    "On ne mélange pas les " + typeDeFruit + "s et les " + fruit + "s !",
                    fruit
            );
        }

        quantite++;
        IO.println("1 " + fruit + " ajoutée. La cagette contient " + quantite + " " + typeDeFruit + "(s)");

    }

    public int getQuantite() {

        return quantite;

    }
}
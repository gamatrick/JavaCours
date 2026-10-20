package exception;

public class MelangeFruitsException extends Exception {

    private final String fruitRefuse;

    public MelangeFruitsException(String message, String fruitRefuse) {

        super(message);
        this.fruitRefuse = fruitRefuse;

    }

    public String getFruitRefuse() {

        return fruitRefuse;

    }
}
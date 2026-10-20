import java.util.HashSet;
import java.util.Set;

public class exo2 {
    static void main() {

        Set<String> chaines = new HashSet<String>();
        chaines.add("a");
        chaines.add("b");
        chaines.add("3");
        IO.println("exo1");

        chaines.add("a");
        chaines.add("b");
        chaines.add("3");
        IO.println("exo1");

        System.out.println("Chaines: " + chaines.size());

    }
}

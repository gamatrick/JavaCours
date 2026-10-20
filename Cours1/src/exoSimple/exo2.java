package exoSimple;

import java.util.HashSet;
import java.util.Set;

public class exo2 {
    static void main() {

        Set<String> chaines = new HashSet<String>();
        chaines.add("a");
        chaines.add("b");
        chaines.add("3");
        IO.println("exoSimple.exo1");

        chaines.add("a");
        chaines.add("b");
        chaines.add("3");
        IO.println("exoSimple.exo1");

        System.out.println("Chaines: " + chaines.size());

        for(String ch : chaines) {
            IO.println(ch);
        }

        // on constate que l'ordre n'est pas conserver et que les doublons ne sont pas conserver

    }
}

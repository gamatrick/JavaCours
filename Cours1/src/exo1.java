import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Gatherer;


/*
* Exo pour afficher des variables
* */
public class exo1 {
    public static void main(String[] args) {
        List<String> chaines = new ArrayList<>();

        chaines.add("a");
        chaines.add("b");
        chaines.add("3");
        IO.println("exo1");

        /*
        Iterator<String> iterator = chaines.iterator();
        while (iterator.hasNext()) {
            IO.println( iterator.next() );
        }
        */

        for(int i = 0; i < chaines.size(); i++){
            System.out.println( chaines.get(i) );
        }

        for (String ch: chaines){
            IO.println(ch);
        }

    }
}

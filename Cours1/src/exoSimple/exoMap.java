package exoSimple;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class exoMap {

    static void main(){
        Map<String,Long> salaires = new HashMap<>();

        salaires.put("Alice", 2000l);
        salaires.put("Bob", 2000l);
        salaires.put("Kylian", 2000000l);
        salaires.put("Sophie",4000l);
        salaires.put("Daniel",5000l);

        //quel est le salaire de bab ?
        Long salaireBob = salaires.get("Bob");
        System.out.println(salaireBob);

        System.out.println(salaires.get("Kylian"));
        //Attention à la casse des clefs

        //Redefinir le Entry car sinon il ce call sur rien donc on remet le setup de Map
        Set<Map.Entry<String,Long>> entrees = salaires.entrySet();

        /*
        for(Map.Entry e : entrees){
            IO.println(e.getKey() + " ----> " + e.getValue());
        }
        */

        for(String key : salaires.keySet()){
            IO.println(key + " ---> " + salaires.get(key));
        }

    }
}

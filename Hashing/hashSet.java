package Hashing;
import java.util.HashSet;
import java.util.Iterator;
public class hashSet {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        set.add(2);
        System.out.println(set); //only stores unique elements
        if(set.contains(1)){
            System.out.println("contains 1");
        }
        if(set.contains(21)){
            System.out.println("contains 21");
        }

        set.remove(1);
        if(set.contains(1)){
            System.out.println("contains 1");
        }
        set.clear();
        System.out.println(set.size());
        
        System.out.println(set.isEmpty());

        //iterations on hash set -> 1st method
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Bengaluru");

        Iterator it = cities.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("2nd method to iterate");
        for(String city : cities){
            System.out.println(city);
        }

        

    }
}

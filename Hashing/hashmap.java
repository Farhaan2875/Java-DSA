package Hashing;
import java.util.HashMap;
public class hashmap {
    public static void main(String[] args) {
        //create
        HashMap<String, Integer> hm = new HashMap<>();

        //insert --> O(1)
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 20);

        System.out.println(hm);

        //get -> O(1)
        int pop = hm.get("India");
        System.out.println(pop);

        //if we try to acces a key which does not exist -> It returns null

        //ContainsKey - O(1)
        System.out.println(hm.containsKey("India")); //true
        System.out.println(hm.containsKey("UK")); //false

        //Remove
        int del = hm.remove("China");
        System.out.println(del);
        System.out.println(hm);
        //returns null if key to remove does not exits

        //size
        System.out.println(hm.size());

        //isempty
        System.out.println(hm.isEmpty());

        //clear
        hm.clear();
        System.out.println(hm);
        System.out.println(hm.isEmpty());

    }
}

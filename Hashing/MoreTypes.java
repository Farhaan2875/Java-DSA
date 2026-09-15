package Hashing;
import java.util.LinkedHashMap;
import java.util.TreeMap;
public class MoreTypes {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

        lhm.put("India", 100);
        lhm.put("China", 90);
        lhm.put("US", 50);
        lhm.put("Autria",20);
        System.out.print("Linked Hash map: " );
        System.out.println(lhm); //ordered in the same way we inserted -? simple hash map does not follow order


        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 100);
        tm.put("China", 90);
        tm.put("US", 50);
        tm.put("Autria",20);
        System.out.print("Tree map : ");
        System.out.println(tm);

    }
}

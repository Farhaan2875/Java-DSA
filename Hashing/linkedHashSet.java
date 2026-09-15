package Hashing;
import java.util.LinkedHashSet;
import java.util.TreeSet;
public class linkedHashSet {
    public static void main(String[] args) {
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Bangalore");
        lhs.add("Bombay");
        System.out.println(lhs);

        //all operations are same as hash set -> same code

        TreeSet<String> ts = new TreeSet<>();
        ts.add("Delhi");
        ts.add("Bangalore");
        ts.add("Bombay");
        System.out.println(ts);
    }
}

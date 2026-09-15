package queue;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;

public class queueJCF{
    public static void main(String[] args) {
        //IMP -> refer OOPS LECTURE -> queue not a class but an interface and we cannot create objects of interfaces thats why we implement queue through two classes -> LinkedList or ArrayDeque
        Queue<Integer> q = new LinkedList<>();
//LEARN ABOUT DIFFERENCE IN both classes implementing queue form internet
        // Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
        
        //all operation are done in O(1) tc
    }
}
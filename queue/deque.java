package queue;
import java.util.*;
public class deque {
    //Stack and queue usinf deque
    static class Stack {
        Deque<Integer> deque = new LinkedList<>();

        public void push(int data){
            deque.addLast(data);
        }

        public int pop(){
            return deque.removeLast();
        }

        public int peek(){
            return deque.getLast();
        }

    }
    static class Queue{
        Deque<Integer> deque = new LinkedList<>();

        //add
        public void add(int data){
            deque.addLast(data);
        }
        //remove
        public int remove(){
            return deque.removeFirst();
        }
        //peek
        public int peek(){
            return deque.getFirst();
        }

    }

    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();
        //Deque is also an interface in java and not a class
        dq.addFirst(1);
        dq.addFirst(2);
        System.out.println(dq);
        dq.addLast(3);

        System.out.println("last ele " + dq.getLast());
        System.out.println("last ele " + dq.getFirst());

        System.out.println(dq);


        //stack using deque
        Stack s = new Stack();
        s.push(11);
        s.push(9);
        s.push(19);

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

        //queue using deque
        Queue q = new Queue();
        q.add(192);
        q.add(222);

        System.out.println(q.remove());
        System.out.println(q.remove());






        
    }
}

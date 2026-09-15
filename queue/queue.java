package queue;

import java.util.*;

public class queue {
    static class Queue{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        //add
        public static void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while(!s2.empty()){
                s1.push(s2.pop());
            }
        }

        //remove
        public static int remove(){
            if(isEmpty()){
                System.out.println("queue empty");
                return -1;
            }
            return s1.pop();
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("queue empty");
                return -1;
            }
            return s1.peek();
        }
    }
    public static void main(String[] args) {
        //implement queue using 2 stacks
        //add o(n)
        // add and remove -> o(1)
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }

        
    }
}

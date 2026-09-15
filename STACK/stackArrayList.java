package STACK;
import java.util.ArrayList;
public class stackArrayList {
    static class Stack{
        static ArrayList<Integer> list = new ArrayList<>();
        public static boolean isEmpty(){
            return list.size() == 0;
        }

        //push
        public static void push(int data){
            list.add(data); //adds aat last index //O(1)
        }
        public static int pop(){//we want ti return the deleted data
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size()-1);//O(1)
            list.remove(list.size()-1); //o(1)
            return top;
        }
        //peek
        public static int peek(){
            if(isEmpty()){ //not used .list here as fucntion is already defined here
                return -1;
            }
            return list.get(list.size()-1);
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
            //lifo fshion

        }
    }
}
package queue;
import java.util.*;

import javax.management.QueryEval;
public class qs {

    //queue reversal
    public static void reverseQueue(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }


    public static void interleave(Queue<Integer> q){
        Queue<Integer> firsthalf = new LinkedList<>();
        int size = q.size(); ///finding size

        for(int i=0; i<size/2;i++){
            firsthalf.add(q.remove());
        }
        while(!firsthalf.isEmpty()){
            q.add(firsthalf.remove());
            q.add(q.remove());
        }

    }
    public static void printNonRepeating(String str){
        int freq[] = new int[26]; //to store letters from a to z
        Queue<Character> q = new LinkedList<>();

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;

            while(!q.isEmpty() && freq[q.peek() - 'a']>1){
                q.remove();
            }

            if(q.isEmpty()){
                System.out.print(-1 +" ");
            }else{
                System.out.print(q.peek() + " ");
            }
        }

        System.out.println();
    }
    public static void main(String[] args) {
        String str = "aabccxb";
        printNonRepeating(str);
        String str2 = "aabxxmoo";
        printNonRepeating(str2);

        //interleave
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        interleave(q);
        while(!q.isEmpty()){
            System.out.print(q.remove() + " ");
        }
        System.out.println();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        reverseQueue(q);
        while(!q.isEmpty()){
            System.out.print(q.remove() + " ");
        }
        System.out.println();



    }
}

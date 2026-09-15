package linkedList;

import java.util.LinkedList;

public class LinkedList3 {
    public static void main(String[] args) {
        //java collections framework -> used to implement in built data structures
        //we learned to built linked list from scratch because in some problems we needd to maek data strcutures with modifications asd interview can asked to make from scratchc -> we SHOULD know how to implement data structures from scratch

        //in coding test -> use collections instead of making scratch unless asked -> as they are having best tc and ez to implement

        //create
        // in linked list we can store objects just like arraylist -> use classes like Integer, Float, Character etx
        LinkedList<Integer> ll = new LinkedList<>();
        
        //add
        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(0);

        System.out.println(ll);

        ll.removeLast();
        ll.removeFirst();
        System.out.println(ll);

    }
}

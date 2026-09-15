package linkedList;

public class LinkedList {
    public static class Node{
        int data;
        Node next;

        public Node(int data){//constructor
            this.data = data;
            this.next = null;
        }
    }
    //in linked list we have a single head node and a  single tail node --> we cna define it in our class as property
    public static Node head; //both are of Node type
    public static Node tail;


    public static void main(String[] args) {
        LinkedList ll = new LinkedList();//created object ll of LinekdList class and we will create objects of Node class in this

        //here we are doing operatiions like adding nodes and moving references manually in main function --> we will create them in linked list class as methods instead of here -> refer to Linkedlist2
        ll.head = new Node(1);
        ll.head.next = new Node(2);


    }
}

package linkedList;
public class DoubleLl {
    public class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    //add first
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head= newNode;


    }
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(tail==null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        newNode.next = null;
    }
    //remove last
    public int removeLast(){
        if(tail==null){
            System.out.println("nothing to remove here");
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = tail.data;
        tail = tail.prev;
        tail.next = null; //we only need to make sure that the link in not accessible then garbage colector will delete it, we dont need to rem0ve both links just make sure that the one deleted is not accessible anymore
        size--;
        return val;
    }
    //remove first
    public int removeFirst(){
        if(head==null){
            System.out.println("doubly ll is empty");
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;

    }

    public void print(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void reverse(){
        Node curr = head;
        Node prev = null;
        Node next;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            
            prev = curr;
            curr = next;
        }
        head = prev;

    }

    public static Node head;
    public static Node tail;
    public static int size;
    public static void main(String[] args) {
        DoubleLl dll = new DoubleLl();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.print();

        dll.removeFirst();
        dll.print();
        System.out.println("size is " + size);

        dll.addLast(20);
        dll.print();
        System.out.println("size is " + size);

        dll.removeLast();
        dll.print();

        dll.reverse();
        dll.print();  

    }
}

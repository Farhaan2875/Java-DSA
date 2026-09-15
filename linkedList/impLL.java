package linkedList;
public class impLL{
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size; //java initialisez ts as zero
    //we wan =t size of our linked list thorugh this
    //we will use this in such a way that we dont need to traverse the linked list

    //we can make non static fns here because we are not calling directly from main -> we are using linked list object to call these fucntions

    //IMPLEMENTING -> ADD FIRST 
    public void addFirst(int data){//takes O(1) time to add first
        //when empty linked list
        if(head==null){
            Node newNode = new Node(data); //creating new
            size++;
            head = tail = newNode;
            return;
        }

        //if more than 1 node
        //step1 -> new node
        Node newNode = new Node(data);
        size++;
        //step 2 -> newNode next points to previous head
        newNode.next = head; //Linking step -> creates linked list (we storing reference of head not of the data in the peavious head's node -> doesnt matter if nodes data changes -> it refers to the same object of Node class) --> even when head is changed -> it refers ot the same node -> link maintains

        //step3 -> new node becomes head
        head = newNode;
    }

    //ADD LAST IN LINEKD LIST
    public void addLast(int data){
        if(head==null){//we can put tail == null here but by convention we consider linekdlist to be empty if its head is empty
        Node newNode = new Node(data);
        size++;
        head = tail = newNode;
        }
        Node newNode = new Node(data);
        size++;
        tail.next = newNode;

        tail = newNode;
    }

    //METHOD TO ADD A NODE IN THE MIDDLE OF LINKED LIST
    public void add(int idx,int data){
        if(idx==0){ //bcuz we need to change the head when add first
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while(i<idx-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

        if (newNode.next == null) { // last position insertion
        tail = newNode;
    }
    }

    //METHOD TO PRINT LINKED LIST
    public void print(){

        //we use temp of type Node to traverse each node and print them
        if(head==null){
            System.out.println("linkedlist is empty");
            return;
        }

        Node temp = head;
        while(temp!= null){ //until next refers to null ie tail is reached
            System.out.print(temp.data+"->");
            temp = temp.next;//refers to next node
        }
        System.out.println("null");
    }
    public int removeFirst(){//to remove the first node
    //took int bcuz we wanted to show the data being deleted
    // to remove a node -> we need to shift only the head, after this garbage disposal automatically frees the deleted node after noticing that it has no link with anyone
    if(size==0){
        System.out.println("ll is empty");
        return Integer.MIN_VALUE;//means returned invalid
    }
    else if(size==1){
        int val = head.data;
        head=tail=null;
        size = 0;
        return val;
    }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size==0){
            System.out.println("ll is mepty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        //we need to traverse to the second last node to delete last node
        Node prev = head;
        for(int i=0;i<size-2;i++){
            prev = prev.next;
        }
        int val = prev.next.data; //collectinf data of node to be deleted -> to show kya delete kiya
        prev.next=  null;
        tail = prev;
        size--;
        return val;

    }
    
    //searching iteratively in a linked list for a key
    public int itrSearch(int key){//return the found index
        Node temp = head;
        int i = 0;
        while(temp!=null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1; //key not found
    }

    //recursive search in a linked list
    public int helper(Node head, int key){ //helper for recursive search
        if(head==null){
            return -1;//key doesnt exist
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx==-1){
            return -1;
        }

        return idx + 1; //backtraccking me index find out

    }
    public int recSearch(int key){
        return helper(head,key);
        //tc is O(n) and sc is O(n) as space i taken up in stack
    }

    public void reverse(){
        Node prev = null;
        Node curr = tail =  head; //prev head is now the new tail
        Node next;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;//assigns head to the previous last
        //takes O(n) time to reverse linkedlist

    }

    public void removeNthFromLast(int n){
        //calculate size of ll
        int sz = 0;
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            sz++; //finding size in this fn only
        }
        if(n==size){//head delete corner case
            head = head.next;
            return;
        }
        //nth from last is sz-n+1 from start -> but we need to go to one node prev to change its next
        int i=1;
        int iToFind = sz-n;
        Node prev = head;
        while(i<iToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;

    }
    public Node findMid(Node head){
        //SLOW-FASST/TURTLE HARE TECHNIQUE -> VERY IMP FOR OTHER QS
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){ //jo pehle reach ho
            slow = slow.next;//+1
            fast = fast.next.next;//+@
        }
        return slow; //slow is my middle Node
    }
    public boolean palindromeNode(){
        //step 1 find mid
        if(head ==null || head.next ==null){
            return true;
        }
        Node midNode = findMid(head);

        //step 2 reverse second half
        Node prev = null;
        Node curr  = midNode;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev; //right half head
        Node left = head; //left half head

        //step 3 compare both halves
        while(right!=null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        
        return true;


    }

    //to find if ll is cyclic or not
    public static boolean isCycle(){ //floyds cycle finding algoeithm 
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }

        }
        return false;
    }

    public static void removeCycle(){
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow){
                cycle = true;
                break;
            }
        }
        if(cycle==false){return;}

        slow = head;
        Node prev = null;//will find last node
        while(slow!=fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        //end with null
        prev.next = null;
        //this code fails when the cylic link list linkes at head 
    }

    //mergesort for ll
    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;        
        }
        return slow; //mid node

    }
    private Node merge(Node head1, Node head2){
        Node mergedLL = new Node(-1); //dummy for comparison initially
        Node temp  = mergedLL;

        while(head1!=null && head2!=null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        //for remaining elements
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next; //-1 was dummy -> need to delete that
    }
    private Node mergeSort(Node head){
        if(head==null || head.next == null){
            return head;
        }
        //find mid
        Node mid = getMid(head);

        //left and right ms
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        return merge(newLeft,newRight);
    }

    //ZIG ZAG LINKEDLIST
    //means convert ll to a zig zig ll
    //1-2-3-4-5 to 1-5-2-4-3
    public void zigzag(){
        //find mid
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;


        //3 variable and 4 steps to reverse
        //reverse 2nd half ->
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev; //left and right heads

        Node nextL,nextR;

        //alternate assigning
        while(left!=null && right!=null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;
            //updating
            left = nextL;
            right = nextR;
        }
        

    }
//The GC only deletes objects that are unreachable (i.e., no variables or fields point to them anymore).

// If you keep a head pointer to the start of your linked list, then every node connected by .next from that head is still reachable.
// So even if you rearrange links, as long as the chain is continuous from head, none of those nodes will be garbage-collected.
    public static void main(String[] args) {
        impLL demo = new impLL();
        demo.addFirst(12);
        demo.addFirst(2);
        demo.addFirst(1);
        demo.addFirst(0);
        demo.addFirst(9);

        demo.print();

        head = demo.mergeSort(head);

        demo.print();

        demo.zigzag();
        demo.print();

    }
}

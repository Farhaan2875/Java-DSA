package linkedList;

import java.util.List;

public class impqs {
    public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA!=tempB){ ///we make them travel the same distance this way wither they meet at intersect or meet at null -> total dist travelled by both nodes = (lenof A + lenofB)
            tempA = (tempA==null)?headB:tempA.next;
            tempB = (tempB==null)?headA:tempB.next;
        }
        return tempA;
    }
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        // Step 1: get size
        int size = 0;
        ListNode temp = head;
        while(temp != null) {
            size++;
            temp = temp.next;
        }

        // Step 2: find kth node from start
        ListNode prev1 = null, node1 = head;
        for(int i = 1; i < k; i++){
            prev1 = node1;
            node1 = node1.next;
        }

        // Step 3: find kth node from end
        ListNode prev2 = null, node2 = head;
        for(int i = 1; i < size - k + 1; i++){
            prev2 = node2;
            node2 = node2.next;
        }

        // If same node, nothing to swap
        if(node1 == node2) return head;

        // Step 4: handle adjacency
        if(node1.next == node2){ // node1 before node2
            if(prev1 != null) prev1.next = node2;
            else head = node2;
            node1.next = node2.next;
            node2.next = node1;
            return head;
        }

        // Step 5: general case
        if(prev1 != null) prev1.next = node2;
        else head = node2;

        if(prev2 != null) prev2.next = node1;
        else head = node1;

        ListNode tempNext = node1.next;
        node1.next = node2.next;
        node2.next = tempNext;

        return head;
    }
    public ListNode removeNele(ListNode head, int m, int n){
        //remove n elements after m elements in a linked list
        if(head==null){
            return head;
        }
        ListNode temp = head;
        for(int i=1;i<m && temp!=null;i++){
            temp = temp.next;
        }
        if(temp==null){
            return head;
        }
        ListNode aftr = temp.next;
        for(int j=1;j<=n && aftr!=null;j++){
            aftr = aftr.next;
        }

        temp.next = aftr;
        return head;
    }
    public ListNode EvenOdd(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode evenHead = null;
        ListNode oddHead = null;
        ListNode evenTail = null;
        ListNode oddTail = null;
        ListNode curr = head;
        while(curr!=null){
            if(curr.val%2==0){
                if(evenHead==null){
                    evenHead = curr;
                    evenTail = curr;
                }else{
                    evenTail.next = curr;
                    evenTail = curr;
                }
            }else{
                if(oddHead==null){
                    oddHead = curr;
                    oddTail = curr;
                }else{
                    oddTail.next = curr;
                    oddTail = curr;
                }
            }
            curr = curr.next;
        }
        if(evenHead!=null){
            evenTail.next = oddHead;
        }
        if(oddHead!=null){
            oddTail.next = null;
        }

        return (evenHead!=null)?evenHead:oddHead;

    }
    public static void main(String[] args) {
        
    }
}

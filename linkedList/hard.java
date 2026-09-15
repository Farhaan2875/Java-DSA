package linkedList;

import linkedList.impqs.ListNode;

public class hard {
    //LEETCODE 25 HARD --> REVERSE LL IN K GROUPS
    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev; //returning the new head

    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next==null){
            return head;
        }
        ListNode temp = head;
        int l = 1;
        while(temp.next!=null){
            temp = temp.next;
            l++;
        }
        if(l<k){
            return head; //when nodes to reverse in a group is larger than the size of ll
        }
        int rl = l; 
        temp = head; //temp is used to traverse 
        ListNode thead = head;
        ListNode rhead;
        ListNode next; //to store the head of next group to be reversed
        ListNode permhead = head; //new head os resultant ll
        ListNode prevtail = null; //tail of previous group
        while(rl>=k){
            for(int i=1;i<k;i++){
                temp = temp.next;
            }
            next = temp.next;
            temp.next = null; //made next of tail null so that it can be sent to be reversed in groups
            rhead = reverse(thead); //new head of reversed k group
            if(rl==l){
                permhead = rhead; //store permamnent head
            }else{
                prevtail.next = rhead; //else connect the previous tail to the new head
            }
            prevtail = thead;
            rl-=k;
            temp = next;
            thead = next;
        }
        if(rl!=0){//connecting the remaing nodes which were out of bound to be reversed
            prevtail.next = temp;
        }
        return permhead;
    }
    public static void main(String[] args) {
        
    }
}

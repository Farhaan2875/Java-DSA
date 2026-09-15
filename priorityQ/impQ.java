package priorityQ;

import java.util.PriorityQueue;
public class impQ {
    static class Node implements Comparable<Node>{
        int val;
        int idx;
        public Node(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
        @Override
        public int compareTo(Node n2){
            if(this.val == n2.val){ //i forgot to put this tie breaker here 
                return this.idx - n2.idx; //if value of two nodes is same then the node with smaller index is stored first in the pq -> thus maintaining order of multiplication in array
            }
            return this.val - n2.val;
        }
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(new Node(nums[i], i));
        }

        while(k>0){
            Node temp = pq.remove();
            temp.val = temp.val*multiplier;
            pq.add(temp);
            k--;
        }
        int arr[] = new int[nums.length];
        while(!pq.isEmpty()){
            Node temp = pq.remove();
            arr[temp.idx] = temp.val;
        }

        return arr;
    }
}

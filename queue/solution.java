package queue;
import java.util.*;
public class solution {

    public static void generateBinary(int N) {//direction conversion using Integer.toBinaryString(i) is faster but we nnneeded to apply queue here
        Queue<String> q = new LinkedList<>();
        q.add("1");

        for (int i = 1; i <= N; i++) {
            String curr = q.poll(); // get front
            System.out.println(curr);

            // append 0 and 1
            q.add(curr + "0");
            q.add(curr + "1");
        }
    }
    public static int minCost(int[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //priority queue by default gets the smallest element in the queue but we also get the max element by changing its comparator
        int intermediate_cost = 0;
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        while(pq.size()>1){
            int first = pq.poll();
            int second = pq.poll();
            intermediate_cost += first + second;
            pq.add(first + second);
        }
        return intermediate_cost;
    }

    public static Queue<Integer> reverseFirstK(Queue<Integer> q, int k){
        Stack<Integer> s = new Stack<>();
        for(int i=1;i<=k;i++){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
        int remaining = q.size() - k;
        while(remaining!=0){
            int digit = q.remove();
            q.add(digit);
            remaining--;
        }
        return q;
    }

    //LEETCODE HARD
    //classical dsa problem -> concept used is SLIDING WINDOW
    public static void maxInSubarray(int[] arr,int k){
        Deque<Integer> dq = new LinkedList<>(); //k is the size of the subarray
        for(int i=0;i<arr.length;i++){
            //removing the elements out of the current window
            if(!dq.isEmpty() && dq.peekFirst()<= i-k){
                dq.removeFirst();
            }
            //removing smaller elements from the back
            while(!dq.isEmpty() && arr[dq.peekLast()]<=arr[i]){
                dq.removeLast();
            }
            dq.addLast(i);


            if(i>=k-1){ //ensures that atleast a single sub array of k size os formed b4 we print --> will work for all i greater than or equal to 2 if k is 3.
                System.out.println(arr[dq.peek()]);
            }
        }

    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(minCost(arr));

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
        System.out.println(reverseFirstK(q, 5));


        int[] krr = {1,2,3,1,4,5,2,3,6};
        maxInSubarray(krr, 3);

    }
}

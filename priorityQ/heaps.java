package priorityQ;
import java.util.*;
public class heaps {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){ //O(logn)
            //add at last index
            arr.add(data);
            int x = arr.size() - 1; //child index
            int par = (x - 1)/2;

            while(arr.get(x) < arr.get(par)){ // tc-> O(logn) //we do this while i != 0
                //swap
                int temp = arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par,temp);

                x = par; //updating new parent and child for the while loop
                par = (x-1)/2;
            } 
        }
 
        public int peek(){
            return arr.get(0); 
        }
        private void heapify(int i){
            int left = 2*i + 1;
            int right = 2*i + 2;
            int minIdx = i; //asuming that root is of min val

            if(left < arr.size() && arr.get(minIdx) > arr.get(left)){ //first if condiiton -> making sure that index does not go out of bound for root
                minIdx = left;
            }
            if(right < arr.size() && arr.get(minIdx) > arr.get(right)){
                minIdx = right;
            }

            if(minIdx != i){ //if tree already fixed dont change
                //swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx); //checking and fixing for the subtree
            }

        }
        public int remove(){ //removes the first element in heap/ root
            int data = arr.get(0);

            //step1 swap first and last
            int temp = arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //step 2 -delete last
            arr.remove(arr.size()-1);


            //step 3 heapify ->
            heapify(0);
            return data; //just  returning the value we returned

        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }
    public static void main(String[] args) {
        Heap h = new Heap(); //THIS is called heap -> but the work done is same as priority queue
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.remove();

        }

    }
}

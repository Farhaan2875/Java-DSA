package priorityQ;
import java.util.*;
public class maxheap {
    //TO CONVERT MIN HEAP TO MAX HEAP -> JUST CHANGE THE SIGN (<,>) -> WILL CHANGE TO LOGIC
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){ //O(logn)
            //add at last index
            arr.add(data);
            int x = arr.size() - 1; //child index
            int par = (x - 1)/2;

            while(arr.get(x) > arr.get(par)){ // tc-> O(logn)
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
            int maxIdx = i; //asuming that root is of min val

            if(left < arr.size() && arr.get(maxIdx) < arr.get(left)){ //first if condiiton -> making sure that index does not go out of bound for root
                maxIdx = left;
            }
            if(right < arr.size() && arr.get(maxIdx) < arr.get(right)){
                maxIdx = right;
            }

            if(maxIdx != i){ //if tree already fixed dont change
                //swap
                int temp = arr.get(i);
                arr.set(i, arr.get(maxIdx));
                arr.set(maxIdx, temp);

                heapify(maxIdx); //checking and fixing for the subtree
            }
            //here hepify only heapify the root node called -> if you want to heapify the whole tree -> call the heapify function for all non leaf nodes -> i.e from n/2 to 0 (i--);

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


package array;
import java.util.ArrayList; //now can use arraylist class
import java.util.Collections;

public class arrayList {
    public static void swap(ArrayList<Integer> list, int idx1, int idx2){
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }
    public static void main(String[] args) {

        //Internal Implemetatio of ArratList --> ArrayLists are implemeted as arrays --> java creates an array of a specified size and then when it is filled and we try to add more elements then java make a new array and its size is made 2 times or 1.5 times (depending on version) and this process goes on. when new created the old array gets deleted from the memory (after its contents are copied to the new one )


        ///ArrayList is part of java collections framework(this consists of many useful components)

        //arraylist is in built data type like array
        //unlike array arraylist has dynamic size (array size is expllicitly declared)

        //array can store primitive data type and non primitive data type
        //arralst can only store non primitive data types (like Integer class objects instead of int)

        //by convention in java names of classes start with upper case --> String ArrayList Boolean class(not boolean data type)
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Boolean> list3 = new ArrayList<>();


        //adding an elemnt to array list ->takes 0(n)

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.err.println(list);

        //only way to get element/access element -> O(1) time
        int element = list.get(2); //this is index
        System.out.println(element);

        //rmeove element -> O(n) time
        list.remove(2);//index
        System.out.println(list);

        //set element at index -> means to replace element -> O(n)
        list.set(2,10);
        System.out.println(list);

        //contains element -> returns boolean -> O(n)
        System.out.println(list.contains(10));

        //another form of add
        list.add(1,9); //ad element and index and pushes other element to the right -> O(n)
        System.out.println(list);

        // size of an array list
        System.out.println("size of list is " + list.size()); //.size is not a function its a method

        //printing arra list
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i) + " ");
        }

        //finding maximum element in an arraylist
        int max = Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++){
            if(list.get(i)>max){
                max = list.get(i);
            }
        }
        System.out.println();
        System.out.println("max in list is " + max);

        swap(list, 1, 3);
        System.out.println(list);

        ///sorting an array list --> all sorting techniques can be used here just like arrays
        /// in built sorting methods using Collections class
        /// Collections is a class(used for sorting) but Collection is an interface
    
        Collections.sort(list); //sorts in ascending order
        System.out.println(list);

        //descending order using in built
        Collections.sort(list, Collections.reverseOrder());
        //reverseorder() -> ex of comparator -> a fn that defines logic -> these can be applied to objects of class also
        // we can make/modify comparator to suit our logic instead of built in logic of sorting


        //MULTI DIMENSIONAL ARRAY LIST
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(1); l1.add(4);
        mainList.add(l1);

        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(9); l2.add(29);
        mainList.add(l2);
         
        System.out.println(mainList);
        for(int i=0;i<mainList.size();i++){
            ArrayList<Integer> currList = mainList.get(i);
            for(int j=0;j<currList.size();j++){
                System.out.print(currList.get(j) + " ");
            }
            System.err.println();
        }







    }
}
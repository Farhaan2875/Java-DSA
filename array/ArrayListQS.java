package array;
import java.util.ArrayList;
public class ArrayListQS {
    public static int mostWater(ArrayList<Integer> height){
        //2 pointer --> visualize by pen and pencil to better understand 
        //O(n) time -> 2 POINTER APPROACH --> we use two pointers or indices or variables and manipulate them accordingly
        int maxwater = 0;
        int lp = 0;
        int rp = height.size()-1;
        while(lp<rp){
            int ht = Math.min(height.get(lp),height.get(rp));
            int width = rp-lp;
            int currwater = ht * width;
            maxwater = Math.max(maxwater,currwater);
            if(height.get(lp)<height.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }
        return maxwater;
        ///tc is O(n) bcus lp+rp travel distance n with the confition of while loop
    }

    public static boolean pairSum(ArrayList<Integer> list,int target){
        //qs- > given a sorted array return true is there exist a pair of elements whose sum is equal to target
        int lp = 0;
        int rp = list.size() - 1;
        while(lp!=rp){
            //case 1
            if(list.get(lp)+list.get(rp)==target){
                return true;
            }
            //case 2
            if(list.get(lp)+list.get(rp)<target){
                lp++;
            }
            //cas3  3
            if(list.get(lp)+list.get(rp)>target){
                rp++;
            }
        }
        return false;
    }

    public static boolean pairSum2(ArrayList<Integer> list, int target){
        //here the array was originally sroted but at a pivot point if got rotated lile [1,2,3,4,] ->[3,4,1,2]
        //first kam -> find out breaking point
        //concept -> lp starts at smallest element and right at the largest element
        

        //Modular Arithemtic -> Math concepts used in Programming -> used in this qs

        int breakingPoint = -1;
        int n = list.size();
        for(int i=0;i<list.size();i++){
            if(list.get(i) > list.get(i+1)){ //bp found
                breakingPoint = i;
                break;
            }
        }
        int lp = breakingPoint+1; //smallest int in array
        int rp = breakingPoint;
        while(lp!=rp){
            //case 1
            if(list.get(lp)+list.get(rp)==target){return true;}

            //used modulo arithemtic
            if(list.get(lp)+list.get(rp)<target){
                lp = (lp+1)%n;
            }
            else{
                rp = (n+rp-1) % n;
            }
        }
        return false; 

        //O(n) tc as both the pointer cover n fistance which is ewual to array length until their not equal condition are met
    }
    public static void main(String[] args) {
        //container with most water
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(8);
        arr.add(6);
        arr.add(2);
        arr.add(5);
        arr.add(4);
        arr.add(8);
        arr.add(3);
        arr.add(7);
        System.out.println(mostWater(arr));
        System.err.println(pairSum(arr, 15));

        //sorted and rotated list
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(11);
        l2.add(15);
        l2.add(6);
        l2.add(8);
        l2.add(9);
        l2.add(10);
        int t2 = 16;
        System.out.println(pairSum2(l2, t2));
    }
}

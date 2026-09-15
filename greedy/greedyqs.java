package greedy;
import java.util.*;
public class greedyqs {

    //minimum absolute differencce -> pair elements of two arrays such that sum of their absolute differences is minimumm (arrays are of same length)
    //we sort both the arrays -> abs differencce is minimum when the digits are close to each other
    //greedy approach
    public static int minAbs(int[] a,int[] b){
        Arrays.sort(a);
        Arrays.sort(b);
        int mindiff = 0;
        for(int i=0;i<a.length;i++){
            mindiff += Math.abs(a[i]-b[i]);
        }
        return mindiff;
    }

    public static int maxPairs(int[][] pairs){ //O(nlogn) -> built in sorting takes nlogn time
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int maxPair = 1; //defualt selcted first pair so +1
        int chainEnd = pairs[0][1];

        for(int i=0;i<pairs.length;i++){
            if(pairs[i][0]>chainEnd){
                maxPair++;
                chainEnd = pairs[i][1];
            }
        }
        return maxPair;
    }
    public static void indianCoins(Integer[] coins){
        Arrays.sort(coins,Comparator.reverseOrder()); // this comparator is only applciablw with Integer obj not int data type
        int count = 0; //counts no of coins
        int amount = 590; //to pay
        ArrayList<Integer> ans= new ArrayList<>(); //to store selected coins

        for(int i=0;i<coins.length;i++){
            if(coins[i]<=amount){
                while(coins[i]<=amount){
                    count++;
                    ans.add(coins[i]);
                    amount -= coins[i];

                }
            }
        }
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+ " ");
        }
        System.out.println();
        System.out.println("number of coins used to pay = "+count);

    }
    public static void main(String[] args) {
        int a[] = {1,2,3};
        int b[] = {2,1,3};
        //minimum abs
        System.out.println(minAbs(a, b));
        //arrays are call by reference in java so b is sorted in main also
        for(int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }


        //maximum pairs questions
        int pairs[][] = {{5,24},{39,60},{5,28},{27,40},{50,90}};
        System.out.println("max pairs in chain == " + maxPairs(pairs));

        //INDIAN COINS
        Integer coins[] = {1,2,5,10,20,50,100,500,2000};
        indianCoins(coins);

    }
}

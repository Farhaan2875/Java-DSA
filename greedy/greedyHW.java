package greedy;
import java.util.*;
public class greedyHW{
    public static int kthLargestodd(int l, int r, int k){
        int res = -1;
        if(r%2==0){
            r = r-1;
        }
        while(k>0 && r>=l){
            if(k==1) return k;
            r = r-2;
            k--;
        }
        return 0;//not found
    }
    public static int kthLargestOdd(int L, int R, int K) { //in O(1) time and space
    // Step 1: Find the largest odd number within [L, R]
    // If R is odd, take R. Otherwise, take R - 1.
    int largestOdd = (R % 2 == 1) ? R : R - 1;

    // Step 2: Count how many odd numbers exist between L and R.
    int count;
    if ((L % 2 == 1) || (R % 2 == 1)) {
        // If either L or R is odd, then the range has one extra odd number
        count = (R - L) / 2 + 1;
    } else {
        // If both are even, the count is just half of the range
        count = (R - L) / 2;
    }

    // Step 3: If there are fewer odds than K, answer doesn't exist
    if (K > count) return 0;

    // Step 4: Compute the K-th largest odd.
    // Odd numbers decrease by 2 each step, so we subtract (K-1)*2
    int ans = largestOdd - 2 * (K - 1);

    // Step 5: If the result goes below L, it's invalid
    if (ans < L) return 0;

    return ans; // Otherwise, return the valid K-th largest odd number
    }

    public static String lexicoSmallest(int n, int cost){
        //stroing alphabets
        char[] alf = new char[26];
        for(int i=0;i<alf.length;i++){
            alf[i] = (char)(i + 'a');
        }
        StringBuilder ns = new StringBuilder(); //used greedy in this sol
        for(int i=alf.length-1;i>=0 && n>0;i--){
            while(i+1<=cost && n>0){
                ns.append(alf[i]);
                cost -= i+1;
                n--;
                if(cost<n){ //itni bhi kam na hojae ki baaki a ana aa pae
                    // Added the missing condition if (cost < n) → ensures we don’t overshoot and still have enough cost left for remaining slots.
                    ns.deleteCharAt(ns.length()-1);
                    cost += i+1;
                    n++;
                    break;
                }
            }
        }
        while(n>0){
            ns.append('a');
            n--;
        }
        return ns.reverse().toString();
    }
    public static void main(String[] args) {
        int l = -6;
        int r = 3;
        System.out.println(kthLargestodd(l, r, 5));

        //lexocigraphic string of given length and cost
        System.out.println(lexicoSmallest(5, 42));
    }
}
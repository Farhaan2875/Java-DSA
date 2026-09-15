package array;
public class more_arrays2 {

    public static int maxProfit(int[] prices){
        // O(n) time complexity
        int bp = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int i=0;i<prices.length;i++){
            if(bp<prices[i]){
                int profit = prices[i] - bp;
                maxprofit = Math.max(maxprofit,profit);
            }
            else{
                bp = prices[i];
            }
        }
        return maxprofit;
    }

    public static int trappin_rainwater(int height[]){
        // tc is O(n)
        int n = height.length;
        // finding left max boundary 4 each element
        int leftmax[] = new int[n];
        leftmax[0] = height[0];
        for(int i=1;i<n;i++){
            leftmax[i] = Math.max(height[i],leftmax[i-1]);
        }

        // finding right max boundary 4 each element
        int rightmax[] = new int[n];
        rightmax[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--){
            rightmax[i] = Math.max(height[i],rightmax[i+1]);
        }
        //here width of each block is 1 so we dont consider it in multiplication
        int totaltrapped = 0;
        for(int i=0;i<n;i++){
            int waterlvl = Math.min(leftmax[i], rightmax[i]);
            totaltrapped += waterlvl - height[i];
        }

        return totaltrapped;
        
    }
    public static void max_sum_subarray(int marks[]){
        // this solution is of brute force --> T.C -> O(n^3)
        int Currsum = 0;
        int Maxsum = Integer.MIN_VALUE;
        for(int i=0;i<marks.length;i++){
            for(int j=i;j<marks.length;j++){
                Currsum = 0;
                for(int k=i;k<=j;k++){
                    Currsum += marks[k];
                }
                System.out.println(Currsum);
                if(Currsum>Maxsum){
                    Maxsum = Currsum;
                }
            }
        }
        System.out.println("Max sum of any subarray is: "+Maxsum);
    }

    public static void max_subarray_prefix(int numbers[]){
        int Currsum = 0;
        int Maxsum = Integer.MIN_VALUE;
        int prefix[] = new int[numbers.length];
        prefix[0] = numbers[0];
        for(int i=1;i<prefix.length;i++){
            prefix[i] = prefix[i-1] + numbers[i];
        }

        for(int i=0;i<numbers.length;i++){
            for(int j=i;j<numbers.length;j++){
                Currsum = i==0?prefix[j] : prefix[j] - prefix[i-1];
                if(Currsum>Maxsum){
                    Maxsum = Currsum;
                }
            }
        }
        System.out.println("Max sum of any subarray is: "+Maxsum);
    }

    public static void kadanes(int numbers[]){
        //very imp for interviews and competitions
        //most optimised solution --> O(n) TC as loop run only once
        int ms = Integer.MIN_VALUE;
        int cs = 0;
        for(int i=0;i<numbers.length;i++){
            cs = cs + numbers[i];
            ms = Math.max(cs,ms);
            if(cs<0){
                cs = 0;
            }

        }
        System.out.println("max subarray sum by kadanes is: " + ms);
    }

    

    public static void main(String args[]){
        int marks[] = {1,-2,6,-1,3};
        max_sum_subarray(marks); 

        //prefix array optimised solution
        max_subarray_prefix(marks);

        int numbers[] = {-2,-3,4,-1,-2,1,5,-1};
        int allneg[] = {-1,-2,-3,-4};
        kadanes(allneg);


        // trapped rainwater --lc hard prob
        int height[] = {4,2,0,6,3,2,5};
        System.out.println("Total rainwater collected is " + trappin_rainwater(height));


        //buy and sell stocks
        int prices[] = {7,2,1,3,6,0};
        System.out.println("max profit from stocks is : " + maxProfit(prices));
    }

}

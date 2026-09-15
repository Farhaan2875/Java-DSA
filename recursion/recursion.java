public class recursion {

    public static void printDecr(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        System.out.println(n + " ");
        printDecr(n-1);
    }
    public static int fac(int n){
        //time complexity is O(N) AMD SPACE complexity is laso O(n)
        if(n==1){
            return 1;
        }
        else{
            return n * fac(n-1);
        }
    }
    public static int fib(int i){
        //calculate the ith term of fibonacci series --> terms are zero indexed

        // O(n) space compelxity
        // exponential O(2^n) tc -> see from call stack diagram -> har lvl pe 2^n calls are made
        if(i==0){
            return 0;
        }
        if(i==1){
            return 1;
        }
        return fib(i-1) + fib(i-2);
    }
    

    public static void printIncr(int n){
        if(n==1){
            System.err.println(1);
            return;
        }
        printIncr(n-1);
        System.out.println(n + " ");
    }

    public static int sumofn(int n){
        if(n==1){
            return 1;
        }
        else{
            return n + sumofn(n-1);
        }
    }
    public static boolean isSorted(int arr[],int i){
        //i is the starting index to check
        // tc ans sc is O(n)
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr,i+1);
    }

    public static int firstOccurene(int arr[],int key,int i){   
        if(i==arr.length){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        
        return firstOccurene(arr, key,i+1);

        //tc is O(n)
    }

    public static int lastOccurence(int arr[],int key, int i){
        if(i==-1){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }

        return lastOccurence(arr, key, i-1);
    }

    public static int printPower(int base, int power){
        if(power==1){
            return base;
        }
        return base * printPower(base, power-1);
        //tc is O(n) -> can make more optimised
    }

    public static int optimizedPrintPower(int base, int power){
        if(power==0){
            return 1; //the return -> returns value here to the varible where it was called 
        }
        // int halfPowerSqr = optimizedPrintPower(base, power/2) * optimizedPrintPower(base, power/2);

        int halfPower = optimizedPrintPower(base, power/2);
        int halfPowerSqr = halfPower * halfPower;

        if(power%2!=0){
            halfPowerSqr = base * halfPowerSqr;
        }
        return halfPowerSqr;

        // TC is log(n) here
        
    }
    public static void main(String args[]){
        //reccursion -> when a fn calls itself again and agian -> method of solving a computational problem where the solution depends on soltuion to smaller instances of the same problem

        //recursion -> used in trees, graphc and dp

        //base case -> imp -> where recusrion stops

        //2 directions in recursion -> top to down towards base case and then top to up when values are returned (combining solutions )

        //method
        // 1 -> base case
        //2 -> what is to be done
        //3 -> inner call

        //print numbers from n to 2 in decr order using recr only

        int n = 10;
        printDecr(n);

        //Call Stack is used in recursion

          printIncr(10);


        System.out.println(fac(5));
        System.out.println(sumofn(5));

        System.out.println(fib(4));

        //when there are two recursive calls -> then tree shape is formed in the call stack 


        int arr[] = {1,2,3,4,0 };
        System.out.println(isSorted(arr, 0));

        int nrr[] = {1,2,3,4,4,5,6,1};
        System.out.println(firstOccurene(nrr, 4, 0));

        System.out.println(lastOccurence(nrr, 22, nrr.length -1));

        System.out.println(printPower(3, 3));

        System.out.println(optimizedPrintPower(2, 10));
    }
}

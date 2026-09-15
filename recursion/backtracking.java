public class backtracking {
    //backtracking is all about choices

    public static void findPermustations(String str, String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++){
            char curr  = str.charAt(i);
            String NewStr =  str.substring(0,i) + str.substring(i+1);
            findPermustations(NewStr, ans+curr);

            //tc -> O(n * n!) -> total permutation = n! and it takes n time to calculate one
        }
    }
    public static void changeArr(int arr[],int i,int val){
        //base case
        if(i==arr.length){
            printArr(arr);
            return;
        }

        //recursion
        arr[i] = val;
        changeArr(arr, i+1, val+1);
        arr[i] = arr[i] - 2; //backtraking wali line always written after recursive wali ki line ki baad 

        //assign integers when stack  is building and when base case hits -> returns while reducing 2 from each value --> back tracks

        //space compelxiy -> O(n) -> stakc me n levels tak class lgayi hai and tc -> O(2n) equal to O(n)
    }

    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void  findSubsets(String str, String ans, int i){
        //base case
        if(i==str.length()){
            System.out.println(ans);
            return;
        }
        //recursion
        //yes choice of character
        findSubsets(str, ans + str.charAt(i), i+1); 
        //no choice
        findSubsets(str, ans, i+1);

        // tc -> O(n*2^n) (takes n choices to decide a subtring and this is done 2^n times) (means n steps taken to reach a single base case and this is done 2^n times)

        //Returning from recursion naturally undoes that choice (because ans is passed by value — a new string is built each time).

        // sc - > O(n) --> stack call

        // In Java, Strings are immutable.
        // Every time you do ans + str.charAt(i), a new string is created.
        // That means when recursion returns, the old ans is untouched (no need to manually "remove" the last character like you would with a StringBuilder or array).// This makes it perfect for backtracking → you don’t need to undo your choice, recursion + immutability handles it automatically.
    }
    public static void main(String args[]){
        //types of backtrakcing -> DECISION, OPTIMIZATION, ENUMERATION

        //backtracking on arrays
        int arr[] = new int[5];
        changeArr(arr, 0, 1);
        printArr(arr);

        //find subsets of string
        String str = "ab";
        findSubsets(str, "", 0);

        findPermustations("abc", "");

    }
}

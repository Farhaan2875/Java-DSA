package STACK;
import java.util.Stack;

public class morestack {
    public static void maxAreaHistogram(int[] arr){ // we will solve in O(n) time using stack
    //one of the most imp qs os stack
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];
        //next smaller right
        Stack<Integer> s = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = arr.length;
            }else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        //next smaller left
        s = new Stack<>(); //emptying the array
        for(int i=0;i<arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        //current area
        //width = j-i-1 or nsr[i] - nsl[i] -1 //we are using index for width
        for(int i=0;i<arr.length;i++){
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(currArea,maxArea);
        }

        System.out.println("max area in histogram is " + maxArea);

    }
    public static boolean duplicate(String str){//google,amazon etc
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);

            if(ch == ')'){
                int count = 0;
                while(s.peek() != '('){
                    s.pop();
                    count++;
                }
                if(count<1){
                    return true; //duplicate exist
                }else{
                    s.pop();
                }
            }else{
                //opening
                s.push(ch);
            }
        }
        return false;
    }
    public static boolean isValid(String str){ //O(n) tc
        Stack<Character> s = new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                s.push(ch);
            }else{
                if(s.isEmpty()){
                    return false;
                }
                if( (s.peek()=='{' && ch =='}') || (s.peek()=='(' && ch ==')') || (s.peek()=='[' && ch ==']') ){
                    s.pop();
                }else{
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        String str = "{()[]}";
        System.out.println(isValid(str));

        String str1 = "(a+b)";
        String str2 = "((a+b))";
        System.out.println(duplicate(str1));
        System.out.println(duplicate(str2));

        int arr[] = {2,1,5,6,2,3};
        maxAreaHistogram(arr);

    }
}

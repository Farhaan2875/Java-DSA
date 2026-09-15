package STACK;
import java.util.*;

public class stack {
    //for all purposes use collections framework stack unless asked to implement manually
    public static void pushAtBottom(Stack<Integer> s,int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx < str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder("");
        while(!s.isEmpty()){
            char curr = s.pop(); //pop function of stack return the value which is popped from top
            result.append(curr);
        }
        return result.toString();

    }
    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }
    public static int[] nextGreater(int[] arr){//o(n) tc
        //imp qs for 4 other qs also
        Stack<Integer> s = new Stack<>();
        int[] nextG = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]<=arr[i]){ //we are storing index in stack not numbers
                s.pop();
            }
            if(s.isEmpty()){
                nextG[i] = -1;
            }else{
                nextG[i] = arr[s.peek()];
            }

            s.push(i);
        }
        return nextG;
        //permutations of this qs -> nect greater left, next smallest left, next smallest right
    }
    public static int[] calculateSpan(int[] prices) { //similar to next greater dur dr is left
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>(); // store indices

        for (int i = 0; i < n; i++) {
            // Pop smaller or equal prices
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack empty -> no greater to the left
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - stack.peek();
            }

            // Push this element’s index
            stack.push(i);
        }

        return span;
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        //just need to import java collections and we have stack as built in data type
        // while(!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        //     //lifo fashion
        // }

        // QS - Push at the bottom of the stack (AMAZON) -> we will solve in O(n) without any free memory using recursion
        // recursion and stack -> go well together
        pushAtBottom(s,4);
        while(!s.isEmpty()){
            System.out.println(s.pop());

        }

        //reverse a string using a stack
        System.out.println(reverseString("abc"));

        //reverse a stack -> we will do in O(n) time and O(1) space
         

        //next greater qs
        int arr[] = {6,8,0,1,3};
        int[] res = nextGreater(arr);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i] + " ");
        }
        System.out.println();

    }
}

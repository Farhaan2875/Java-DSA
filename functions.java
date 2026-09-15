import java.util.*;
public class functions {

    //functions written inside classes are called methods 
    //execuation always starts with the main function
    // fucntion components --> declaration, definition, and calling
    // function --> reusable part of code(code reusability)

    public static boolean isPalindrome(int b){
        int org = b;
        int temp = 0;
        while(b!=0){
            int l_d = b%10;
            temp = temp*10 + l_d;
            b/=10;
        }
        if(temp==org){
            return true;
        }
        else{
            return false;
        }
    }

    public static void hello(){
        System.out.println("Hello world");
        System.out.println("Hello world");
        System.out.println("Hello world");
        return; //return is imp to use in fucntions
        // in void it does not throw error if we dont write return --> can or not write
    }

    // parametes --> input of functions

    public static void sum(){
        //to input we create an obejct of Scanner class
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int s = a + b;
        System.out.println("sum is: "+ s);
    }

    public static int diff(int num1,int num2){
        //called parameters or formal parmeters or formal arguments --> whicha e defined during function definition
        int diff = num1 - num2;
        return diff;
    }
    
    public static void main(String args[]){
        // hello();
        // sum();
        // Scanner in = new Scanner(System.in);
        // int a = in.nextInt();
        // int b  = in.nextInt();
        // int diff = diff(a,b); //values passeed to thr function during callling are called  arguments ot actual parameters
        // System.out.println(diff); //global and local scope

        System.out.println(isPalindrome(121));

        //functions --> occupy memory is the call stack
        //(a part of memory is organised in the form of stack) --> all the things like the fucntion type its formal arguments, local variables etc are stored in this memory
        // call stack --> which functions have been called
        // the chunk of memory occupied by a fucntion on stack is called the stack frame
  
        //SCOPE --> where we can use the variables throughout the program
        //variable initiated inside a function have local scope

        //Compiler reads line by line from top to bottom so we cant use a variable if we dont intiate it b4
        // System.out.println(s);
        // int s = 10;
        // System.out.println(s);


        //Block Scope --> varibles inside curley braces are local to that block only --> cant be used in other blocks
        // {
        //     int s = 0;
        // }
        // System.out.println(s); --> cant use this 


        //Class SCOPE --> we use access modifiers
    }
}

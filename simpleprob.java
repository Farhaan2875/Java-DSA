import java.util.*;
public class simpleprob {
    public static void main(String args[]){
        // Scanner sc = new Scanner(System.in);
        // int a = sc.nextInt();
        // int b  = sc.nextInt();
        // int c  = a + b;
        // System.out.println(c);

        Scanner input = new Scanner(System.in);
        float x = input.nextFloat();
        float y = input.nextFloat();
        float prod = 3.14f *x * y; //in java if we dont specify the decimal type java by default takes it as double and throws an error --> to solve add f at the end or use type casting
        System.out.println(prod);

        // type conversion automatically happens between compatible data given that destination type > source type meaning that we can assign a long variable to a int but not the inverse the reason is the byte size taken by different data types --> cant put 8 byte data into a 4 byte data
         int a = 10;
         long var = a; //source is int and destination is long
         // if we try to do break this rule then lossy conversion happens --> meaning that some data will be lost during the conversion 
         System.out.println(var); 
        // also called widening(because byte size of storage inceease with new destination variable) or implicit conversion one way order is given below
         // byte -> short -> int -> float -> long -> double

         // type casting is done forcefully by us regardless of data loss considerations
         // we dont need to folloe the order in type casting
        float f = 25.12f;
        int b = (int)f; // type conversion couldve given error here
        System.out.println(b);
        // type casting is called narrowing conversion or explicit conversion


        // type promotion(only happens with expressions) are of two types--> java automatically promotes each byte, short or char operand to int when evaluating an expression, another rule is that if one operand is long, float or doubke the while expression is promoted to long, float or double i.e converts to largest possible data type in case of numerical value data types (double is the largest as it has most precision)

        //char c = 'a' - 'b'; //eror cuz cant convert into to char implicitly
    }
}

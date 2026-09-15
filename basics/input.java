import java.util.*;
public class input {
      public static void main(String args[]){
         Scanner sc = new Scanner(System.in); //cretaed an object of Scanner class to take input
         String var = sc.next(); //one word withiut spaces,ignores everything after space
         System.out.println(var);

        String name = sc.nextLine();//includes spaces  
        System.out.println(name);

        int number = sc.nextInt();
        System.out.print(number);

        float dec  = sc.nextFloat();
        System.out.println(dec);

      
      }
} 
 
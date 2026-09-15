import java.util.*;
public class loops {
    public static void main(String args[]){

        //both while and for loops have three main components --> initialisation, termiantion condition and updation
        // Scanner sc = new Scanner(System.in);
        // int count = sc.nextInt();
        // int n = 1;
        // while(n<=count){
        //     System.out.print(n + " ");
        //     n++; 
        // }

        //sum of first n natural number
        // Scanner input = new Scanner(System.in);
        // int num = input.nextInt();
        // int i = 1;
        // int count = 1;
        // int sum = 0;
        // while(count<=num){
        //     if(i%2==0){
        //         sum += i;
        //         count++;
        //     }
        //     i++;
        // }
        // System.out.println("Sum of first" +" " + num +" even numbers is : " + sum);

        //all problems os while loops can be done with for loop and vice versa
        //syntax for(initialisation;condition;updation){}
        //

        // for(int i = 1; i<=10; i = i + 2){
        //     System.out.println(i);
        // }

        //print square pattern
        // Scanner sc = new Scanner(System.in);
        // int size = sc.nextInt();
        // for(int i = 1;i<=size;i++){
        //       for(int j = 1; j<=size; j++){
        //         System.out.print("*"+" ");
        //       }
        //       System.out.print("\n");
        // }


        //print reverse of a number
        // Scanner sc = new Scanner(System.in);
        // int num = sc.nextInt();
        // int req = 0;
        // while(num!=0){
        //     int last_digit= num%10;
        //     req =  req*10 + last_digit;
        //     num /= 10;
        // }
        // System.out.println("Reverse of entered number is " + req);


        //do while loops is executed al least once --> because first statements are executed and then condition is checked --> you need initiation, condition and updation in this as well (condtion is also called termination condition)

        // int yas = 0;
        // do{
        //     System.out.println("Hi" + yas);
        //     yas++;
        // }while(yas<=10);


        // break statement is used to prematurely exit from a loop
        // continue statement is used to skip the current iteration 

        // for(int i = 1;i<=5;i++){
        //     if(i==3){
        //         continue;
        //     }
        //     System.out.println(i);
        // } 
        
        //prime or not
        // instead of i<num use i< underoot n for more opmtimization --> mathematical logic
        // math class is present is java utility log

        // Scanner sc = new Scanner(System.in);
        // int num = sc.nextInt();
        // int prime = 1;
        // for(int i = 2;i<Math.sqrt(num);i++){
        //     if(num%i==0){
        //         prime  = 0;
        //         break;
        //     }
        // }
        // if(prime==1){
        //     System.out.println("Prime");
        // }
        // else{
        //     System.out.println("Not Prime");
        // }

        //factorial
        // Scanner sc = new Scanner(System.in);
        // int num = sc.nextInt();
        // int fac = 1;
        // for(int i=1;i<=num;i++){
        //     fac = fac * i;
        // }
        // System.out.println(fac);

        //to print table of an entererd number
        // Scanner sc = new Scanner(System.in);
        // int num = sc.nextInt();
        // for(int i = 1;i<=10;i++){
        //     System.out.println(num + " * " + i + " = " + i*num );
        // }
         
        
    }
} 
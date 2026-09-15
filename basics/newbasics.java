import java.util.*;
public class newbasics {
    public static void main(String args[]){
        // unary operators in java are ++ and -- means increment and decrement used to increase or decrease the value by one. They are of two types that are pre and post increment\decrement

        // pre - first inccrement the value before using it
        // post - use the value first and then increment it

        // relational operators(type of binary operators) in java --> bada hai ya chhota hai
        //==,=!,>,<,>=,<=  ---> they give ans in either true or false

        // int A = 10;
        // int B = 5;
        // System.out.println(A>=B);

        // logical operators are of three types --> which are logical and (&&), logical or(||), logical not(!)

        // System.out.println(3>5 && 3>5);
        //And if your IDE or compiler is smart (like VS Code with the right Java extension), it can optimize or warn you about expressions that will always evaluate the same way — in this case, false.This is flagged as “dead code” or “pointless condition” — even though it will run, the warning tells you:"Hey, you're doing something that's always the same — are you sure this is useful?"
        // System.out.println(3>5 || 3>1);
        // System.out.println(!(3>5));

        // assignment operators are =, +=, -=, *=, /=  these are liitle bit faster as compared to using a = a + b --> useful in competitive programming as execution time is faster

        // int age = 29;
        // if(age>=18){
        //     System.out.println("voting rights granted");
        // }
        // if(age>65){
        //     System.out.println("Voting rights revoked");
        // }
        // else{
        //     System.out.println("No vote 4 you");
        // }

        // if we are using single line statement in if else then we can ommit the curly braces

        //q
        // Scanner scan = new Scanner(System.in);
        // int a = scan.nextInt();
        // int b = scan.nextInt();
        // if(a>b){
        //     System.out.println("a is greater");

        // }
        // else if (b>a) {
        //     System.out.println("B is greater");
        // }
        // else{
        //     System.out.println("Both are equal");
        // }

        //q
        // Scanner n = new Scanner(System.in);
        // int num  = n.nextInt();
        // if(num%2==0){ 
        //     System.err.println("Even");
        // }
        // else{
        //     System.out.println("Odd");
        // }


        //if is always checked to bypass this we use else if --> else if is only checked if if if false and even is one else if true then all other else ifs are not checked --> else if saves computational time of compiler

        //qs
        // Scanner sc = new Scanner(System.in);
        // int marks = sc.nextInt();
        // if(marks<33 && marks>=0){
        //     System.out.println("Failing Miserably");
        // }
        // else if(marks>=33 && marks<90){
        //     System.out.println("bro is average");
        // }
        // else if(marks>=90 && marks<=100){
        //     System.out.println("good boy");
        // }
        // else{
        //     System.out.println("Invalid");
        // }

        // if we decalre a variable without initialisation then java assign 0 or 0.00 to it in case of int and flaot and empty char in case of char 
        
        //q
        // Scanner sc = new Scanner(System.in);
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // int c = sc.nextInt();
        // if(a>=b && a>=c){
        //     System.out.println(a + " is greatest");
        // }
        // else if(b>=a && b>=c){
        //     System.out.println(b + " is greatest");
        // }
        // else{
        //     System.out.println(c+ " is greatest");
        // }

        //ternary operator uses 3 operands
        //ternary operator is like if else block in functionality
        // int var = (5>3)?5:3;
        // System.out.println(var);
        // String type = (12%2==0)?"Even":"Odd";
        // System.out.println(type);
        // float marks = 31;
        // System.out.println((marks>=33)?"Pass":"Fail");

        //switch statement is used to bypass multiple else if statement
        // if any case is true then then all other cases after that also execute --> to prevent that we need to use break statement so that execution does not fall onto the next cases
        // int marks = 69;
        // switch(marks){
        //     case 69:
        //     System.out.println("Bravo");  
        //     case 20:
        //     System.out.println("not so bravo");
        //     break;
        //     default :
        //     System.out.println("this is default");
        // }


        //q
        //  Scanner sc = new Scanner(System.in);
        //  System.out.println("Enter operator: ");
        //  char operator = sc.next().charAt(0);
        //  System.out.println("Enter a: ");
        //  int a = sc.nextInt();
        //  System.out.println("Enter b: ");
        //  int b = sc.nextInt();
        //  switch(operator){
        //     case '+': System.out.println(a+b);
        //     case '-': System.out.println(a-b);
        //     case '/': System.out.println(a/b);
        //     case '%': System.out.println(a%b);
        //     case '*': System.out.println(a*b);
        //  }

        //leap year --> 366 days(extra 29th feb)
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        if(year%4==0){
            if(year%100!=0){
                System.out.println("leap year");
            }
            else if(year%400==0 && year%100==0){
                System.out.println("leap year");
            }
        }
        else{
            System.out.println("Not a leap year");
        }

    }
}

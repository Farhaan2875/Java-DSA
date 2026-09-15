import java.util.*;
public class polymorph {
    public static void main(String args[]){
        //POLYMORPHISM -> try to achieve same task using multiple forms like using constructors with different args but same

        //Compile time Polymorphism or Static Polymorphism ->cant be seen by user-> ex Method overloading -> because compiler knew beforehand what function to call

        //Run time Polymorphism -> Method Overriding

        //Method Overlaoding -> Multiple functions with same name but differemt parameters

        //Method overloading -> Change should be there in parameters -> either number or type -> doesnt matter return type of different functions -> still works
        Calculator calc = new Calculator();
        System.out.println(calc.sum(1,2));
        System.out.println(calc.sum((float)1.1,(float)2.1));
        System.out.println(calc.sum(1,2,3));

        //Methos Overriding -> Parent and child both have same function with different fucntion definitions(kam alag) -> same parameters

        Deer d1 = new Deer();
        d1.eat();

        //PACKAGE -> groups of similar types of classes, interfaces adn sub packages
        // TWO TYPES -> BUILT IN AND USER DEFINED

        //Scanner class which is in the package util
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); //sc object ka nextInt function

    } 
}  

class Calculator{
    int sum(int a, int b){
        return a+b;
    }

    float sum(float a, float b){
        return a+b;
    }

    int sum(int a, int b, int c){
        return a+b+c;
    }
}

class Animal{
    void eat(){
        System.out.println("eats anything");
    }
}

class Deer extends Animal{
    void eat(){
        System.out.println("eats grass"); //when function is called then definition of base class is executed
    }
}
 
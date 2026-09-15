
public class moreOOPS {
    public static void main(String[] args) {
        //getters and setters
        //get -> to return the value
        //set -> to set the value

        //this keyword -> refers to current object in Java

        //4 pillars of OOPS -> Encapsulation, Inheritance, Abstraction, Polymorphism -> learn by definition
         
        //ENCAPSULATION -> Encapsulation is defined as the wrapping up of data and methods(functions) under a single unit. It also implements data hiding(by access specifiers)

        //Constructor -> special method which is invoked automaticallly at the time of object creation


        Student s1 = new Student("Farhaan"); //here constructor is used
        System.out.println(s1.name);
        Student s2 = new Student();
        Student s3 = new Student(123);

        //understand copy constructor
        Student f1 = new Student();
        f1.name = "riya";
        f1.roll = 44;
        f1.password = "xyz";

        //imagine if riya forgets her passa nd we have to make her enter a new pass without entering previous details

        Student f2 = new Student(f1); // all properties copied using the copy constructor 
        f2.password = "umm";

    }
}

class Student{
    String name;
    int roll;
    String password;
    //constructor fucntion(has no return type) if we dont create constructor java creates one automatically but you cannot do initialisatin there

    //three types of constructor -> parameterized, non parameterized and copy
    //use accoridng to our need

    //java creates a constructor only if you do not create even a single one
    Student(String name){ //parameterized constructor
        this.name = name; //initialisation with constructor
        System.out.println("constructor is invoked");
    }
    Student (){
        System.out.println("constructor evoked");
    }
    Student(int roll){
        this.roll = roll;
    }

    //constructor overloading --> use specific constructor amongst many cretaed according to the parameters --> THIS IS AN EXAMPLE OF POLYMORPHISM

    //copy constructor -> copy all the properties of one object to another --> ex of f1 and f2
    Student(Student f1){
        this.name = f1.name;
        this.roll = f1.roll;
        //refer to copy constructor file in java folder
    }
}

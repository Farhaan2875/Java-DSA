package oops;

public class CopyConstructor {
    public static void main(String args[]){
        Student f1 = new Student();
        f1.name = "farhaan";
        f1.roll = 44;
        f1.password = "abc";
        f1.marks[0] = 100;
        f1.marks[1] = 90;
        f1.marks[2] = 20;

        Student f2 = new Student(f1);
        f1.marks[1] = 999;
        for(int i=0;i<3;i++){
            System.out.println(f2.marks[i]);
        }

        //the changed marks is printed for f2 even though the change was made in f1 this is because here constructor is not creating new memory while copying but refering to the original address --> so any changes are reflected in the copied object --->THIS IS A PROBLEM --> CALLED SHALLOW COPY

        //IF WE USE DEEP COPY CONSTRUCTOR THEN CHANGES ARE NOT REFLECTED AS NEW MEMORY IS CREATED

        //LAZY COPY --> READ ONLINE

        //DESRUCOTORS --> DELETES OBEJCT FROM MEMORY
        //IN JAVA -> WE DONT create destructor --> built in destructor automatically frees memory from variables/obejcts which are not used in the subsequent lines of code
    }
}

class Student{
    String name;
    int roll;
    String password;
    int marks[];

    Student(){
        marks = new int[3];
    }
    //SHALLOW COPY CONSTRUCTOR
    // Student(Student f1){
    //     marks = new int[3];
    //     this.name = f1.name;
    //     this.roll = f1.roll;
    //     this.marks = f1.marks;

    // }

    //DEEP COPY CONSRUCTOR
    Student(Student f1){
        marks = new int[3];
        this.name = f1.name;
        this.roll = f1.roll;
        for(int i=0;i<marks.length;i++){
            this.marks[i] = f1.marks[i];
        }

    }
}
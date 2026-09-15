public class interfaces {
    public static void main(String args[]){
        //INTERFACES -> pure form of abstarction
        //ITERFACES -> similar to classes but with special proeprties

        //all the fields in intrfaces are public, static and final by default -> means propert fixed for all derived classes like eyes in animal class

        //all methods are public and abstract by default 

        //multiple inheritance -> possible only with interfaces in java


        //static
        Student.school = "lma"; //static is accessed using the name of class instead of objects becuase it is property if class and not object -> static is coomon for all objects

        Student s1 = new Student();
        s1.name = "tony";
        System.out.println(s1.school);

        //memory for static is given only once -> unlike objects -> saves memory in common
        //static is useful --> suppose name of school was to change then we dont have to change it in all the obejcts 

        //we could have declared the school name without static in the parent class -> but function -> but memory is not saved in that case
        

        
    }
}

interface Animal{
    public void walks();
    int eyes = 2; //
    // Animal(){

    // } //constructor not allowed
    // and function definiton not allowed
}

class Horse implements Animal{
    public void walks(){
        System.out.println("wlaks on  4 legs");
    }
}

//implementing multi inheritance -> a child class derives from two base classes
interface Herbivore{
    String teeth = "for grass";
}

class Mustang implements Animal,Herbivore{
    public void walks(){
        System.out.println("mustang is type of horse");
    }
}


//STATIC keyword meaning -> 
class Student{
    String name;
    static String school; 

    public static void changeschool(){
        school = "newschool ";
    }
}
package oops;

public class oops {
    public static void main(String[] args) {
        //objects -> entities in the real world
        //classes -> group of these entitites(with common property)
        //class is the blueprint of an obejct
        //class -> contains attributes(property) + functions(behvaiour)

        Pen p1 = new Pen(); //created obejct of Pen class claeed p1
        // obejects are made in heap memory --> when new keyword is used then memory is creeated in the heap for all attributes of the obejct

        p1.setColor("Blue");
        System.out.println(p1.getColor());

        p1.setTip(5);
        System.out.println(p1.getTip());

        p1.setColor("Yellow");
        System.out.println(p1.getColor()); ///can assign directly using . operator if the varibles in the class were not private

        BankAccount myAcc = new BankAccount();
        myAcc.username = "farhaan";
        // myAcc.password = "1233";// not accessable

        //but accessible through functions as function is within class
        myAcc.setPass("1234");

        // System.out.println(myAcc.password);// cannot access
    }
}
//class name start with capital letter and functions by small letter by convention

//below is an ex of class blueprint(write classes below the public class to avoid error

//object is made in main
class Pen{
    //props
    private String color;
    private int tip;
    
    void setColor(String newColor){
        color = newColor;
    }

    void setTip(int tip){
        this.tip = tip; //can use this here
    }

    String getColor(){
        return this.color;
    }
    int getTip(){
        return this.tip;
    }

}

class Student{
    String name;
    int age;
    float percentage;

    void calcPercentage(int phy, int chem, int math){
        float avg = (phy+chem+math)/3;
    }
}

class BankAccount{
    public String username;
    private String password;

    public void setPass(String pwd){
        password = pwd;
    }

}

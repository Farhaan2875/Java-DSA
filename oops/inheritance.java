public class inheritance {
    public static void main(String args[]){
        //INHERITANCE --> when properties and methods of base/parent class are passed on to a derived/child class

        Fish shark = new Fish();
        shark.eat();

        //TYPES OF INHERITANCE
        //SINGLE LEVEL INHERITANCE -> A child class is derived from a single base class

        //MULTI LEVEL INHERITANCE -> like grandfather and grandson relation
        Dogs doby = new Dogs();
        doby.legs = 4;
        System.out.println(doby.legs);

        //Hierarchial Inheritance
        //when two child  class are derived from a single base class -> ex -> fish, bird and mammal class from animal class

        //hybrid inheritance -> hybrid of hierarchial, single or multi
        //ex Animal base class with mammals, fish and bird base class and further peacock is derived from bird class


        //MULTIPLE INHERITANCE -> when a child class is derived from two base class and exhibits properties and fucntions of both of them --> CANNOT USE DIRECLTY IN JAVA USING CLASSES -> USE INTERFACES FOR THIS

        
    }
}

//base class
class Animal{
    String color;
    void eat(){
        System.out.println("eats");
    }
    void breathe(){
        System.out.println("brethes");
    }
}

//derived clas
class Fish extends Animal{
    int fins;
    void swim(){
        System.out.println("it swims");
    }
}

//ex of multi lvl inheritance
class Mammals extends Animal{
    int legs;
}

class Dogs extends Mammals{
    String breed;
}

//hierarchial
class Bird extends Animal{
    void fly(){
        System.out.println("it flies");
    }
}

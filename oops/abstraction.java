public class abstraction {
    public static void main(String args[]){
        //data hiding -> protecting memebers of class from unintended changes and viewership 
        // abstraction --> hiding implementation details and showing only the useful part to the viewer
        //abstraction in java can be implmented by -> interfaces or abstract classes
        Horse hor = new Horse();
        //whenever object is created of the base class then the contructor of base class in invoked then constructor of derived class in invoked this is called chaining of constructors in java
        hor.walk();
        // Animal a = new Animal();
        // a.walk(); //wont run -> runtime error
        hor.eats();
           
    }
}
abstract class Animal{ 

    //cannot create object/instance of object

    //used abstract keyword bcus user need not know about this --> exits as a concept or blueprint only -> not for use --> means no object

    //blueprint --> ye cheez hr derived class me honi chaiye otherwise error, for ex if we ommit walk function from horse class then erorr

    abstract void walk(); //need not type definiton if using abstarct --> as its for concept only or blueprint
    //if try to use fucntion with abstract keyword -> run time error
    // abstract class can contain abstarct and non abstract fnts
    public void eats(){
        System.out.println("eats");
    }

    Animal(){
        System.out.println("animal constructor invoked");
    }


} 

class Horse extends Animal{
    Horse(){
        System.out.println("horse constructor invoked");
    }
    public void walk(){
        System.out.println("walks on 4 legs");
    }
}

class chick extends Animal{
    public void walk(){
        System.out.println("walks on 2 legs");
    }
}


//abstract keyword -> not pure abstraction -> as some not abstarct fns are allowed in abstract classe
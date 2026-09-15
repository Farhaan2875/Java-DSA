//java --> typed language --> specify variable type
// java is  a portable language as its code can be excuted in any machine as the native code to which the sorce code is converted to is different for different os(cpp is not portable)

//The difference between static and dynamic typing lies in when and how a programming language determines the data types of variables. In static typing, the type of a variable is known at compile-time. This means you either declare the type explicitly or the compiler infers it before the program runs. As a result, type-related errors are caught early, making the code safer and often faster, as the compiler can optimize the program. Languages like Java, C, and C++ use static typing. On the other hand, dynamic typing determines the variable type at runtime, meaning you don’t have to declare the type beforehand. This allows for more flexibility and quicker development, especially for small scripts or prototypes. However, it also increases the risk of runtime errors since type mismatches are only detected when the program is executed. Python, JavaScript, and Ruby are examples of dynamically typed languages. In short, static typing offers more safety and structure, while dynamic typing provides more flexibility and ease of use.

// boiler temmplate code of java --> have to write everytime, name of public class and file should
public class basics{
    public static void main(String args[]){
        System.out.print("Hello World");
        System.out.print("Hello World");
        System.out.print("Hello World\n");
        System.out.print("Hello World\n");
        System.out.print("Hello World\n");
        System.out.println("12");//prints the next statement in new line
        System.out.println("88");
        // java contains varibales and literals
        // literal --> 1 2 3 4 5 'a' 'b' '@' --> lterals are universal their values cannot be changed unlike varibles
        //identifiers --> names of variables, classes, functions like main print println etc

        int a = 10;
        int b = 5;
        System.out.println(a);
        System.out.println(b);
        String name = "Java is here";
        System.out.println(name);
        a = b;
        System.out.println(a);
    }
}
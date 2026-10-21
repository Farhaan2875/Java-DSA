import java.util.*;
public class string {

    public static void printletters(String str){
        for(int i=0;i<str.length();i++){
            System.out.println(str.charAt(i)+" ");
        }
        System.out.println();
    }
    
    public static void main(String args[]){
        char arr[] = {'a','b','c','d'};
        //declaring a string
        String str = "abcd";
        //String is an inbuilt class in java
        //Another way to declare strings
        String str2 = new String("xyz");

        //Strings in java are immutable --> very imp
        
        Scanner sc = new Scanner(System.in);
        String name;
        // name  = sc.next(); //takes single word only
        name = sc.nextLine(); //takes whole string with spaces
        System.out.println(name);

        String fullname  = "Tony Stark";
        System.out.println(fullname.length()); //use parentheses as its a function here not a property like in arrays

        //concatenation
        String firstname = "Mr";
        String lastname = "rikki";
        String fname = firstname + " " + lastname;
        System.out.println(fname + "is the fullname");

        System.out.println(fname.charAt(0));
        // to get the char at index of string


        printletters(fname);
    }  
}

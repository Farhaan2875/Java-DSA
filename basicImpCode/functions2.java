package basicImpCode;
public class functions2 {

    public static void swap(int a, int b){
    int temp = a;
    a = b;
    b = temp;
    }

    public static int mul(int a,int b){
        int m = a * b;
        return m;
    }

    public static void main(String args[])
{
    //call by value and call by references
     
    int a = 5;
    int b = 10;

    // int temp = a;
    // a = b;
    // b = temp;
    // System.out.println("a = " + a);
    // System.out.println("a = " + b);


    swap(a,b); //call by value --> changes in the other function are not reflected in the main function as they create local copies of a and b --> original a nd b are not passed here but a copy or value of them is passed
    
    //functions is java always call by value --> call by ref is available in c,cppp etc

    // System.out.println("a = " + a);
    // System.out.println("b = " + b);
    

    System.err.println(mul(5,10));

}
}

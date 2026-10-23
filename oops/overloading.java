package oops;

public class overloading {

    public static int sum(int a, int b){
        return a + b;
    }
    public static int sum(int a,int b, int c){
        return a+b+c;
    } 

    public static float sum(float a, float b, float c){
        return a+b+c;
    }

    // --> java treats this as duplicate method, compiler should be able to distinguish between methods by their parameters


    public static void main(String args[]){
        
     //In fucntion oveloading the return type of function should not be different as function overloading is only dependent on type and number of parameters
     //as long as compiler can distinguish the functions by parameters i.e parameters are different it does not throw error even if return type of function with same is changed
     //if only return type is changed --> not an example of function overloading --> compilers throws error as it cannot distinguish between the fucntions

    System.err.println(sum(5,3));
    System.out.println(sum(2,2,2));
    System.out.println(sum(2.0f,2,2));
}
}

package basicImpCode;
 
public class prob_func{

    public static void dectobin(int a){
        int bin = 0;
        int pow = 0;
        while(a!=0){
            int rem = a%2;
            bin = bin + rem*(int)Math.pow(10,pow);
            a /=2;
            pow++;
        }
        System.out.println("Binary form of "+a+"is "+bin);
    }
    public static void bintodec(int a){
        int pow = 0;
        int dec = 0;
        while(a!=0){
            int l_d = a%10;
            dec =  dec + l_d*(int)Math.pow(2,pow);
            a /= 10;
            pow += 1;
        }
        System.err.println(dec);
    }


    public static void printPrime(int a, int b){
        //print all prime in a range
        //we use hepler function is this
        for(int i=a;i<=b;i++){
            if(isprime(i)){
                System.out.print(i +" ");
            }
        }
    }

    public static boolean isprime(int a){
        //corner cases --> cases requiring special condition;
        if(a==2){
            return true; //whenever a return statement is reached --> controlled is transferred to the calling function with the value --> further execution stops   
        }
        for(int i=2;i<=Math.sqrt(a);i++){
            // If a number n is divisible by any number greater than √n, it must also be divisible by a number less than √n. as factors repeat
            if(a%i==0){
                return false;
            }
        }
        return true;
    }

     public static int fact(int a){
        if(a==1){
            return 1;
        }
        else{
            return a * fact(a-1);
        }

        // int f = 1;
        // for(int i = 1;i<=a;i++){
        //     f = f * i;
        // }
        // return f;
     }

    //binomial coefficient --> nCr = n! / (r! * (n-r)!)
    //we cann call one function from another --> helper function
    
    public static int bino(int n,int r){
        int req = fact(n)/(fact(r) * fact(n-r));
        return req;
    }
    
    public static void main(String args[]){
        int n = fact(4);
        System.out.println(n);

        //bino function call  
        System.out.println(bino(5,2));
        
        System.out.println(isprime(20));


        //print prime in range
        // printPrime(2, 20);


        //bin to dec
        bintodec(111);

        //dec to bin
        dectobin(7);
    }
    
    //methods --> two types --> user deffined like factorial calculation etc and inbuilt methods like pow, sqrt, max in math class or Scanner class methods like nextInt()

    //Function Overloading --> multiple function with the smae name but different parameters ex multiply(int a, int b) and multiply(float a,floatb) or multiply(int a, int b, int c) all in same class

    //function overlaoding --> by type of parameters or number of parameter

     
    
}
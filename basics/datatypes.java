public class datatypes {
    public static void main(String[] args) {
        //data types --> primitive like byte,short, int and non primitve like array, string
        byte b = 8;
        System.out.println(b);

        int a = 12;
        System.out.println(a);

        short c = 10;
        System.out.println(c);
        
        long d = 1000;
        System.out.println(d);

        char e = 'a';
        System.out.println(e);

        boolean val = false;
        System.out.println(val);

        float price = (float)10.5;
        System.out.println(price);
//The error "cannot convert from double to float" in Java arises because Java treats floating-point literals (e.g., 3.14) as double by default, which has higher precision (64-bit) compared to float (32-bit). When you try to assign a double value to a float variable without explicit conversion, Java prevents it to avoid potential data loss.
// Here's how to resolve this error:
// 1. Use the f suffix:
// Append the f suffix to the floating-point literal to explicitly denote it as a float.
// float myFloat = 3.14f;
// 2. Explicit casting:
// Use a cast (float) to convert a double value to a float


    }
}

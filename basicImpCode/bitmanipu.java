package basicImpCode;
public class bitmanipu {

    public static void oddeven(int n){
        int bitmask = 1;

        //aesa bitmask chaiye to lsb ke alawa sari bits ko zero krde and that is 1 (1<<0)
        if((n & bitmask)==0){
            System.out.println("even");
        }
        else if((n & bitmask)==1){
            System.out.println("odd");
        }
        else{
            System.out.println("invalid input");
        }
    }

    public static int getbit(int n, int i){
        int bitmask = 1<<i;
        if((n & bitmask) ==0){
            return 0;
        }
        else if((n & bitmask)==1){
            return 1;
        }

        else{
            System.out.println("invalid");
            return 0;
        }
    }
    public static int setbit(int n,int i){
        int bitmask = 1<<i;
        //make the bit at ith position one and then return thr new number
        return n | bitmask;
    }

    public static int clearbit(int n, int i){
        int bitmask = ~(1<<i);
        return n & bitmask;

    }
    public static int updatebit(int n, int i, int newbit){
        // if(newbit==0){
        //     return clearbit(n, newbit);
        // }
        // else{
        //     return setbit(n, newbit);
        // }

        //another method

        n = clearbit(n,i);
        int bitmask = newbit<<i;
        return n | bitmask;
    }
    public static int clearIbits(int n, int i){
        int bitmask = ((~0)<<i);
        // -1 or negation of zero is represented as 1111111111 
        return n & bitmask;
    }

    public static int clearBitRange(int n, int i, int j){
        //refer day13 lec16
        int a = ((~0)<<(j+1));
        int b = (1<<i) - i;
        int bitmask = a | b;
        return n & bitmask;
    }

    public static boolean ispowerof2(int n){
        return (n&(n-1))==0;
    }
    public static int countsetbits(int n){
        //imp property
        //integer n can be represented by log(n) + 1 bits (base 2) so the time complexity of ts is logn
        int count = 0;
        while(n>0){
            if((n&1) !=0){
                count++;
            }
            n = n>>1;
        }
        return count;
    }

    public static int fastexpo(int a, int n){
        // we need to calculate a raised to the power n
        int ans = 1;
        while(n>0){
            if((n&1) != 0){
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(5&6);
        //LSB IS the rightmost bit and MSB is the leftmost bit
        //MSB tells the symbol of the digit if its
        // zero then number is positive
        // and if its one then the number is negative

        System.out.println(~5);

        //check even or odd
        // for odd LSB IS 1
        //for even LSB IS 0

        oddeven(14);
        oddeven(3);

        //GET ith Bit -> means ith position ke alawa hr jgeh zero chaiye --> use (1<<i)
        //position starts from left hand side with zero index

       System.out.println( getbit(3, 0));

       //SET ith bit -> means to make the ith bit 1
       // use or operator with the number and (1<<i)

        System.out.println(setbit(2, 0));

        //Clear ith bit --> make the bit at ith position zero -> use and operator with bitmask ~(1<<i)

        System.out.println(clearbit(7, 1));


        //update ith bit --> update bit with either zero or one

        System.out.println(updatebit(7, 2, 0));

        //clear last i bits
        System.out.println(clearIbits(7, 03));

        //clear range of bits
        System.out.println(clearBitRange(10, 02, 04));

        //check if number is power of 2 or not
        //property --> number which is a power of 2 and the and operator of the number one less than it is 0
        System.out.println(ispowerof2(15));

        //count set bits in a number --> google and amazon
        
        System.out.println(countsetbits(16));


        //fast exponentiation --> imp for compettive
        //takes logn time instead of n
        System.err.println(fastexpo(5, 03));
    }
}

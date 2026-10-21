public class question_self {

    public static void main(String args[]){
        int x = 1534236469;
        int temp = Math.abs(x);
        double rev = 0;
        while(temp!=0){
            int d = temp%10;
            rev = rev * 10 + d;
            temp/=10;
        }
        if(x<0 && x<=Integer.MAX_VALUE && x>=Integer.MIN_VALUE && rev<=Integer.MAX_VALUE &&         rev>=Integer.MIN_VALUE){
            System.out.println(-(int)rev);
        }
        else if(x>=0 && x<=Integer.MAX_VALUE && x>=Integer.MIN_VALUE && rev<=Integer.MAX_VALUE &&   rev>=Integer.MIN_VALUE){
        System.out.println((int)rev);
        }
        else{
            System.out.println(0);
        }   
        int arr[] = {1,2,3,4};
            int total = 4;
            int pos1 = total/2 - 1;
            System.out.println("pos1" + pos1);
            int pos2 = total/2;
            System.out.println("pos2" + pos2);
            int term1 = arr[pos1];
            System.out.println("t1" + term1);
            int term2 = arr[pos2];
            System.out.println("t2" + term2);
            double med = (term1 + term2)/2;
            System.out.println(med);
    }
}

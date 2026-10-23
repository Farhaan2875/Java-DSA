package basicImpCode;
public class stringQS {

    public static boolean palindrome(String str){
        int n = str.length();
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(n-1-i)){
                return false;
            }
        }
        return true;
    }
    public static float shortestroute(String path){
        int x = 0,y = 0;
        // the number of char in the string passed is the time complexity
        for(int i=0;i<path.length();i++){
            char dir = path.charAt(i);
            if(dir=='S'){
                y--;
            }
            else if(dir=='N'){
                y++;
            }
            else if(dir=='W'){
                x--;
            }
            else{
                x++;
            }
        }
        return (float)Math.sqrt(x*x + y*y);
    }
    public static void main(String args[]){
        String str = "noons";
        System.out.println(palindrome(str));

        System.out.println(shortestroute("NSWSNSEW"));
    }
}

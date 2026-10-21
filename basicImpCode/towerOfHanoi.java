package basicImpCode;
import java.util.*;

public class towerOfHanoi{
    public static void solve(int n, String src, String helper, String dest) {
        if(n == 1) {
            System.out.println("transfer disk " + n + " from " + src + " to " + dest);
            return;
        }
        solve(n - 1, src, dest, helper);
        System.out.println("transfer disk " + n + " from " + src + " to " + dest);
        solve(n-1, helper, src, dest);
        return;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of disks: ");
        int numberOfDiscs = sc.nextInt();
        sc.close();

        solve(numberOfDiscs, "A", "B", "C");
        return;
    }
    // tc = 2^n
    // minimum number of moves =  2^n - 1}
}

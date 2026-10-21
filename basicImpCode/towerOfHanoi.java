import java.util.*;
package basicImpCode;

public class towerOfHanoi{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of disks: ");
        int numberOfDiscs = sc.nextInt();
        sc.close();
        System.out.println(numberOfDiscs);
    }
}

package array;
import java.util.*;
public class arrays{

    public static void update(int mark[]){
        for(int i=0;i<mark.length;i++){
            mark[i] = mark[i] + 1;
        }
    }
    public static void main(String args[]){
        // //creating an array ways
        // int marks[] = new int[50];
        // //means 50 integers store not 50 byte
        // // if we dont initiate values then null values like zero, empty string, empty char are stored in an array

        // int numbers[] = {1,2,3};

        // String fruits[] = {"apple","mango","orange"};

        //taking input in an array
        // int marks[] = new int[100];
        // Scanner sc = new Scanner(System.in);
        // marks[0] = sc.nextInt(); //marks[indx] are tretaed as variables in input and output
        // marks[1] = sc.nextInt();
        // marks[2] = sc.nextInt();

        // System.out.println("physics: "+marks[0]);
        // System.out.println("maths: "+marks[1]);
        // System.out.println("english: "+marks[2]);

        // marks[2] = 100; //can change values in an arrray
        // System.out.println("updated eng marks: "+ marks[2]);


        // int perc = (marks[0]+marks[1]+marks[2])/3;
        // System.out.println("Percentage: "+perc);


        //length of an array
        // System.out.println("length of array is : "+marks.length); //dot length methof is used
        // length is the size the array when intiated
        

        //we always pass arrays by reference to another fucntion --> changes are made in the original memory location
        int m[] = {97,98,99};
        update(m);
        for(int i=0;i<m.length;i++){
            System.out.println(m[i] + " ");
        }
        
    }
}
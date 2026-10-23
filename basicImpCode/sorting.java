package basicImpCode;
// import java.util.*;//imports all classes of util
import java.util.Arrays;
import java.util.Collections;
// import java.util.Arrays; //only arrays methods
public class sorting {
    //in tests and competitions USE IN BUILT SORTING --> DONT WRITE CODE FOR SORTING AS TIME IS VERY LESS

    public static void countingSort(int arr[]){ //very good algo if laregst value in array is small
        //finding the range
        int largest = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            largest = Math.max(largest,arr[i]);
        }
        int count[] = new int[largest+1];
        // +1 cuz we include zero also in non negative integers
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++; //we take the number as the index and then store the frequency
        }
        //sorting
        int j=0;
        for(int i=0;i<count.length;i++){
            while(count[i]>0){
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }
    
    public static void selectionSORT(int arr[]){
        for(int i = 0;i<arr.length-1;i++){
            int minPos = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[minPos]){
                    minPos = j;
                }
            }
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
        //printing
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        
    }
    
    public static void bubblesort(int arr[]){
        for(int turn=0;turn<arr.length - 1;turn++){
            for(int j = 0;j<arr.length-1-turn;j++){
                if(arr[j]<arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        //t.c of bubble sort is o(n^2) --> but we can write an optimised bubble sort with O(n) TC in the best case
    }

    public static void optimised_bs(int arr[]){
        for(int turn = 0;turn<arr.length-1;turn++){
            int swap = 0;
            for(int j=0;j<arr.length-1-turn;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap++;                
                }
            }
            if(swap==0){
                break;
            }
        }
        //printing
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void printArr(Integer[] arr){
        System.out.println("array is: ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String args[]){
        int arr[] = {5,4,1,3,2};
        // optimised_bs(arr);

        //selection sort
        selectionSORT(arr);

        //sorting using built in --> takes O(n logn) time
        Arrays.sort(arr);
        Arrays.sort(arr,0,3);
        //if no idx mentioned --> sorts entire arrat

        // Arrays.sort(arr,si,ei);
        // starting index is inclusive while ending index is not

        // if we want to reverse order to decsending
        // then import Collections class
        // use Arrays.sort(arr,si,ei,reverseorder())
        // b4 doing it we have to use Integer type(object type varibale) in arrays instead of int(primitive type variable)
        // this ways arrays become objects of Integer calss and revrseorder fucntions only works on objects
        Integer height[] = {1,2,3,56,0};
        Arrays.sort(height,0,4,Collections.reverseOrder());
        printArr(height); //created a method to print it


        //counting sort
        countingSort(arr);
        // printArr(arr);
    }
}

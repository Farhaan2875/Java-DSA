package basicImpCode;
public class DivideConquer {
//CALL BY REFERENCE(IN FUCNTIONS) IS IMPLEMETED IN JAVA INDIRECTLT IN CASE OF ARRAYS AND OBJECTS
public static void mergeSort(int arr[], int si, int ei){
    if(si>= ei){
        return;
    }
    //kaam
    int mid = si + (ei - si)/2; 
    mergeSort(arr, si, mid); //left part
    mergeSort(arr, mid + 1, ei); //right part

    merge(arr,si,mid,ei);
    //tc -> o(nlogn)
    //sc -> o(n) -> kitni extra space use kri
    //can t use this sorting technique where extra space is not available

    //In merge sort -> We go Depth First
}

public static void merge(int arr[], int si, int mid, int ei){   //left(0,3) -> 4 elemets and right(4,6) = 3elements s0 totol = 6-1 +1
    int temp[] = new int[ei-si+1];
    int i = si; //iterator for left
    int j=mid+1;//iterator for right
    int k=0; //iterator for temp arr

    while(i<=mid && j<=ei){
        if(arr[i] < arr[j]){
            temp[k] = arr[i];
            i++;
            k++;
        }
        else{
            temp[k] = arr[j];
            j++;
            k++;
        }
    }
    //left part
    while(i<=mid){
        temp[k++] = arr[i++];

    }

    //right
    while(j<=ei){
        temp[k++] = arr[j++];
    }

    for(k=0,i=si;k<temp.length;k++,i++){
        arr[i] = temp[k];
    }
}

    public static void quickSort(int arr[], int si, int ei){

        //tc -> O(nlogn)
        //worst ->O(n^2) -> worst case occurs when pivot is always the largest or smallest element --> INTERVEW ASKED QS
        //spce ->O(1)

        //Approch -> pivot and prtititon
        if(si>=ei){
            return;

        }
        //pivot -> last ele
        int pidx = partition(arr,si,ei);
        quickSort(arr, si, pidx-1);  //left part
        quickSort(arr, pidx+1, ei); //right part
    }

    public static int partition(int arr[], int si, int ei){
        int pivot = arr[ei];
        int i = si-1; //makes place for elements smaller than pivots
        for(int j=si;j<ei;j++){
            if(arr[j]<=pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        //getting pivot to the right place
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;

    }


public static void printarr(int arr[]){
    for(int i=0;i<arr.length;i++){
        System.out.print(arr[i] + " ");
    }
    System.out.println();
}

public static void main(String[] args) {
    //divide and conquer -> stratergy ->divide big problems into small parts

    int arr[] = {11,2,35,0,12,32};
    mergeSort(arr, 0, arr.length-1);
    printarr(arr);

    quickSort(arr, 0, arr.length-1);
    printarr(arr);

}

}
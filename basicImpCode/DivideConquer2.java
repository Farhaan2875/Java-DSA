package basicImpCode;
public class DivideConquer2 {
    //seaarch in rotated sorted array --> VERY IMP FOR INTERVIEWS -> wont use linear search -> O(n) tc but we will solve in O(nlogn) tc (more optimised) --> WILL USE MODIFIED BINARY SEARCH
    public static int search(int arr[], int tar, int si, int ei){
        //kaam
        int mid = si +(ei-si)/2;

        if(si>ei){
            return -1;//not found
        }
        //case 
        if(arr[mid]==tar){
            return mid;
        }

        //mid on l1
        if(arr[si]<=arr[mid]){
            //case a : left
            if(arr[si]<=tar && tar<=arr[mid]){
                return search(arr, tar, si,mid-1);
            }else{
                //case b:: right
                return search(arr, tar, mid+1, ei);
            }
        }

        //mid on l2
        else{
            //case c:: right
            if(arr[mid]<= tar && tar<=arr[ei]){
                return search(arr, tar, mid+1, ei);
            }else{
                return search(arr, tar, si, mid-1);
            }
        }
    }

    public static void main(String[] args) {
        //search in rotated sorted array
    int arr[] = {4,5,6,7,0,1,2};
    int tar = 0;

    int taridx = search(arr, tar, 0,arr.length-1);
    System.out.println(taridx);
    
    }
}

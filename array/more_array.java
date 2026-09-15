package array;
public class more_array {

    public static int linearSearch(int marks[],int key){
        for(int i=0;i<marks.length;i++){
            if(marks[i]==key){
                return i;
            }
        }
        return -1;
    }

    public static int largest(int numbers[]){
        int com = Integer.MIN_VALUE;
        for(int i = 0;i<numbers.length;i++){
            if(numbers[i]>=com){
                com = numbers[i];
            }
        }
        return com;
    }

    public static int binarySearch(int nums[],int key){
        // binary search works only on sorted array
        int start = 0,end = nums.length - 1;
        while(start<=end){
            int mid = (start + end) / 2;
            //comaprisons
            if(nums[mid]==key){
                return mid;
            }
            else if(nums[mid]<key){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1; //if not found
    }

    public static void reverse(int num[]){
        int first = 0, last = num.length - 1;
         while(first<last){ //no "=" because no use of swapping the same digit with the same place
            int temp = num[last];
            num[last] = num[first];
            num[first] = temp;

            first++;
            last--;
        }
    }

    public static void pairsPrint(int num[]){
        int tp = 0;
        for(int i = 0;i<num.length;i++){
            int curr = num[i];
            for(int j=i+1;j<num.length;j++){
                //for last element condition becomes false
                System.out.print("("+curr+","+num[j] + ")");
                tp++;
            }
            System.out.println();
        }
        System.out.println("total pairs are : "+tp);
    }

    public static void printSubarrays(int nums[]){
        for(int i=0;i<nums.length;i++){
            int start = i;
            for(int j=i;j<nums.length;j++){
                int end = j;
                // int sum = 0;
                for(int k=start;k<=end;k++){
                    // sum+=nums[k];
                    System.out.print(nums[k]+" ");
                }
                // System.out.print("sum of digits of this subarray is : "+sum);
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        int nums[] = {1,22,75,100,98,0,35};

        //linear search
        int key = 100;
        int idx = linearSearch(nums, key);
        if(idx==-1){
            System.out.println("not found");
        }
        else{
            System.out.println("FOUND");
        }

        //finding largest numbers
        System.out.println("largest number is " + largest(nums));
        //can find smallest numbers sam eway using Integer.MAX_VALUE


        //binary search
        System.out.println("number found at " 
        + binarySearch(nums, key));


        //reverse an array
        reverse(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i] + " ");
        }

        //all possible pairs --> 2,4 and 4,2 are same
        pairsPrint(nums);

        //printing sub arrays --> like subset but numbers should be continuous i.e occur one after another in an array

        //print subarrays
        System.out.println("Subarrays are");
        printSubarrays(nums);
    }
}

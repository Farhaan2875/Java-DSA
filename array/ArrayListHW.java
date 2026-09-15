package array;

public class ArrayListHW {
    public static boolean helper2(int[] arr){
        for(int j=0;j<arr.length-1;j++){
            if((arr[j]>=arr[j+1])==false){
                return false;
            }
        }
        return true;
    }
    public static boolean helper1(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            if((arr[i]<=arr[i+1])==false){
                return false;
            }
        }
        return true;
    }

    public boolean isMonotonic(int[] nums) { //MONOTIC ARRAY OR NOT
        return helper1(nums) || helper2(nums);
        
    }
    public static void main(String[] args) {
        
    }
}

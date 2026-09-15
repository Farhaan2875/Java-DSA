package Hashing;
import java.util.*;
public class qs {
    public static void subarraysWithSumK(int arr[], int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        //(sum, count)

        map.put(0,1);
        int sum = 0;
        int ans = 0;

        for(int j=0;j<arr.length;j++){
            sum += arr[j];
            if(map.containsKey(sum-k)){
                ans += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        System.out.println("Number of subarays with sum equal to k : " + ans);
    }
    public static void maxSubarrayZeroSum(int arr[]){
        //O(n) time complexity
        HashMap<Integer, Integer> map = new HashMap<>();
        //(sum, idx) pair

        int sum = 0;
        int len = 0;

        for(int j=0;j<arr.length;j++){
            sum += arr[j];
            if(map.containsKey(sum)){
                len = Math.max(len, j-map.get(sum));
            }else{
                map.put(sum,j);
            }
        }

        System.out.println("largest subarray with sum zero is of length : " + len);
    }



    public static void itinerary(HashMap<String, String> hm){ //O(n) tc
        HashMap<String, String> revMap = new HashMap<>();
        String start = "null";;
        for(String key: hm.keySet()){
            revMap.put(hm.get(key), key);
        }
        for(String key : hm.keySet()){
            if(!revMap.containsKey(key)){ //finding the starting point
                start = key;
            }
        }
        System.out.print(start);
        for(String key : hm.keySet()){
            System.out.print(" -> " + hm.get(start));
            start = hm.get(start);
        }
    }
    public static int unique(int arr[]){ //O(n) tc
        HashSet<Integer> set = new HashSet<>();

        for(int i=0 ;i<arr.length;i++){
            set.add(arr[i]);
        }

        return set.size();
    }

    public static void main(String[] args) {
        // count the number of unique elements in an array -> brute force -> o(n^2) tc
        

        int arr[] = {4,3,2,5,6,7,3,4,2,1};
        System.out.println(unique(arr));

        ///union and intersection two arrays
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};

        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }

        for(int i=0;i<arr2.length;i++){
            set.add(arr2[i]);
        }
        System.out.println("Union is : " + set);

        //intersection
        int count = 0;
        HashSet<Integer> n = new HashSet<>();
        List<Integer> li = new ArrayList<>();
        for(int i=0; i<arr1.length;i++){
            n.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            if(n.contains(arr2[i])){
                count++;
                li.add(arr2[i]);
                n.remove(arr2[i]);
            }
        }
        System.out.println("intersection is : " + li);


        //print itinerary
        HashMap<String, String> hm = new HashMap<>();
        hm.put("Chennai","Bengaluru");
        hm.put("Mumbai", "Delhi");
        hm.put("Goa", "Chennai");
        hm.put("Delhi","Goa");

        itinerary(hm);

        //largest subarray with zero sum
        //ex -> arr = {2,2,-8,1,7,10,23}
        //ans = -2,2,-8,1,7
        int array[] = {15,-2,2,-8,1,7,10,23};
        maxSubarrayZeroSum(array);

        //number of subarrays with sum equal to K
        int ray[] = {10,2,-2,-20,10};
        int k = -10;
        subarraysWithSumK(ray, k);

    }
}

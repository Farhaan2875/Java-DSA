package Hashing;
import java.util.HashMap;
import java.util.Set;
public class HMqs {
    
    public static boolean isAnagram(String s, String t){
        //O(n) tc
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            if(map.get(ch) != null){
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch, map.get(ch)-1);
                }
            }else{
                return false;
            }
        }
        return map.isEmpty();
    }
    public static void main(String[] args) {
        //Majority element qs
        int arr[] = {1,3,2,5,1,3,1,5,1};
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            // if(hm.containsKey(arr[i])){
            //     hm.put(arr[i], hm.get(arr[i])+1);
            // }else{
            //     hm.put(arr[i], 1);
            // }

            //short form of this code
            hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
            //if values exist then .get returns value else return null -> but if key does not exist this function returns the default value which we have used as its parameter else it returns the value found at that index
        }

        // Set<Integer> ks = hm.keySet(); --> can skip this line if we write it inside for loop
        for(Integer key : hm.keySet()){
            if(hm.get(key) > arr.length/3){
                System.out.println(key);
            }
        } 

        //VALID ANAGRAM -> two words which use the same characters
        //we use a hashmap to record the frequeency of each element of first word and while traversing the second word we minus the frequency when char are encountered and delete the if frequency become zero at end if map is empty -> true else false (and if you get a new char in second word -> return false) 

        String s = "race";
        String t = "care";

        System.out.println(isAnagram(s, t));

    }
}

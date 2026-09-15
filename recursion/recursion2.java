public class recursion2 {

    public static int tilingProblem(int n){//amazon

        // n is the length -> breadth is alwasy fixed -> 2
        // but thix qs can come in amny form -> solution is general case
        //kaam
        if(n==0 || n==1){
            return 1;
        }
        //vertical choice
        int fnm1 = tilingProblem(n-1);

        //horizontal choice
        int fnm2 = tilingProblem(n-2);

        int totolways = fnm2 + fnm1;
        return totolways;
    }


    public static void removeDuplicate(String str, int idx, StringBuilder newstr, boolean map[ ]){
        // a -a = 0, b - a = 1, c - 1 = 2, ....z-a = 25 --> use this trick for indeixng 
        if(idx==str.length()){
            System.out.println(newstr);
            return;
        }
        char currchar = str.charAt(idx);
        if(map[currchar - 'a']==true){
            //duplicate
            removeDuplicate(str, idx+1, newstr, map);
        }
        else{
            map[currchar - 'a'] = true;
            removeDuplicate(str, idx+1, newstr.append((currchar)), map);
        }
    }

    //friend pairing problem -> goldman sachs
    public static int friendpairing(int n){
        if(n==1 || n==2){
            return n;
        }
        // //choice single
        // int fnm1 = friendpairing(n-1);
        // int fnm2 = friendpairing(n-2);
        // int pairWays = (n-1) * fnm2;

        // //totalways
        // int totalways = fnm1 + pairWays;
        // return totalways;
  
        return friendpairing(n-1) + (n-1)*friendpairing(n-2);
    }

    public static void printBinaryStrings(int n, int lastPlace, String str){

        //base case
        if(n==0){
            System.out.println(str);
            return;
        }
        //kaam
        if(lastPlace==0){
           printBinaryStrings(n-1, 0, str+"0");
           printBinaryStrings(n-1, 1, str+"1");
        }else{
            printBinaryStrings(n-1, 0, str+"0");
        }

    }


    public static void main(String args[]){
        String str = "aabbbcbcbcjdsnccjzz";
        removeDuplicate(str, 0, new StringBuilder("") , new boolean[26]);

        printBinaryStrings(3, 0,"");
        
    }
}

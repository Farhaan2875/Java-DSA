package greedy;
import java.util.*;

public class greedyalgo {
    
    public static void main(String[] args) {
        //activity selection with tc O(n)
        //activities already sorted on the basis of end time
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9,};

        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>(); //to store to indices of activities done

        //taking first element as default
        maxAct = 1;
        ans.add(0); //first activity i.e zero index

        int lastend = end[0]; //storing the ending time of the last aactivity performed
        for(int i=1;i<end.length;i++){
            if(start[i]>=lastend){
                maxAct++;
                ans.add(i);
                lastend = end[i];
            }
        }
        System.out.println("maximum activites == " +  maxAct);
        System.out.println(ans);

        //if sorting not done then process to do sorting -> normally we see it in questions
        int activities[][] = new int[start.length][3];
        for(int i=0;i<start.length;i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        //first column stores the index, second the start time and third the end time -> created a table

        //sorting a 2d array
        // here the second parameter is called a lambda fucntion
        //here we said the we want to do the sorting on the basis of second column which stores our end times
        //this sorts the whole rows not just a simple colmunn
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
        //now editing our code for this array
        maxAct = 1;
        ans.add(activities[0][0]); //first activity i.e zero index
        lastend = activities[0][2]; //storing the ending time of the last aactivity performed
        for(int i=1;i<end.length;i++){
            if(activities[i][1]>=lastend){
                maxAct++;
                ans.add(activities[i][0]);
                lastend = activities[i][2];
            }
        }//this qs was done in O(n logn) tc as logn time was taken for sorting
        //read comparator pdf -> day 27
        System.out.println("MAX ACT: "+maxAct);
        System.out.println(ans);

    }
}

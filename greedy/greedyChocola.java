package greedy;
import java.util.*;

public class greedyChocola {
    //CHOCOLA PROBLEM -> same logic is used in many oother problems
    public static void main(String[] args) {
        int n = 4, m = 6;
        Integer costver[] = {2,1,3,1,4};
        Integer costhor[] = {4,1,2};

        Arrays.sort(costver, Collections.reverseOrder());
        Arrays.sort(costhor, Collections.reverseOrder());
        int h = 0,  v = 0; //keeps track of which cut we are performing

        int hp = 1, vp = 1; //total horizontal and vertical pieces
        //at start the slab is one whole horizontal or vertical piece

        int cost = 0;//total cost

        while(h<costhor.length && v<costver.length){
            if(costver[v]<=costhor[h]){ //horizontal cut
                cost += costhor[h] * vp;
                hp++;
                h++;
            }else{
                //vertical cut
                cost += costver[v] * hp;
                vp++;
                v++;
            }
        }
        ///dealing with any remaining cuts
        while(h<costhor.length){
            cost += costhor[h] * vp;
            hp++;
            h++;
        }
        while(v<costver.length){
            cost += costver[v] * hp;
            vp++;
            v++;
        }

        System.out.println("min cost to cut into smallest square == " + cost);

        //if you dont get the hp and vp logic just dry run --> each cut divides the subject into two equals -> means one more produced

        //board gets converted into m*n pieces
    }
}
 
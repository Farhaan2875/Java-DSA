package priorityQ;
import java.util.PriorityQueue;

public class pqQS {
    static class Point implements Comparable<Point>{
        int x;
        int y;
        int distSq;
        int idx;

        public Point(int x, int y, int distSq, int idx){
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2){
            return this.distSq - p2.distSq; //asc order sorting
        }
    }
    static class Row implements Comparable<Row>{
        int soldiers;
        int idx;

        public Row(int soldiers, int idx){
            this.soldiers = soldiers;
            this.idx = idx;
        }
        @Override
        public int compareTo(Row r2){ //imp comparator logic
            if(this.soldiers == r2.soldiers){ //saying is number of soldiers is same then compare using index
                return this.idx - r2.idx;
            }else{
                return this.soldiers - r2.soldiers;
            }
        }
    }
    public static void main(String[] args) {

        ///NEAREST K CARS
        int pts[][] = {{3,3},{5,-1},{-2,4}};
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();

        for(int i=0;i<pts.length;i++){
            int distSq = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
        }

        for(int i=0;i<k;i++){
            System.out.print( "C" + pq.remove().idx + " ");
        }

        //connect n ropes
        int ropes[] = {2,3,3,4,6};

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0;i<ropes.length;i++){
            q.add(ropes[i]);
        }
        int cost = 0;
        while(q.size() > 1){
                int min = q.remove();
                int min2 = q.remove();
                cost += min + min2;
                q.add(min + min2);
        }
        System.out.println("cost of connecting n ropes = " + cost);


        //WEAKEST ROW QS
        int army[][] = {{1,0,0,0}, {1,1,1,1}, {1,0,0,0}, {1,0,0,0}};
        int n = 2;

        PriorityQueue<Row> sol = new PriorityQueue<>();
        for(int i=0;i<army.length;i++){
            int count = 0;
            for(int j=0; j<army[0].length;j++){
                count += army[i][j] == 1 ? 1 : 0;
            }

            sol.add(new Row(count, i));
        }

        for(int i=0;i<k;i++){
            System.out.print("R" + sol.remove().idx + " ");
        }


    }
    
}

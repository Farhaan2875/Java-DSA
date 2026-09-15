package graphs;
import java.util.*;
public class Graph{
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean visited[]){
        System.out.println(curr + " ");
        visited[curr] = true;

        for(int i=0;i<graph[curr].size();i++){ //checking and calling dfs on neighbours
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                dfs(graph,e.dest,visited);
            }
        }

    } // tc - > O(V+E)
    
    public static void bfs(ArrayList<Edge>[] graph){
        //tc - > O(V + E) -> fro adjacency list (our case)
        // tc -> o(v^2) -> if matrix was used
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length]; //by default bool array contains false in java

        //we take source as zero -> you can take any vertex and add it first in the queue

        q.add(0);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!vis[curr]){
                System.out.println(curr);
                vis[curr] = true;
                //finding and adding the neighbours
                for(int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }


    }
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean visited[]){ //tc -> O(V + E)
        if(src == dest){
            return true;
        }
        visited[src] = true;
        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            //e.dest --> neighbor
            if(!visited[e.dest] && hasPath(graph, e.dest, dest, visited)){
                return true;
            }
        }
        return false; //if not path exists
    }
    public static void main(String[] args) {
        //see the graph is notebook (create graph)
        int V = 5; //total number of vertices
        //crate an array with the size of the number of vertices

        //array of array list
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[V]; 
        // ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[V];
        // declared an array of arraylist with null values -> we need to initilaize it
        //compare with int[] arr = new int[size]

        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<>(); //initializes
        }


        //each vertex's data is stored at the index of the same numeric value as the data

        //we have created an array of arraylist<edge> and at each index of the array the arraylist can store multiple edges -> we are able to store multiple edges the same index


        //0 vertex
        graph[0].add(new Edge(0,1,5)); //added edge in the arrayList at 0 index
        //1 vertex
        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));

        //2 vertex
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,2));

        //3 vertex
        graph[3].add(new Edge(3,1,3));
        graph[3].add(new Edge(3,2,1));

        //4 vertex
        graph[4].add(new Edge(4,2,2));

        //finding 2s neighbours
        for(int i=0;i<graph[2].size();i++){
            Edge e = graph[2].get(i); //colecting edge from arraylist
            //src,dest,wt -->neibhbours are all the destinations -> sources remains the same
            System.out.println(e.dest);
        }


        ///BFS
        // doesnt depend on the weight
        System.out.println("BFS");
        bfs(graph);

        //dfs 
        System.out.println("dfs");
        dfs(graph,0,new boolean[V]); //V is the number of vertices


        //has path
        System.out.println(hasPath(graph, 0, 9, new boolean[V]));
        

    }
}
package graphs;
import java.util.*;
public class g4 {
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){ //unweighted graph
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));

    }
    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> stack) {
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, stack);
            }
        }
        stack.push(curr);
        return;
    }
    public static void topologicalSort(ArrayList<Edge>[] graph) { // O(V + E)
        boolean[] vis = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<graph.length;i++) {
            if(!vis[i]) {
                topSortUtil(graph, i, vis, stack); // modified dfs
            }
        }

        while(!stack.isEmpty()) {
            System.out.println(stack.pop() + " ");
        }
    }
    public static boolean isCycleDirected(ArrayList<Edge>[] graph) { // FOR DIRECTED GRAPH
        boolean[] vis = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];

        for(int i=0;i<graph.length;i++) {
            if(!vis[i]) {
                if(isCycleDirectedUtil(graph, i, vis, stack)) { // for connected components
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isCycleDirectedUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean[] stack) {
        vis[curr] = true;
        stack[curr] = true;
        for(int i=0;i<graph[curr].size();i++) {
            Edge e = graph[curr].get(i);
            if(stack[e.dest]) {
                return true;
            }
            if(!vis[e.dest] && isCycleDirectedUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }
    public static boolean isBipartite(ArrayList<Edge>[] graph){
        int col[] = new int[graph.length];
        for(int i=0;i<col.length;i++){
            col[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<graph.length;i++){ //loop for connected components
            if(col[i] == -1){
                q.add(i);
                col[i] = 0; //yelllow
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j=0;j<graph[curr].size();j++){
                        Edge e = graph[curr].get(j);
                        if(col[e.dest] == -1){
                            int nextcol = col[curr] == 0 ? 1 : 0;
                            col[e.dest] = nextcol;
                            q.add(e.dest);
                        }
                        else if(col[e.dest] == col[curr]){
                            return false;
                        } //not bipartite
                    }
                }
            }
        }
        return true; //nothing wrong means bipartite
    }

    public static void main(String args[]){

        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        
        System.out.println(isBipartite(graph));
    }
    
}

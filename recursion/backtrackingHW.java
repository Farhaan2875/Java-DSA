public class backtrackingHW {

    public static void solveMaze(int sr, int sc, int er,int ec, String s,int[][] maze,boolean isVisited[][]){
        if(sr<0 ||  sc<0){
            return;
        }
        if(sr>er || sc>ec){
            return;
        }
        if(maze[sr][sc]==0){
            return;
        }
        if(sr==er && sc==ec){
            System.out.println(s);
            return;
        }
        if(isVisited[sr][sc]==true){
            return;
        }
        isVisited[sr][sc] = true;

        //go right
        solveMaze(sr, sc+1, er, ec, s + "R", maze, isVisited);

        //go left
        solveMaze(sr, sc-1, er, ec, s + "L", maze, isVisited);

        //go Down
        solveMaze(sr+1, sc, er, ec, s + "D", maze, isVisited);

        //go up
        solveMaze(sr-1, sc, er, ec, s + "U", maze, isVisited);

        //backtrakcing
        isVisited[sr][sc] = false;



    }
    public static void printArr(int sol[][]){
        System.out.println("----one way for rat to reach----");
        for(int i=0;i<sol.length;i++){
            for(int j=0;j<sol[0].length;j++){
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int maze[][] =  { { 1, 0, 0, 0 }, 
                        { 1, 1, 0, 1 }, 
                        { 0, 1, 0, 0 }, 
                        { 1, 1, 1, 1 } };
                        
        boolean isVisited[][] = new boolean[maze.length][maze[0].length]; //default false values
    solveMaze(0,0,maze.length - 1,maze[0].length - 1,"",maze,isVisited);
    }
}

public class backtracking2 {

    public static int gridWays(int i, int j, int n, int m){
        //i and j --> repr current cell

        //base case
        if(i==n-1 && j==m-1){ //last cell condition
            return 1;
        }else if(i == n || j == m){ //boundary cross condition
            return 0;
        }
        int w1 = gridWays(i+1, j, n, m);
        int w2 = gridWays(i, j+1, n, m);
        return w1 + w2;
        //tc -> 2^(n+m) --> OPRIMISED LINEAR TC FOR THIS PROBLEM -> USING PERM AND COMB -> IN NB
    }

    public static boolean isSafe(char board[][],int row, int col){//checking is previously placed queen is attacking or not
        //upper up attack check
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        //diagonal left up attack check
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        //diagonal right ettack check
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        //safe to be placed
        return true;

    }

    public static void nQueens(char board[][], int row){
        //base case
        if(row == board.length){
            printBoard(board);
            count++; //for counting variation of n queens problem
            return;
        }
        for(int j=0;j<board.length;j++){
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
                nQueens(board, row+1);
                board[row][j] = 'X'; //backtracking step
            }
        }
    }

    static int count = 0;

    public static void printBoard(char board[][]){
        System.out.println("-----chess board------");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        int n = 5;
        char board[][] = new char[n][n];
        //initialising empty board
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                board[i][j] = 'X';
            }
        }

        //calling n queens after intialising empty board
        nQueens(board, 0);
        System.out.println("totol ways to solve n queens = " + count);
        //count ways to solve n queens --> same t.c

        //grid ways
        int r = 2,c=2;
        System.out.println(gridWays(0, 0, r, c));
    }
}

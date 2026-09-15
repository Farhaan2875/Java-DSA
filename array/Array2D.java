package array;

import java.util.*;
public class Array2D {

    public static boolean staircaseSearch(int mat[][],int target){
        // brute force -- o(n^2)
        // binary search in each row - O(n log n) time
        // best tc --> staircase search --> array needs to be sorted --> both row-wise and column wise ex: mat in main
        // tc of staircase search is O(n+m) 
        // we can use wither the top right element or bottom left element to start
        int row = 0, col = mat[0].length - 1;
        while(row<mat.length && col>=0){
            if(mat[row][col]==target){
                System.out.println("found key at "+row+" ,"+col);
                return true;
            }
            else if(target<mat[row][col]){
                col--;
            }
            else{
                row++;
            }
        }
        System.out.println("not found");
        return false;

    }
    public static int diagonalSum(int matrix[][]){
        //primary diagonal condiition = i ==j
        // SECONDARY diagonal condition =  i+j = n-1 where n is the size of the square matrix

        //brute force solution is not optimised

        //from above j = n-1-i
        int sum = 0;
        for(int i=0;i<matrix.length;i++){
            sum += matrix[i][i];
            if(i!=matrix.length-1-i){
                sum += matrix[i][matrix.length-1-i];
            }
        }
        return sum;
    }
    //spiral matrix --> adove, apple, micro etc
    public List<Integer> spiralOrder(int[][] matrix) {
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;

        List<Integer> List = new ArrayList<>();
        while(startRow<=endRow && startCol<=endCol){
            //top
            for(int j=startCol;j<=endCol;j++){
                List.add(matrix[startRow][j]);
            }
            //right
            for(int i=startRow+1;i<=endRow;i++){
                List.add(matrix[i][endCol]);
            }

            //bottom
            for(int j=endCol - 1;j>=startCol;j--){
                if(startRow==endRow){
                    break;
                }
                List.add(matrix[endRow][j]);
            }

            //left
            for(int i=endRow-1;i>=startRow+1;i--){
                if(startCol==endCol){
                    break;
                }
                List.add(matrix[i][startCol]);

            }
            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
        return List;
    }

    public static boolean search(int arr[][],int key){
        for(int i=0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                if(arr[i][j]==key){
                    System.out.println("found at" + i +" "+ j);
                    return true;
                }
            }
        }
        System.out.println("not found");
        return false;
    }
    public static void main(String args[]){
        //declaring 2d array
        int matrix[][] = new int[3][3];
        int n = matrix.length, m = matrix[0].length;
        // this matrix containd 9 cells - 3*3
        // contains 3 rows and 3 columns but indexing is 0 based i.e 0 to 2 in this case
        Scanner sc = new Scanner(System.in);
        // taking inputs for each cell
        for(int i=0;i<n;i++){
            for(int j = 0;j<m;j++){
                matrix[i][j] = sc.nextInt();

            }
        }

        //ouput
        for(int i=0;i<n;i++){
            for(int j = 0;j<m;j++){
                System.out.print (matrix[i][j] + " ");;

            }
            System.out.println();
        }

        //how array us stored in memmory
        // row major and column major -->stored in the form of contiguous rows or contiguous columns of a matrix
        // but java doesnt follow these two approches --> separate arrays are created for rows/column and stored at sepaarte memory location, an array is created which points to that memory location ->(they can be stored at contiguous memory location conincidentally)

        int mat[][] = {
            {10,20,30,40},
            {15,25,35,45},
            {27,29,37,48},
            {32,33,39,40}
        };
        ///staircase search
        staircaseSearch(mat,39);
    }
}

package basicImpCode;
public class patterns {
    public static void main(String args[]){
        // patterns are not extensively aasked in palcement --> dont do too much for placements
        //q star pattern
        // for(int i = 1;i<=4;i++){
        //     for(int j=1;j<=i;j++){
        //         System.out.print("* ");
        //     }
        //     System.out.println(); // moves the output cursor to the next line
        // }

         
        //q inverted star pattern
        // for(int i=4;i>=0;i--){
        //     for(int j=1;j<=i;j++){
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        //pattern2
        // for(int i = 1;i<=4;i++){
        //     for(int j = 1;j<=i;j++){
        //         System.out.print(j);
        //     }
        //     System.out.println();
        // }

        //pattern3
        int n = 4;
        char ch = 'A';
        for(int line=1;line<=n;line++){
            for(int chars = 1; chars<=line; chars++){
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }

        // patterns --> to be continued after functions and methods
        
    }
}

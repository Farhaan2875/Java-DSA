public class adv_patterns{


    public static void diamond(int n){
        //first half
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=2*i-1;j++){
                System.out.print("*");
            }System.out.println();
        }

        //second half --> to mirror any code pattern just reverse the outer loop --> inner loop wont change --> logic is generalized from observations
        for(int i=n;i>=1;i--){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=2*i-1;j++){
                System.out.print("*");
            }System.out.println();
        }

    }


    public static void hollow_rhombus(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }

            //hollow rec -stars
            for(int j=1;j<=n;j++){
                if(i==1 ||i==n || j==1 || j==n){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        } 
    }

    public static void solid_rhombus(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print("_");
            }
            for(int j=1;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void butterfly(int n){
        for(int i=1;i<=n;i++){
            //star 
            for(int j=1;j<=i;j++){
                 System.out.print("*");
            }
            //space
            for(int j=1;j<=2*n-2*i;j++){
            System.out.print(" ");
            }
            //star
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();

        }
        
            //mirror image --> second half
            for(int i=n;i>=1;i--){
            //star 
            for(int j=1;j<=i;j++){
                 System.out.print("*");
            }
            //space
            for(int j=1;j<=2*n-2*i;j++){
            System.out.print(" ");
            }
            //star
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }

            //mirror image --> second half
            System.out.println();
        }
    }

    public static void zero_one_tria(int r){
        for(int i=1;i<=r;i++){
            for(int j=1;j<=i;j++){
            if((i+j)%2==0){
                System.out.print("1");
            }
            else{
                System.out.print("0");
            }

            }
            System.out.println();
        }
    }

    public static void floyds_triangle(int r){
        int num = 1;
        for(int i=1;i<=r;i++){
            for(int j = 1;j<=i;j++){
                System.out.print(num + "  ");
                num++;
            }
            System.out.println();
        }
    }

    public static void inv_half_pyra_nums(int n){
        for(int i = 1;i<=n;i++){
            for(int j=1;j<=n-i+1;j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void invrt_rtt_halfPyramid(int n){
        for(int i=1;i<=n;i++){
            //for spaces
            for(int j=1;j<=n-i;j++){
            System.out.print(" ");
            }
            //for stars
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void hollow_rec(int totrows, int totcols){
        //outer loop --> row traverse
        for(int i=1;i<=totrows;i++){
            //inner loop -- columns traverse
            for(int j=1;j<=totcols;j++){
                if(i==1 || i==totrows || j==1 || j==totcols){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println(); //after we have iterated through all columns os a single row, we need to move to new row and thus to a new line
        }
    }
    public static void main(String args[]){
        //we need to visualize pattern now in the form of matrix 
        // hollow_rec(4,5);

        // invrt_rtt_halfPyramid(20);

        //inverted half pyra with nums
        inv_half_pyra_nums(5);

        //floyds triangle
        floyds_triangle(5);

        //01 triangle
        zero_one_tria(5);

        //butterfly
        butterfly(5);

        //solid rhombus
        solid_rhombus(4);


        //hollow rhom
        hollow_rhombus(5);

         //diamond
         diamond(4);

    }
}
package binaryTrees;

public class bt2 {
    static class Node{//made classa for node -> not binary trees but its node
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static int height(Node root){//will be used as a helper function in many questions
            if(root == null){ //O(n)
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);

            int height = Math.max(lh, rh) + 1; //height of root is height of children + 1 (and move recursively like this)

            return height;
    }

    public static int diameterApproach1(Node root){ //O(n^2)
        //we return the diameter as int each time
        if(root == null){ //root has 0 dia and 0 height
            return 0;
        }
        int leftdia = diameterApproach1(root.left);
        int leftht = height(root.left);
        int rightdia = diameterApproach1(root.right);
        int rightht = height(root.right);

        int selfdia = leftht + rightht + 1;
        return Math.max(selfdia, Math.max(leftdia,rightdia));//imp line
         
    }


    public static boolean isIdentical(Node node, Node subRoot){
        //ez to check for non identical as the condiitons are less
        if(node == null && subRoot == null){
            return true; //when both null -> end of nodes
        }else if(node == null || subRoot == null || node.data != subRoot.data){ //agr ek bhi null hogya aur dusra nahi (dono null honge to first wali condiiton chlegi)
            return false;
        }

        if(!isIdentical(node.left, subRoot.left)){ //these two if condiiton have the recursive calls -> theu run before the last line
            //doing depth first 
            return false;
        }
        if(!isIdentical(node.right, subRoot.right)){ //another recursive calll
            return false;
        }

        return true; //if false nahi hui then they are identical

    }
    
    public static boolean isSubtree(Node root, Node subRoot){   
        if(root == null){
            return false;
        }
        if(root.data == subRoot.data){
            if(isIdentical(root, subRoot)){
                return true; //returns true and exits
            }
        }

        // boolean leftAns = isSubtree(root.left, subRoot);
        // boolean rightAns = isSubtree(root.right, subRoot);

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot); //will run if we are not able to find to root with same value initially
        //more efficient to directly write this as acc to or rule, if first one is true then the second statement never runs ->saving time -> meand agr left me mil gya to right me find hi nahi krega
    }

    static class Info{ //use this class's object to find diameter in O(n)
        int diam;
        int ht;
        public Info(int diam, int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }
    public static Info diameterOnApproach(Node root){ 
        //O(n) time --> height is calculated yahi ke yahi
        if(root == null){
            return new Info(0,0);
        }
        Info leftInfo = diameterOnApproach(root.left);
        Info rightInfo = diameterOnApproach(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);

        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(diam, ht);
        
    }

    public static void main(String[] args) {
        //made a binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("diameter of tree is : " + diameterApproach1(root));

        System.out.println("Diamter by new approach : " + diameterOnApproach(root).diam); //it returns an object of Info class and we have to acces its field 


        //subtree of another tree
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);
        System.out.println(isSubtree(root, subRoot));

        
    }
}

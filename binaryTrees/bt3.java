package binaryTrees;
import java.util.*;
public class bt3 {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void Klevel(Node root, int level, int K){
        if(root == null){
            return;
        }
        if(level == K){
            System.out.println(root.val + " ");
            return;//dont check further levels
        }
        Klevel(root.left, level + 1, K);
        Klevel(root.right, level + 1, K);

    }

    //lca problem
    public static boolean getpath(Node root, int n, ArrayList<Node> path){ //O(n)
        //base case
        if(root == null){
            return false;
        }
        path.add(root);
        if(root.val == n){
            return true;
        }
        boolean foundLeft = getpath(root.left, n, path);
        boolean foundRight = getpath(root.right, n, path);

        if(foundLeft || foundRight){ //node exist either in left subtree of right subtree of this root -> this root will exist in the path
            return true;
        }

        path.remove(path.size()-1); //if node doesnt exist in the subtree of this root remove the root that we added
        return false; //removed and returned false

    }

    public static Node lca(Node root, int n1, int n2){ //O(n)
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getpath(root, n1, path1); //arrays are call by refernece
        getpath(root, n2, path2);

        //lca find
        int i = 0;
        for(; i<path1.size() && i<path2.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }

        //last equal --> will be at i-1
        Node lca = path1.get(i-1);
        return lca; //we returned the lca node

    }

    
    //lca approach 2
    public static Node lca2(Node root, int n1, int n2){
        //base case
        if(root == null){
            return null;
        }
        if(root.val == n1 || root.val == n2){
            return root;
        }
        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        //if leftlca has a val and rightlca = null --> means woh root kbhi lca ho hi nhi skta -> leftlca me hi ans hai
        if(rightLca == null){
            return leftLca;
        }
        //slly
        if(leftLca == null){
            return rightLca;
        }

        return root; //if both not null --> dry run to understand
    }

    //minnimum distance between nodes
    //distance is the number of edges between them
    //best method is to use lca --> most efficient
    //min dist = dist from lca to n1 + dist from lca to n2
    public static int lcaDis(Node root, int n){
        if(root == null){
            return -1;
        }
        if(root.val == n){ //distance between ans and ans is 0
            return 0;
        }

        int leftdist = lcaDis(root.left, n);
        int rightdist = lcaDis(root.right, n);

        if(leftdist == -1 && rightdist == -1){
            return -1; //no ans
        }else if(leftdist == -1){
            return rightdist + 1;
        }else{
            return leftdist + 1;
        }

    }
    public static int minDist(Node root, int n1, int n2){
        Node lca = lca2(root, n1, n2);
        int d1 = lcaDis(lca, n1);
        int d2 = lcaDis(lca, n2);
        return d1+d2;

    }

    //kth ancestor of node (from bottom)
    //similar to minimum dist problem with some modifications
    //imagine k as distance
    public static int Kancestors(Node root, int n, int k){
        if(root == null){
            return -1;
        }
        if(root.val == n){
            return 0;
        }

        int leftdis = Kancestors(root.left, n, k);
        int rightdis = Kancestors(root.right, n, k);

        if(leftdis == -1 && rightdis == -1){
            return -1;
        }
        int max = Math.max(leftdis, rightdis);
        if(max+1 == k){ //trick to deal with -1
            System.out.println(root.val);
        }
        return max + 1; //returns its dist
    }
    //transform to sum tree
    public static int transform(Node root){
        if(root == null){
            return 0;
        }
        int leftchild = transform(root.left);
        int rightchild = transform(root.right);

        int val = root.val;
        int newleft = root.left == null ? 0 : root.left.val;
        int newright = root.right == null ? 0 : root.right.val;
        //if leaf node then 0

        root.val = newleft + leftchild + newright + rightchild;
        return val;
    }
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


        //K level prob
        int k = 3;
        Klevel(root, 1, k);


        //last common ancestor problem
        int n1 = 4, n2 = 3;
        System.out.print("lca is: ");
        System.out.println(lca(root, n1, n2).val);

        //lca approach 2
        System.out.println(lca2(root, n1, n2).val);

        //minimum dist
        System.out.println(minDist(root, n1, n2));
 
        //kth ancestors
        System.out.print("kth ancestors : ");
        System.out.println(Kancestors(root,5,1));

        //sum tree transform O(n)
        Node rt = new Node(1);
        rt.left = new Node(2);
        rt.right = new Node(3);
        rt.left.left = new Node(4);
        rt.left.right = new Node(5);
        rt.right.left = new Node(6);
        rt.right.right = new Node(7);

        transform(rt);
        preorder(rt);
        


        
    }
}

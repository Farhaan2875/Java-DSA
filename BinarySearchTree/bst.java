package BinarySearchTree;
import java.util.ArrayList;
public class bst {
    static class Node{
        int data;
        Node left;
        Node right;

        Node (int data){
            this.data = data;
            // In Java, when you create an object using the new keyword, all instance variables are automatically initialized to their default values, even if you don’t explicitly assign them. For example, in your Node class, since left and right are object references, their default value is null. This means that when you create a new node with new Node(5), Java automatically sets left and right to null, even though you didn’t write this.left = null and this.right = null in the constructor.
            
        }
    }

    public static Node buildBST(Node root, int val){
        if(root == null){ //When you reach a null spot, place the new node there.
            root = new Node(val);
            return root;
        }

        //other cases
        if(root.data > val){
            //left subtree
            root.left = buildBST(root.left, val);
        }else{
            root.right = buildBST(root.right, val);
        }

        return root;
        // Each recursive call goes down the tree (left or right)
        // When it finds the correct empty spot (root == null), it creates a new node and returns it
        // Each return “climbs back up” updating the parent’s child pointer

        // if you go deep into recursion and create new nodes, they get attached somewhere underneath.

        // When recursion unwinds (returns), each parent node returns itself.

        // Eventually, the top-level root is returned again.

    }
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key){
        //tc of search is O(H) h is the height of the tree
        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }

        if(root.data>key){
            return search(root.left, key);
        }

        else{
            return search(root.right, key);
        }
    }



    public static Node delete(Node root, int val){
        if(root.data < val){
            root.right = delete(root.right, val); //right subtree me jakr delete kr denge and usme se jaisa bhi change milega use update krdenge root.right me so that naya tree ban jaye after deletion 
        }
        else if(root.data > val){
            root.left = delete(root.left, val);
        }else{ //found it (data == val)
            //case 1 leaf node
            if(root.left == null && root.right == null){
                return null;
            } //means parent ko ab null return krdiya and now its parent points to null

            //case 2 single child 
            // dono null nahi ho skte becuase that case is already discussed above 
            if(root.left == null){
                return root.right; //now parent point to the right subtree
            }else if(root.right == null){
                return root.left;
            }

            //the value we are returning is the pointer which links the subree to the current node we are working on

            //case 3 - two children
            Node IS = findInorderSuccessor(root.right); //inorder successor is the leftmost node in the right subtree
            root.data = IS.data;
            root.right = delete(root.right, IS.data); //root will delete IS from its right subtree
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root){
        //root can never be null here as that is already handled in case 2
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void printInrange(Node root, int k1, int k2){

        //base case
        if(root == null){
            return;
        }
        if(root.data >= k1 && root.data <= k2){
            printInrange(root.left, k1, k2);
            System.out.print(root.data + " "); //the node in question lies in between so wee neeed to print it after traversing left subtree
            printInrange(root.right, k1, k2);
        }
        else if(root.data < k1){
            printInrange(root.right, k1, k2);
        }
        else{
            printInrange(root.left, k1, k2);
        }
    }

    //printing all paths to leaves
    public static void printPath(ArrayList<Integer> path){
        for(int i=0; i<path.size(); i++){
            System.out.print(path.get(i) + "->");
        }
        System.out.println("Null");
    }
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        //base case
        if(root.left == null && root.right == null){
            printPath(path);
        }
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size()-1);
    }

    public static boolean isValidBST(Node root, Node min, Node max){
        if(root == null){
            return true;
        }
        if(min != null && root.data <= min.data){
            return false;
        }
        else if(max!= null && root.data >= max.data){
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static Node mirror(Node root){//O(N) we visit each node one time
        if(root == null){
            return null; //swap nulls then it doesnt matter
        }

        Node leftmirror = mirror(root.left);
        Node rightmirror = mirror(root.right);

        root.left = rightmirror;
        root.right = leftmirror;

        return root;
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        //traverse the arrays to buildt bst

        for(int i=0;i<values.length;i++){
            root = buildBST(root, values[i]);
        }

        //checking if bst build or not
        inorder(root);

        //search in bst
        if(search(root, 1)){
            System.out.println("key found");
        }else{
            System.out.println("not found");
        }

        //delete node -> IMP conceptually
        // root = delete(root, 14);
        // System.out.println();
        // inorder(root);

        //print in range
        System.out.println();
        System.out.println("Print in range");
        printInrange(root, 5, 12);

        //print all paths to leaves
        System.out.println();
        System.out.println("All paths are");
        printRoot2Leaf(root, new ArrayList<Integer>());

        //valid bst
        System.out.println(isValidBST(root, null, null));

        //mirror
        System.out.println();
        root = mirror(root);
        preorder(root);
        
    }
}
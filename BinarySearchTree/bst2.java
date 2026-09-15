package BinarySearchTree;
import java.util.*;


public class bst2 {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);

    }

    public static Node createBST(int arr[], int st, int end){   
        if(st > end){
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, st, mid-1);
        root.right = createBST(arr, mid+1, end);

        return root;
    }

    //converting bst to balanced bst
    public static Node blnBST(ArrayList<Integer> inorder, int st, int end){
        if(st>end){
            return null;
        }

        int mid = (st+end)/2;
        Node root = new Node(inorder.get(mid));
        root.left = blnBST(inorder, st, mid-1);
        root.right = blnBST(inorder, mid+1, end);

        return root;

    }

    public static void getInorder(Node root, ArrayList<Integer> inorder){
        if(root == null){
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node balancedBST(Node root){
        //inorder seq
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        //creting bst

        root = blnBST(inorder, 0, inorder.size()-1);
        return root;

    }
    //size of largest bst in bt
    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;

        }
    }

    public static int maxBST = 0;
    public static Info largestBST(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info left = largestBST(root.left);
        Info right = largestBST(root.right);

        int size = left.size + right.size + 1;
        int min = Math.min(root.data, Math.min(left.min, right.min));
        int max = Math.max(root.data, Math.max(left.max, right.max));

        //Check if the current subtree is a valid BST
        if (left.isBST && right.isBST && root.data > left.max && root.data < right.min) {
        maxBST = Math.max(maxBST, size);
        return new Info(true, size, min, max);
        } else {
        return new Info(false, size, min, max);
        }
    }

    //merging two bsts

    public static Node crBST(ArrayList<Integer> arr, int st, int end){
        if(st > end){
            return null;
        }
        int mid = (st + end)/2;
        Node root = new Node(arr.get(mid));
        root.left = crBST(arr, st, mid-1);
        root.right = crBST(arr, mid+1, end);
        return root;
    }
    public static Node mergeBSTs(Node root1, Node root2){
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root1, arr1);
        getInorder(root2, arr2);

        int i = 0, j = 0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i) <= arr2.get(j)){
                finalArr.add(arr1.get(i));
                i++;
            }else{
                finalArr.add(arr2.get(j));
                j++;
            }
        }

        while(i<arr1.size()){
            finalArr.add(arr1.get(i));
            i++;
        }
        while(j<arr2.size()){
            finalArr.add(arr2.get(j));
            j++;
        }

        return crBST(finalArr, 0, finalArr.size()-1);
    }

    
    public static void main(String[] args) {
        int arr[] = {3,5,6,8,10,11,12};

        Node root = createBST(arr, 0, arr.length - 1);
        preorder(root);

        //convert to balanced bst
        Node rt = new Node(8);
        rt.left = new Node(6);
        rt.left.left = new Node(5);
        rt.left.left.left = new Node(3);
        rt.right = new Node(10);
        rt.right.right = new Node(11);
        rt.right.right.right = new Node(12);
 
        rt = balancedBST(rt);
        System.out.println();
        preorder(root);
        //total tc to balance a BST is O(n)


        //bst in bianary tree
        Node n = new Node(50);
        n.left = new Node(30);
        n.left.left = new Node(5);
        n.right = new Node(60);
        n.right.right = new Node(20);
        
        n.right.left = new Node(45);
        n.right.right = new Node(70);
        n.right.right.left = new Node(65);
        n.right.right.right = new Node(80);

        Info info = largestBST(n);
        System.out.println();
        System.out.println("size of largest BST is: " + maxBST);

        //merge two bsts --> O(n+m) --> O(n)
        Node t1 = new Node(2);
        t1.left = new Node(1);
        t1.right = new Node(4);

        Node t2 = new Node(9);
        t2.left = new Node(3);
        t2.right = new Node(12);

        Node nw = mergeBSTs(t1, t2);
        System.out.println();
        preorder(nw);

    }
}

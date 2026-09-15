package binaryTrees;
import java.util.*;
public class bt {
    static class Node{ //made classa for node -> not binary trees -> but its node
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{ 
        static int idx = -1;
        public static Node buildTree(int nodes[]){ //we return the root of our bt
            //tc is O(n)
            idx++;
            if(nodes[idx]==-1){
                return null; //we dont create node for null values and dont show it in trees
                //also the base condition in this recursion
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode; //returns the topmost node
        } //recursively builds the whole tree -> dry run to understand

        public static void preorder(Node root){ //root pehle
            if(root == null){
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
        public static void inorder(Node root){//root beechme
            if(root == null){
                return;
            }
            inorder(root.left);
            System.err.print(root.data + " ");
            inorder(root.right);

        }
        public static void postorder(Node root){//root baadme
            if(root==null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.err.print(root.data + " ");

        }

        public static void levelorder(Node root){
            if(root == null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break; //last null or leaves reached
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data + " ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }

            }
        }
        public static int height(Node root){//will be used as a helper function in many questions
            if(root == null){ //O(N)
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);

            int height = Math.max(lh, rh) + 1; //height of root is height of children + 1 (and move recursively like this)

             return height;
        }

        
        public static int count(Node root){//counting number of nodes -->  O(n)
            if(root == null){
                return 0;
            }
            int leftcount = count(root.left);
            int rightcount = count(root.right);

            return leftcount + rightcount + 1;
        }


        public static int sumofNodes(Node root){
            if(root == null){
                return 0;
            }
            int leftsum = sumofNodes(root.left);
            int rightsum = sumofNodes(root.right);

            return leftsum + rightsum + root.data;
        }

    }

    //TOP VIEW
    static class Info{
        Node node;
        int hd;
        public Info(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    public static void topView(Node root){
        //level order trversal
        //we need to store two values while trversing -> the horizontal distance and the node value --> create a new class
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();

        int min = 0, max = 0;//both zero initially
        //min max is used to print the result in a order since hashmao is unordered data structure

        q.add(new Info(root, 0));
        q.add(null);
        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(curr.hd)){ //first occurence of hd
                    map.put(curr.hd,curr.node);
                }
                if(curr.node.left != null){
                    q.add(new Info(curr.node.left,curr.hd - 1));
                    min = Math.min(min, curr.hd-1); //we can never get min from right
                }
                if(curr.node.right != null){
                    q.add(new Info(curr.node.right, curr.hd + 1));
                    max = Math.max(max,curr.hd+1);
                }
            }

        }
        //printing
        for(int i=min;i<=max;i++){
            System.out.print(map.get(i).data + " ");
        }

    }
    public static void bottom(Node root){
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> hm = new HashMap<>();
        q.add(new Info(root, 0));
        q.add(null);
        int max = 0, min = 0;
        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                hm.put(curr.hd, curr.node);
                if(curr.node.left != null){
                    q.add(new Info(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
                if(curr.node.right != null){
                    q.add(new Info(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
        }
        //important -> visulization of bt botto view with pen and paper
        System.out.println("Bottom view is : ");
        for(int i=min;i<=max;i++){
            System.out.print(hm.get(i).data + " ");
        }

    }

    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};//pre order sequence
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data); //root pr to 1 hai

        tree.preorder(root);
        System.out.println();
        tree.inorder(root);
        System.out.println();
        tree.postorder(root);

        System.out.println();
        tree.levelorder(root);


        System.out.println("height of bt is : " + tree.height(root));

        //can build like this
        Node rt = new Node(1);
        rt.left = new Node(2);
        rt.right = new Node(3);
        rt.left.left = new Node(4);
        rt.left.right = new Node(5);
        rt.right.left = new Node(6);
        rt.right.right = new Node(7);

        //counting nodes
        System.out.println("no. of nodes : " + tree.count(root));

        //sum of all nodes
        System.out.println("sum of all nodes : " + tree.sumofNodes(root));

        //TOP VIEW OF A TREE
        System.out.print("top view : ");
        topView(rt);


        //BOTTOM VIEW OF A BINARY TREE
        System.out.println();
        Node nr = new Node(20);
        nr.left = new Node(3);
        nr.right = new Node(22);
        nr.left.left = new Node(5);
        nr.left.right = new Node(3);
        nr.left.right.left = new Node(10);
        nr.left.right.right = new Node(14);
        nr.right.right = new Node(25);
        bottom(rt);
        bottom(nr);

    }
}

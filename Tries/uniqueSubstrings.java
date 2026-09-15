package Tries;
public class uniqueSubstrings {
    static class Node{
        Node children[] = new Node[26]; //children array
        boolean eow = false; //end of word -> use by defualt false
        Node(){
            for(int i=0;i<26;i++){
                children[i] = null;
                //initialize each children with null at the start
            }
        }
    }
    
    public static Node root = new Node(); //root node has no data of its own -> it only stores its childrn array


    public static void insert(String word){
        //tc- > O(L) -> L is length of the word
        Node curr = root;
        for(int level = 0;level<word.length();level++){
            int idx = word.charAt(level)-'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }

        curr.eow = true; //at last char of the word
    }
    public static boolean search(String key){
        Node curr = root;
        for(int level = 0;level<key.length();level++){
            int idx = key.charAt(level) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        
        return curr.eow == true; //checks if the words exists separately or only as a part of some bigger word
    }

    public static int countNode(Node root){
        if(root == null){
            return 0;
        }
        int count = 0;
        for(int i=0;i<26;i++){
            if(root.children[i] != null){
                count += countNode(root.children[i]);
            }
        }

        return count+1; //return count+1 for each node of each level
    }
    public static void main(String[] args) {
        //unique substrings questions

        String str = "ababa";

        //finding all suffixes
        for(int i=0;i<str.length();i++){
            String suffix = str.substring(i);
            //making a triw of the suffixes
            insert(suffix);
        }

        System.out.println(countNode(root));
    }
}

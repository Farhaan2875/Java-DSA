package Tries;

public class trie {

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
    
    public static boolean wordBreak(String key){
        //base case
        if(key.length() == 0){
            return true;
        }
        for(int i=0;i<=key.length();i++){
            //we solve recursively 
            //substring(first idx, second idx) -> second idx is not inclusive
            if(search(key.substring(0, i)) &&
            wordBreak(key.substring(i))){
                //wordbreak only called when the first part is found in the tr
                return true;
            }
        }
        return false;
    }

    public static boolean startsWith(String key){
        Node curr = root;
        for(int i=0;i<key.length();i++){
            int idx = key.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }

        return true;
        //no need to check eow
    }
    public static void main(String[] args) {
        String words[] = {"the", "a", "there", "their", "any", "thee"};

        for(String s: words){ //storing all the words in the trie
            insert(s);
        }

        System.out.println(search("thee"));
        System.out.println(search("thor"));

        //word break problem
        String arr[] = {"i", "like", "sam", "samsung", "mobile", "icw"};
        for(int i=0;i<arr.length;i++){
            insert(arr[i]);
        }

        String key = "ilikesamsung";
        System.out.println(wordBreak(key));


        //starts with
        System.out.println("starts with problem : ");
        System.out.println(startsWith("samsu"));
        System.out.println(startsWith("samsungnnjcn"));



    }
}

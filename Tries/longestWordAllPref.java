package Tries;


public class longestWordAllPref {
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
    public static String ans = "";
    public static void longestWord(Node root, StringBuilder temp){
        if(root == null){//just written as convention -> this case will never run because of the code algorithm
            //will run if you have an empty trie
            return;
        }

        for(int i=0;i<26;i++){
            if(root.children[i] != null && root.children[i].eow == true){
                char ch = (char)(i + 'a');
                temp.append(ch);
                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                //backtracking step
                temp.deleteCharAt(temp.length()-1);
            }
        }



    }
    public static void main(String[] args) {
        //longest string which contains all prefix
        String words[] = {"a","banana","app","appl","ap","apply","apple"};

        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}

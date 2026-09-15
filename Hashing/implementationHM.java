package Hashing;
import java.util.HashMap;
import java.util.LinkedList;
import java.lang.Math;
import java.util.ArrayList;
public class implementationHM {
    //this implemenntation is same AS INTERNALLY IN JAVA
    // DONT USE THIS WHILE SOLVING QUESTIONS -> IMPLEMENTATION IS ASKED SEPARATELY IN INTERVIEWS 
    static class HashMap<K,V>{
            // K,V -> varibles like these are called generics in java -> we use them when we dont know the type of the variable -> they are called parameterized types -> K and V value can be boolean, int, String etc
            private class Node{
                K key;
                V value;

                public Node(K key, V value){
                    this.key = key;
                    this.value = value;
                }
            }

            private int n; // total number of nodes -> n
            private int N; //size of buvket 
            private LinkedList<Node> bucket[]; // -> N
            // meand value stored in the array is in the form of linked list

            @SuppressWarnings("unchecked")
            public HashMap(){ //constructor for hashmap classs
                this.N = 4;
                this.bucket = new LinkedList[4];
                //size of array containing linked list
                for(int i=0;i<4;i++){
                    this.bucket[i] = new LinkedList<>();
                    //we initilaize an empty linkedlist at each indec of the bucket array
                }
            }

            private int hashFunction(K key){
                int hc = key.hashCode(); //performs hashing and changes the form of data and gives us a random int index -> but we need the bucket index -> from 0 to size()-1 of array
                //take abs and mpdulo with size to get idx > guaranteed to give value within 0 to size()-1
                return Math.abs(hc) % N;
            }
            private int SearchInLL(K key, int bi){
                LinkedList<Node> ll = bucket[bi];
                int di = 0;
                for(int i=0;i<ll.size();i++){
                    Node node = ll.get(i);
                    if(node.key == key){
                        return di;
                    }
                    di++;
                }
                return -1; // not found

            }
            @SuppressWarnings("unchecked")
            private void rehash(){
                LinkedList<Node> oldBuck[] = bucket;
                bucket = new LinkedList[N*2]; // re initialized the prev bucket and made it double the size (this empties the bucket also)
                N = 2*N;
                for(int i=0;i<bucket.length;i++){
                    bucket[i] = new LinkedList<>();
                }

                //add prev nodes in new bucket
                for(int i=0;i<oldBuck.length;i++){
                    LinkedList<Node> ll = oldBuck[i];
                    for(int j=0;j<ll.size(); j++){
                        Node node = ll.remove();
                        put(node.key, node.value);
                    }
                }

            }
            public void put(K key, V value){ //O(lambda) -> O(1)
                //we need to find bucket index
                int bi = hashFunction(key);
                //now search on ll -> if key exist return the index of the key else return -1
                int di = SearchInLL(key, bi);
                if(di != -1){
                    Node node = bucket[bi].get(di);
                    node.value = value;
                }else{
                    bucket[bi].add(new Node(key, value));
                    //this method adds at the end of the linked list
                    n++;
                }

                double lambda = (double)n/N;
                if(lambda > 2.0){
                    rehash();
                }

            }

            public boolean containsKey(K key){//O(lambda) -> O(1)
                //we need to find bucket index
                int bi = hashFunction(key);
                //now search on ll -> if key exist return the index of the key else return -1
                int di = SearchInLL(key, bi);
                if(di != -1){
                    return true;
                }else{
                    return false;
                }               
            }

            public V get(K key){//O(lambda) -> O(1)
                //we need to find bucket index
                int bi = hashFunction(key);
                //now search on ll -> if key exist return the index of the key else return -1
                int di = SearchInLL(key, bi);
                if(di != -1){
                    Node node = bucket[bi].get(di);
                    return node.value;
                }else{
                    return null;
                }
            }

            public V remove(K key){//O(lambda) -> O(1)
                //we need to find bucket index
                int bi = hashFunction(key);
                //now search on ll -> if key exist return the index of the key else return -1
                int di = SearchInLL(key, bi);
                if(di != -1){
                    Node node = bucket[bi].remove(di);
                    n--; //total node size decreased
                    return node.value;
                }else{
                    return null;
                }
            }

            public ArrayList<K> keySet(){
                ArrayList<K> keys = new ArrayList<>();

                for(int i=0;i<bucket.length;i++){
                    LinkedList<Node> ll = bucket[i];
                    for(Node node : ll){
                        keys.add(node.key);
                    }
                }
                return keys;
            }
            public boolean isEmpty(){
                return n==0;
            }
        }
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        //this is not built in -> this is the one we created

        hm.put("India", 100);
        hm.put("China", 90);
        hm.put("Nepal", 10);

        ArrayList<String> keys = hm.keySet();
        System.out.println(keys);

        System.out.println(hm.get("India"));
        System.out.println(hm.remove("India"));

        System.out.println(hm.get("India"));
    }
}

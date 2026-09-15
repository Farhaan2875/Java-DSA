package priorityQ;
import java.util.Comparator;
import java.util.PriorityQueue;

public class pq {
    //using pq for objects of classes
    //whenever we need priority in classes - > we need to implement a special interface -> called Comparable -> in built in java -> allows us to write our own logic in a class to compare its objects
    //Comparable class has a function called compareTo which we implement in Student class (made this a child of Comparable class) --> by function overriding
    static class Student implements Comparable<Student>{
        String name;
        int rank;

        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }
        // method over riding
        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank; //logic which implements sorting -> thus pq logic 
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(7); //takes O(logn) time
        pq.add(4);
        pq.add(11);

        while(!pq.isEmpty()){
            System.out.println(pq.peek()); //O(1)
            pq.remove(); //O(logn)
        }

        //by default priority is given in asc order but we can reverse it
        PriorityQueue<Integer> n = new PriorityQueue<>(Comparator.reverseOrder());
        n.add(11);
        n.add(2);

        System.out.println("reverse order");
        while(!n.isEmpty()){
            System.out.println(n.peek());
            n.remove();
        }
        //implementing pq for objects of a class
        //
        PriorityQueue<Student> q = new PriorityQueue<>();
        q.add(new Student("a",1));
        q.add(new Student("b",30));
        q.add(new Student("c",21));
        q.add(new Student("d",2));
        System.out.println("pq for objects");
        while(!q.isEmpty()){
            System.out.println(q.peek().name + "->" + q.peek().rank);
            q.remove();
        }

        //can also reverse this order -> two ways -> using comparator.reverorder() function in pq declaration or changing the logic of comapring in the class definition
        

    }
}

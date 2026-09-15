package greedy;
import java.util.*;
//THIS CODE IS CONCEPTUALLY IMP --> SHOWS HOW TO SORT OBJECTS

public class greedyaf {
    static class Job{ //made class
        int deadline;
        int profit;
        int id;
        public Job(int i,int d, int p){
            id = i;
            deadline = d;
            profit = p;
        }
    }
    public static void main(String[] args) {
        int jobsInfo[][] = {{4,20},{1,10},{1,40},{1,30}};
        //first column is deadline and second is profit achived by doing that job

        ArrayList<Job> jobs = new ArrayList<>(); //made arraylist instead of array so that we can use collections to sort objects

        for(int i=0;i<jobsInfo.length;i++){
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1])); //making objects and storing them in array
        }

        Collections.sort(jobs,(a,b)->b.profit - a.profit);
        //used a custom comparator -> learn this syntax
        //used a lambda function here -> a,b are just varibale used to define logic, name doesnt matter

        //this sorts is decending order of profit -> reverse the logic for asc order

        //this means that when comparing two objects in the arraylist, sort them on the basis of profit in desc order

        ArrayList<Integer> seq = new ArrayList<>(); //store ans -> in form of index of jobs
        
        int time = 0;
        int profit = 0;
        for(int i=0;i<jobs.size();i++){
            Job curr = jobs.get(i); //objects are stored in array list of class Job which we defined ourselves
            if(curr.deadline>time){
                seq.add(curr.id);
                profit += curr.profit;
                time++;
            }
        }

        //printing sequence
        System.out.println("profit achieves is " + profit);
        for(int i=0;i<seq.size();i++){
            System.out.print(seq.get(i) + " ");
        }
        //we will do job c and then job a 
        


    }
}

// 🔹 What is a Comparator in Java?

// A Comparator in Java is an interface from java.util that allows us to define custom sorting logic for objects of user-defined classes.

// Normally, Java doesn’t know how to sort your custom objects (Person, Student, etc.) because it doesn’t know which property (age, name, height…) to use.

// 👉 Comparator solves this by letting you define how two objects should be compared.

// ✅ Comparator vs Comparable

// Comparable → Sorting is defined inside the class (natural ordering).
// Example: Strings (lexical order) or Integers (numeric order).

// Comparator → Sorting is defined outside the class, usually when you want different ways to sort the same class.

// 🔹 Comparator Interface

// It has one main method:

// int compare(T o1, T o2);


// Returns negative if o1 < o2

// Returns zero if o1 == o2

// Returns positive if o1 > o2

// This is the logic that Java’s Collections.sort() or List.sort() uses internally.

// ✅ Example: Sorting with Comparator
// import java.util.*;

// class Person {
//     String name;
//     int age;

//     Person(String name, int age){
//         this.name = name;
//         this.age = age;
//     }

//     @Override
//     public String toString() {
//         return name + " (" + age + ")";
//     }
// }

// public class ComparatorExample {
//     public static void main(String[] args) {
//         List<Person> list = new ArrayList<>();
//         list.add(new Person("Aman", 34));
//         list.add(new Person("Akbar", 42));
//         list.add(new Person("Anthony", 28));

//         // Sorting using Comparator (by age)
//         Comparator<Person> ageComparator = new Comparator<Person>() {
//             @Override
//             public int compare(Person p1, Person p2) {
//                 return p1.age - p2.age; // ascending order
//             }
//         };

//         Collections.sort(list, ageComparator);
//         System.out.println(list);
//     }
// }

// 🔹 Origin of Lambda Expressions

// Before Java 8, writing comparators was verbose (lots of boilerplate code).
// To simplify, Java 8 introduced Lambdas → functional style programming.

// A lambda is basically a short way to write anonymous classes (like our comparator above).

// ✅ Syntax of Lambda
// (parameters) -> expression


// or

// (parameters) -> { statements }


// It’s like defining a method without a name, directly where it is used.

// ✅ Example with Lambda
// Collections.sort(list, (p1, p2) -> p1.age - p2.age);


// This is equivalent to the earlier Comparator code, but much shorter.

// 🔹 Comparator + Lambda + Method Reference

// Java provides helper methods in Comparator like:

// Comparator.comparing()

// thenComparing()

// reversed()

// Example:

// Collections.sort(list, Comparator.comparing(p -> p.age));


// Or using method reference (cleaner):

// Collections.sort(list, Comparator.comparing(Person::getAge));

// 🔹 Use Cases

// Sorting custom objects

// By age, name, salary, marks, etc.

// Multiple sorting orders

// First by name, then by age.

// Use thenComparing().

// Functional style programming

// Cleaner, less boilerplate.

// Especially powerful with Streams API.

// ✅ Example with Multiple Sort
// Collections.sort(list,
//     Comparator.comparing((Person p) -> p.name)  // sort by name
//               .thenComparing(p -> p.age));     // if same name, sort by age

// 🔹 Key Points (Logic)

// Comparator is external sorting logic, allows flexibility.

// Lambdas came with Java 8 to reduce boilerplate and bring functional programming.

// Comparator.comparing() + lambda = most modern way.

// Use Collections.sort(list, comparator) or list.sort(comparator).

// ⚡ So the evolution is:
// Comparable → Comparator (Anonymous Class) → Comparator (Lambda) → Comparator.comparing() + Streams.

// So you can think of it like:

// If compare() < 0 → keep order.

// If compare() > 0 → swap.

// If compare() == 0 → order doesn’t change.

// ✅ Summary:
// Swapping is triggered when the comparator says the first element should come after the second one. Sorting algorithm keeps repeating this until the whole list is ordered.
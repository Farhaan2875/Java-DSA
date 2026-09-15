package queue;
public class circularqueue {
    //MAKING CIRCULAR ARRAY
    static class Queue{
        static int arr[];
        static int size;
        static int rear;
        static int front; //now we need front as well as it changes instead of being zero
        Queue(int n){
            arr = new int[n];
            size = n;
            rear = -1; //initially took -1 as index
            front = -1;
        }
        public static boolean isEmpty(){
            return rear == -1 && front == -1;
        }
        //if full
        public static boolean isFull(){
            return (rear+1)%size == front; //means rear ka agla front hai
            // Modulo is the "magic trick" that makes a linear array behave like a circle.
        }

        //add function
        public static void add(int data){ //O(1) tc 
            if(isFull()){
                System.out.println("queue is full");
                return;
            }
            //when adding first element
            if(front == -1){
                front = 0;
            }
            rear = (rear + 1)%size;
            arr[rear] = data;
        }

        //remove
        public static int remove(){ //O(1) tc because of circular array
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            
            int result = arr[front];
            //when removing last element
            if(rear == front){
                rear = front = -1;
            }else{
                front = (front+1)%size;
            }
            return result;
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            return arr[front];
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue(3);
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println(q.remove());
        q.add(4);

        System.out.println(q.remove());
        q.add(5);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
// Right now your code is mixing static and OOP concepts. Let’s clean it into a proper object-oriented circular queue.

// Why avoid static here?

// static means the variable/method belongs to the class, not the object.

// So if you create 2 queues (q1 and q2), both will end up sharing the same arr, front, and rear. ❌

// But in reality, each queue should manage its own data. ✅

// So → remove static for variables (arr, size, front, rear) and methods (add, remove, etc.).


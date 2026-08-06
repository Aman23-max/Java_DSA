import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class QueueB {
    // Queues using Circular Array
    // static class Queue{
    //     static int arr[];
    //     static int size;
    //     static int rear;
    //     static int front;

    //     Queue(int n) {
    //         arr = new int[n];
    //         size = n;
    //         rear = -1;
    //         front = -1;
    //     }

    //     public static boolean isEmpty() {
    //         return rear == -1 && front == -1;
    //     }

    //     public static boolean isFull() {
    //         return (rear+1) % size == front;
    //     }

    //     public static void add(int data) {
    //         if(isFull()) {
    //             System.out.println("queue is full");
    //             return;
    //         }
    //         //add 1st element
    //         if(front == -1) {
    //             front = 0;
    //         }
    //         rear = (rear + 1) % size;
    //         arr[rear] = data;
    //     }

    //     public static int remove() {
    //         if(isEmpty()) {
    //             System.out.println("empty queue");
    //             return -1;
    //         }
    //         int result = arr[front];
    //         //last el delete
    //         if(rear == front) {
    //             rear = front = -1;
    //         } else {
    //             front = (front + 1) % size;
    //         }
    //         return result;
    //     }

    //     public static int peek() {
    //         if(isEmpty()) {
    //             System.out.println("empty queue");
    //             return -1;
    //         }
    //         return arr[front];
    //     }
    // }


    // Queues using LinkedList
    // static class Node {
    //     int data;
    //     Node next;
        
    //     Node(int data) {
    //         this.data = data;
    //         this.next = null;
    //     }
    // }

    // static class Queue{
    //     static Node head = null;
    //     static Node tail = null;

    //     public static boolean isEmpty() {
    //         return head == null && tail == null;
    //     }

    //     public static void add(int data) {
    //         Node newNode = new Node(data);
    //         if(head == null) {
    //             head = tail = newNode;
    //             return;
    //         }
    //         tail.next = newNode;
    //         tail = newNode;
    //     }

    //     public static int remove() {
    //         if(isEmpty()) {
    //             System.out.println("empty queue");
    //             return -1;
    //         }
    //         int front = head.data;
    //         //Single element
    //         if(tail == head) {
    //             head = tail = null;
    //         } else {
    //             head = head.next;
    //         }
    //         return front;
    //     }

    //     public static int peek() {
    //         if(isEmpty()) {
    //             System.out.println("empty queue");
    //             return -1;
    //         }
    //         return head.data;
    //     }
    // }
    

    // Queues using 2 Stacks
    // static class Queue {
    //     static Stack<Integer> s1 = new Stack<>(); 
    //     static Stack<Integer> s2 = new Stack<>();

    //     public static boolean isEmpty() {
    //         return s1.isEmpty();
    //     }

    //     public static void add(int data) {
    //         while (!s1.isEmpty()) {
    //             s2.push(s1.pop());
    //         }
    //         s1.push(data);
    //         while (!s2.isEmpty()) {
    //             s1.push(s2.pop());
    //         }
    //     }

    //     public static int remove() {
    //         if(isEmpty()) {
    //             System.out.println("queue empty");
    //             return -1;
    //         }
    //         return s1.pop();
    //     }

    //     public static int peek() {
    //         if(isEmpty()) {
    //             System.out.println("queue empty");
    //             return -1;
    //         }
    //         return s1.peek();
    //     }
    // }


    // Stack using 2 Queues
    // static class Stack {
    //     static Queue<Integer> q1 = new LinkedList<>(); 
    //     static Queue<Integer> q2 = new LinkedList<>();

    //     public static boolean isEmpty() {
    //         return q1.isEmpty() && q2.isEmpty();
    //     }

    //     public static void push(int data) {
    //         if(!q1.isEmpty()) {
    //             q1.add(data);
    //         } else {
    //             q2.add(data);
    //         }
    //     }

    //     public static int pop() {
    //         if(isEmpty()) {
    //             System.out.println("empty stack");
    //             return -1;
    //         }
    //         int top = -1;
    //         //case 1
    //         if (!q1.isEmpty()) {
    //             while(!q1.isEmpty()) {
    //                 top = q1.remove();
    //                 if(q1.isEmpty()) {
    //                     break;
    //                 }
    //                 q2.add(top);
    //             }
    //         } else { //case 2
    //             while(!q2.isEmpty()) {
    //                 top = q2.remove();
    //                 if(q2.isEmpty()) {
    //                     break;
    //                 }
    //                 q1.add(top);
    //             }
    //         }
    //         return top;
    //     }

    //     public static int peek() {
    //         if(isEmpty()) {
    //             System.out.println("empty stack");
    //             return -1;
    //         }
    //         int top = -1;
    //         //case 1
    //         if (!q1.isEmpty()) {
    //             while(!q1.isEmpty()) {
    //                 top = q1.remove();
    //                 q2.add(top);
    //             }
    //         } else { //case 2
    //             while(!q2.isEmpty()) {
    //                 top = q2.remove();
    //                 q1.add(top);
    //             }
    //         }
    //         return top;
    //     }
    // }


    public static void printNonRepeating(String str) {
        int freq[] = new int[26]; //'a'-'z'
        Queue<Character> q = new LinkedList<>();

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;

            while(!q.isEmpty() && freq[q.peek()-'a'] > 1) {
                q.remove();
            }

            if(q.isEmpty()) {
                System.out.print(-1+" ");
            } else {
                System.out.print(q.peek()+" ");
            }
        }
    }

    public static void interLeave(Queue<Integer> q) {
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();

        for(int i=0; i<size/2; i++) {
            firstHalf.add(q.remove());
        }

        while(!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }

    public static void reversal(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();

        while(!q.isEmpty()) {
            s.push(q.remove());
        }

        while(!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    // Stack using Deque
    // static class Stack {
    //     Deque<Integer> deque = new LinkedList<>();
        
    //     public void push(int data) {
    //         deque.addLast(data);
    //     }

    //     public int pop() {
    //         return deque.removeLast();
    //     }

    //     public int peek() {
    //         return deque.getLast();
    //     }
    // }

    // Queue using Deque
    // static class Queue {
    //     Deque<Integer> deque = new LinkedList<>();
        
    //     public void add(int data) {
    //         deque.addLast(data);
    //     }

    //     public int remove() {
    //         return deque.removeFirst();
    //     }

    //     public int peek() {
    //         return deque.getFirst();
    //     }
    // }


    public static void main(String[] args) {
        // Queues using Circular Array
        // Queue q = new Queue(3);
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // System.out.println(q.remove());
        // q.add(4);
        // System.out.println(q.remove());
        // q.add(5);

        // while(!q.isEmpty()) {
        //     System.out.println(q.peek());
        //     q.remove();
        // }


        // Queues using LinkedList, JCF, 2-Stacks
        // Queue q = new Queue();
        // Queue<Integer> q = new LinkedList<>();
        // Queue<Integer> q = new ArrayDeque<>();
        // Queue<Integer> q = new PriorityQueue<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);

        // while(!q.isEmpty()) {
        //     System.out.println(q.peek());
        //     q.remove();
        // }


        // Stack using 2-Queues
        // Stack s = new Stack();
        // s.push(1);
        // s.push(2);
        // s.push(3);

        // while (!s.isEmpty()) {
        //     System.out.println(s.peek());
        //     s.pop();
        // }
    
        
        // String str = "aabccxb";
        // printNonRepeating(str);

        // Queue<Integer> q = new LinkedList<>();
        // for(int i=1; i<=10; i++) {
        //     q.add(i);
        // }
        // interLeave(q);
        // reversal(q);
        // while (!q.isEmpty()) {
        //     System.out.print(q.peek()+" ");
        //     q.remove();
        // }


        // Deque<Integer> deque = new LinkedList<>();
        // deque.addFirst(1); //1
        // deque.addFirst(2); //2 1
        // deque.addLast(3);  //2 1 3
        // deque.addLast(4);  //2 1 3 4
        // System.out.println(deque);
        // deque.removeLast();  //2 1 3
        // System.out.println(deque);
        // System.out.println("first el = " + deque.getFirst()); //2
        // System.out.println("last el = " + deque.getLast());  //3
    
        // Stack s = new Stack();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // System.out.println("Stack peek : " + s.peek());
        // System.out.println(s.pop());
        // System.out.println(s.pop());
        // System.out.println(s.pop());

        // Queue q = new Queue();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // System.out.println("Queue peek : " + q.peek());
        // System.out.println(q.remove());
        // System.out.println(q.remove());
        // System.out.println(q.remove());
    }
}
import java.util.*;

public class HeapsB {
    static class Student implements Comparable<Student> { //overriding
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }


    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) { //O(logn)
            //add at last idx
            arr.add(data);

            int x = arr.size()-1; //x is child index
            int par = (x-1)/2; //parent index

            while(arr.get(x) < arr.get(par)) { //O(logn)
                //swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x-1)/2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        public void heapify(int i) {
            int left = 2*i + 1;
            int right = 2*i + 2;
            int minIdx = i;

            if(left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }
            if(right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }

            if(minIdx != i) {
                //swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public int remove() {
            int data = arr.get(0);

            //step1 - swap first & last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //step2 - delete last
            arr.remove(arr.size()-1);

            //step3 - heapify
            heapify(0);
            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }


    public static void heapify(int arr[], int i, int size) { //O(logn)
        int left = 2*i + 1;
        int right = 2*i + 2;
        int maxIdx = i;

        if(left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }
        if(right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if(maxIdx != i) {
            //swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxIdx, size);
        }
    }

    public static void heapSort(int arr[]) { //O(nlogn)
        //step1 - build maxHeap
        int n = arr.length;
        for(int i=n/2; i>=0; i--) {
            heapify(arr, i, n);
        }

        //step2 - push largest at end
        for(int i=n-1; i>0; i--) {
            //swap (largest-first with last)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }


    static class Point implements Comparable<Point> {
        int x, y, distSq, idx;
        
        public Point(int x, int y, int distSq, int idx) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override 
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq;
        }
    }


    static class Row implements Comparable<Row> {
        int soldiers, idx;

        public Row(int soldiers, int idx) {
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override 
        public int compareTo(Row r2) {
            if(this.soldiers == r2.soldiers) {
                return this.idx - r2.idx;
            } else {
                return this.soldiers - r2.soldiers;
            }
        }
    }


    static class Pair implements Comparable<Pair> {
        int val, idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override 
        public int compareTo(Pair p2) {
            //ascending
            //return this.val - p2.val;
            //descending
            return p2.val - this.val;
        }
    }


    public static void main(String[] args) {
        // implemented using Min-Heap
        // PriorityQueue<Integer> pq = new PriorityQueue<>(); //1, 3, 4, 7
        // implemented using Max-Heap
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); //7, 4, 3, 1

        // pq.add(3); //O(logn)
        // pq.add(4);
        // pq.add(1);
        // pq.add(7);

        // while(!pq.isEmpty()) {
        //     System.out.println(pq.peek()); //O(1)
        //     pq.remove(); //O(logn)
        // }
        

        // PriorityQueue<Student> pq = new PriorityQueue<>();
        // PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // pq.add(new Student("A", 4)); //O(logn)
        // pq.add(new Student("B", 5));
        // pq.add(new Student("C", 2));
        // pq.add(new Student("D", 12));

        // while(!pq.isEmpty()) {
        //     System.out.println(pq.peek().name +" -> "+ pq.peek().rank); //O(1)
        //     pq.remove(); //O(logn)
        // }


        // Heap pq = new Heap();
        // pq.add(3);
        // pq.add(4);
        // pq.add(1);
        // pq.add(5);

        // while(!pq.isEmpty()) { //heap sort
        //     System.out.println(pq.peek());
        //     pq.remove();
        // }


        // int arr[] = {1, 2, 4, 5, 3};
        // heapSort(arr);
        // //print
        // for(int i=0; i<arr.length; i++) {
        //     System.out.print(arr[i] +" ");
        // }


        // int pts[][] = {{3, 3}, {5, -1}, {-2, 4}};
        // int k = 2;

        // PriorityQueue<Point> pq = new PriorityQueue<>();
        // for(int i=0; i<pts.length; i++) {
        //     int distSq = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1];
        //     pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
        // }

        // for(int i=0; i<k; i++) {
        //     System.out.println("C"+ pq.remove().idx);
        // }


        // int ropes[] = {2, 3, 3, 4, 6};
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // for(int i=0; i<ropes.length; i++) {
        //     pq.add(ropes[i]);
        // }

        // int cost = 0;
        // while(pq.size() > 1) {
        //     int min1 = pq.remove();
        //     int min2 = pq.remove();
        //     cost += min1 + min2;
        //     pq.add(min1 + min2);
        // }
        // System.out.println("cost of connection n ropes = "+ cost);


        // int army[][] = {{1, 0, 0, 0},
        //                 {1, 1, 1, 1},
        //                 {1, 0, 0, 0},
        //                 {1, 0, 0, 0}};
        // int k = 2;

        // PriorityQueue<Row> pq = new PriorityQueue<>();
        // for(int i=0; i<army.length; i++) {
        //     int count = 0;
        //     for(int j=0; j<army[0].length; j++) {
        //         count += army[i][j] == 1 ? 1 : 0;
        //     }
        //     pq.add(new Row(count, i));
        // }

        // for(int i=0; i<k; i++) {
        //     System.out.println("R"+ pq.remove().idx);
        // }


        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3; //window size

        int res[] = new int[arr.length-k+1]; //n-k+1
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        //1st window
        for(int i=0; i<k; i++) {
            pq.add(new Pair(arr[i], i));
        }

        res[0] = pq.peek().val;

        for(int i=k; i<arr.length; i++) {
            while(pq.size() > 0 && pq.peek().idx <= (i-k)) {
                pq.remove();
            }

            pq.add(new Pair(arr[i], i));
            res[i-k+1] = pq.peek().val;
        }

        //print result
        for(int i=0; i<res.length; i++) {
            System.out.print(res[i] +" ");
        }
    }
}
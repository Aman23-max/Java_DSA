/**
 * BasicSortingAlgo
 */
// import java.util.Arrays;
// import java.util.Collections;

public class BasicSortingAlgo {
    public static void bubbleSort(int arr[]) {
        for(int i=0; i<arr.length-1; i++) {
            for(int j=0; j<arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    int term = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = term;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        for(int i=0; i<arr.length-1; i++) {
            int minPos = i;
            for(int j=i+1; j<arr.length; j++) {
                if(arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }
            int term = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = term;
        }
    }

    public static void insertionSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i-1;
            // finding out the correct position to insert
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev+1] = arr[prev];
                prev--;
            }
            // Insertion
            arr[prev + 1] = curr;
        }
    }

    public static void countingSort(int[] arr) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        int count[] = new int[largest + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        // Sorting
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void printArr(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {5, 4, 1, 3, 2,};
        // bubbleSort(arr);
        // selectionSort(arr);
        // insertionSort(arr);
        // countingSort(arr);

        // Arrays.sort(arr);  //O(nlogn)
        // Arrays.sort(arr, 0, 3);
        // Arrays.sort(arr, Collections.reverseOrder());
        // Arrays.sort(arr, 0, 3, Collections.reverseOrder());

        // printArr(arr);
        System.out.println("Sorted Array: " + java.util.Arrays.toString(arr));
    }
}
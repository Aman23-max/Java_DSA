// import java.util.*;

public class DivideAndConquer {
    public static void mergeSort(int arr[], int si, int ei) {
        if(si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1]; 
        int i = si;
        int j = mid+1;
        int k = 0;

        while(i <= mid && j <= ei) {
            if(arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        //left part
        while(i <= mid) {
            temp[k++] = arr[i++];
        }
        //right part
        while(j <= ei) {
            temp[k++] = arr[j++];
        }
        //copy temp to original arr
        for(k=0, i=si; k<temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void quickSort(int arr[], int si, int ei) {
        if(si >= ei) return;
        //last element
        int pIdx = partition(arr, si, ei);
        quickSort(arr, si, pIdx-1);
        quickSort(arr, pIdx+1, ei);
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si-1;

        for (int j=si; j<ei; j++) {
            if(arr[j] < pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;

        return i;
    }

    //Search in Rotated Sorted Array
    public static int search(int arr[], int tar, int si, int ei) {
        if(si > ei) {
            return -1;
        }
        int mid = si + (ei-si)/2;
        //case found
        if(arr[mid] == tar) {
            return mid;
        }
        //mid on L1
        if(arr[si] < arr[mid]) {
            //case a: left
            if(arr[si] <= tar && tar <= arr[mid]) {
                return search(arr, tar, si, mid-1);
            } else {
                //case a: right
                return search(arr, tar, mid+1, ei);
            }
        }
        //mid on L2
        else {
            //case a: right
            if(arr[mid] <= tar && tar <= arr[ei]) {
                return search(arr, tar, mid+1, ei);
            } else {
                //case a: left
                return search(arr, tar, si, mid-1);
            }
        }
    }

    // Main function to return inversion count
    public static int getInversions(int[] arr) {
        return mergeSort2(arr, 0, arr.length - 1);
    }

    // Left and right are indices of the sub-array to be sorted
    private static int mergeSort2(int[] arr, int left, int right) {
        int invCount = 0;
        
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Total inversions = left halves + right halves + merge inversions
            invCount += mergeSort2(arr, left, mid);
            invCount += mergeSort2(arr, mid + 1, right);
            invCount += merge2(arr, left, mid, right);
        }
        
        return invCount;
    }

    // Merge function that counts the split inversions
    private static int merge2(int[] arr, int left, int mid, int right) {
        int i = left;    // Starting index for left subarray
        int j = mid + 1; // Starting index for right subarray
        int k = 0;    // Starting index to be filled in temp array
        int invCount = 0;
        int temp[] = new int[(right - left + 1)];

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                // All elements remaining in the left subarray are greater than arr[j]
                invCount += (mid + 1 - i);
            }
        }

        // Copy remaining elements of left subarray if any
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements of right subarray if any
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy back the merged elements to original array
        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }

        return invCount;
    }

    public static void main(String[] args) {
        // int arr[] = {6, 3, 9, 5, 2, 8, -3};
        // mergeSort(arr, 0, arr.length-1);
        // System.out.println(Arrays.toString(arr));

        // String fruits[] = {"Banana", "apple", "Orange", "mango"};
        // Arrays.sort(fruits, String.CASE_INSENSITIVE_ORDER);
        // System.out.println(Arrays.toString(fruits));

        // int arr[] = {6, 3, 9, 5, 2, 8, -3};
        // quickSort(arr, 0, arr.length-1);
        // System.out.println(Arrays.toString(arr));

        // int arr[] = {4, 5, 6, 7, 0, 1, 2};
        // Scanner sc = new Scanner(System.in);
        // int target = sc.nextInt();
        // int tarIdx = search(arr, target, 0, arr.length-1);
        // System.out.println(tarIdx);

        // int[] arr = {2, 4, 1, 3, 5};
        // System.out.println("Inversion Count: " + getInversions(arr));

        // int[][] arr = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        // Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        // System.out.println(Arrays.deepToString(arr));
    }
}

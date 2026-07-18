public class ArraysClass {
    public static int linearSearch(int array[], int key) {
        for(int i=0; i<array.length; i++) {
            if(key == array[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void largestInArray(int array[]) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for(int i=0; i<array.length; i++) {
            if(largest <= array[i]) {
                largest = array[i];
            }
            if(smallest >= array[i]) {
                smallest = array[i];
            }
        }
        System.out.println("Largest in array: "+largest);
        System.out.println("Smallest in array: "+smallest);
    }

    public static double myPow(double x, int n) {
        double ans = 1.0;
        long num = n; 
        
        // Convert negative exponent to positive
        if (num < 0) {
            num = -num;
            x = 1.0 / x;
        }
        
        while (num > 0) {
            if (num % 2 == 1) {
                ans = ans * x;
            }
            x = x * x;
            num = num / 2;
        }
        return ans;
    }

    public static int binarySearch(int num[], int key) {
        int start = 0, end = num.length-1;
        
        while(start <= end) {
            int mid = (start + end) / 2;

            if(num[mid] == key) {  //found
                return mid;
            } else if(num[mid] > key) {  //left
                end = mid-1;
            } else {   //right
                start = mid+1;
            }

        }
        return -1;
    }

    public static void revArr(int arr[]) {
        int start = 0, end = arr.length-1;

        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void printPair(int arr[]) {
        int tp = 0;
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                System.out.print("(" + arr[i] + "," + arr[j] + ")");
                tp++;
            }
            System.out.println();
        }
        System.out.print("total pairs: " + tp);
    }

    public static void printSubArr(int arr[]) {
        int tp = 0;
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for(int i=0; i<arr.length; i++) {
            for(int j=i; j<arr.length; j++) {
                int sum = 0;
                for(int k=i; k<=j; k++) {    //subArray
                    sum += arr[k];
                    System.out.print(arr[k] + " ");
                }
                if(largest <= sum) {
                    largest = sum;
                }
                if(smallest >= sum) {
                    smallest = sum;
                }
                System.out.println("\nsum of subArr: " + sum);
                tp++;
            }
            System.out.println();
        }
        System.out.println("total subArrays = " + tp);
        System.out.println("Largest sum is: " + largest);
        System.out.println("Smallest sum is: " + smallest);
    }

    public static int kadansSum(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i=0; i<arr.length; i++) {
            currSum += arr[i];
            maxSum = Math.max(maxSum, currSum);
            
            if(currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }

    public static int subArrSumEqualsK(int arr[], int q) {
        int currArr[] = new int[arr.length];
        currArr[0] = arr[0];
        int count = 0;

        for(int i=1; i<arr.length; i++) {
            currArr[i] = currArr[i-1] + arr[i];
        }
        
        for(int i=0; i<currArr.length; i++) {
            for(int j=i; j<currArr.length; j++) { 
                int sum = (i == 0) ? currArr[j] : currArr[j] - currArr[i-1];
                if(sum == q) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int trap(int[] height) {
        int n = height.length;

        //calculate leftMax array
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for(int i=1; i<n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        //calculate rightMax array
        int rightMax[] = new int[n];
        rightMax[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int trappedWater = 0;
        for(int i=0; i<n; i++) {
            //waterLevel = min(leftMax, rightMax)
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            //trappedWater = waterLevel - height
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;
    }

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

    public static void printArr(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        // Scanner sc = new Scanner(System.in);
        // System.out.print("The key is: ");
        // int key = sc.nextInt();
        // int array[] = {2, 4, 6, 8, 10, 12, 14, 16};
        // int index = linearSearch(array, key);

        // if(index == -1) {
        //     System.out.print("Not Found");
        // } else {
        //     System.out.print("key is at index : "+index);
        // }

        // int array[] = {4, 1, 6, 3, 8, 11, 7};
        // largestInArray(array);

        // System.out.print(myPow(2,6));

        // int num[] = {2, 4, 6, 8, 10, 12, 14, 16};
        // int key = 16;
        // System.out.print("Index of key through binary search: " + binarySearch(num, key));

        // int arr[] = {2, 4, 6, 8, 10, 12, 14};
        // revArr(arr);
        // for(int i=0; i<arr.length; i++) {
        //     System.out.print(arr[i] + ", ");
        // } 

        // int arr[] = {2, 4, 6, 8, 10};
        // printPair(arr);
        // int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        // printSubArr(arr);
        // System.out.print(kadansSum(arr));

        // int arr[] = {1, 2, 3}, q = 3;
        // int count = subArrSumEqualsK(arr, q);
        // System.out.print(count);

        // int height[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        // System.out.print(trap(height));

        // int arr[] = {5, 4, 1, 3, 2,};
        // bubbleSort(arr);
        // selectionSort(arr);
        // printArr(arr);
        // System.out.println("Sorted Array: " + java.util.Arrays.toString(arr));
    }
}
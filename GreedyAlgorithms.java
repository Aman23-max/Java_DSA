// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Collections;
// import java.util.Comparator;
import java.util.*;

public class GreedyAlgorithms {
    // Activity Selection Code
    // public static void main(String args[]) {
    //     int start[] = {1, 3, 0, 5, 8, 5};
    //     int end[] = {2, 4, 6, 7, 9, 9};

    //     int activities[][] = new int[start.length][3];
    //     for(int i=0; i<start.length; i++) {
    //         activities[i][0] = i;
    //         activities[i][1] = start[i];
    //         activities[i][2] = end[i];
    //     }

    //     //lambda function -> shortform
    //     Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
    //     Arrays.sort(intervals, (a, b) -> Integer.compare(a[2], b[2]));

    //     //end time basis sorted
    //     int maxAct = 0;
    //     ArrayList<Integer> ans = new ArrayList<>();

    //     //1st activity
    //     maxAct = 1;
    //     ans.add(activities[0][0]);
    //     int lastEnd = activities[0][2];
    //     for(int i=1; i<end.length; i++) {
    //         if(activities[i][1] >= lastEnd) {
    //             //activity select
    //             maxAct++;
    //             ans.add(activities[i][0]);
    //             lastEnd = activities[i][2];
    //         }
    //     }

    //     System.out.println("max activities = " + maxAct);
    //     for (int index : ans) {
    //         System.out.print("A" + index + " ");
    //     }
    // }


    // Fractional Knapsack Code
    // public static void main(String[] args) {
    //     int val[] = {60, 100, 120};
    //     int weight[] = {10, 20, 30};
    //     int n = val.length;
    //     int w = 50;
    //     Integer ratio[] = new Integer[val.length];

    //     for(int i=0; i<n; i++) {
    //         ratio[i] = val[i]/weight[i];
    //     }
    //     Arrays.sort(ratio, Collections.reverseOrder());

    //     for(int i=n-1; i>=0; i--) {
    //     }
    // }


    // Minimum Sum Absolute Difference Pairs
    // public static void main(String[] args) {
    //     int A[] = {4, 1, 8, 7};
    //     int B[] = {2, 3, 6, 5};

    //     Arrays.sort(A);
    //     Arrays.sort(B);

    //     int minDiff = 0;

    //     for(int i=0; i<A.length; i++) {
    //         minDiff += Math.abs(A[i]-B[i]);
    //     }
    //     System.out.println("min absolute diff of pairs = " + minDiff);
    // }


    // Maximum Length Chain of Pairs
    // public static void main(String[] args) {
    //     int pairs[][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};

    //     Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

    //     int chainLen = 1;
    //     int chainEnd = pairs[0][1];

    //     for(int i=1; i<pairs.length; i++) {
    //         if(pairs[i][0] > chainEnd) {
    //             chainLen++;
    //             chainEnd = pairs[i][1];
    //         }
    //     }
        
    //     System.out.println("max length of chain = " + chainLen);
    // }


    // public String largestNumber(int[] nums) {
    //     //convert int to string array 
    //     String strNums[] = new String[nums.length];
    //     for(int i=0; i<nums.length; i++) {
    //         strNums[i] = String.valueOf(nums[i]);
    //     }
    //     //sort strNums by lastDigit of every number
    //     Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

    //     //corner case
    //     if(strNums[0].equals("0")) {
    //         return "0";
    //     }
    //     //combine into single string
    //     StringBuilder sb = new StringBuilder();
    //     for(String val : strNums) {
    //         sb.append(val);
    //     }

    //     return sb.toString();
    // }
    

    // Indian Coins
    public static void main(String[] args) {
        Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        Arrays.sort(coins, Collections.reverseOrder());

        int amount = 590;
        int count = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<coins.length; i++) {
            if(coins[i] <= amount) {
                while (coins[i] <= amount) {
                    count++;
                    ans.add(coins[i]);
                    amount -= coins[i];
                }
            }
        }
        System.out.println("Total num of coins/notes are " + count);
        for (int val : ans) {
            System.out.print(val + " ");
        }
    }
}
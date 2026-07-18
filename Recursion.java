public class Recursion {
    public static void printDec(int n) {
        if(n == 1) {
            System.out.println(n);
            return;
        }
        System.out.print(n+" ");
        printDec(n-1);
    }

    public static void printInc(int n) {
        if(n == 1) {
            System.out.print(n+" ");
            return;
        }
        printInc(n-1);
        System.out.print(n+" ");
    }

    public static int fact(int n) {
        if (n == 0) {
            return 1;
        }
        return (n * fact(n-1));
    }

    public static int fibonacci(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        return (fibonacci(n-1) + fibonacci(n-2));
    }

    public static boolean isSorted(int arr[], int i) {
        if(i == arr.length-1) {
            return true;
        }
        if(arr[i] > arr[i+1]) {
            return false;
        }
        return isSorted(arr, i+1);
    }

    public static int firstOccur(int arr[], int i, int key) {
        if(i == arr.length) {
            return -1;
        }
        if(arr[i] == key) {
            return i;
        }
        return firstOccur(arr, i+1, key);
    }

    public static int lastOccur(int arr[], int i, int key) {
        if(i == arr.length) {
            return -1;
        }
        int isFound = lastOccur(arr, i+1, key);
        if(isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }

    public static int tiling(int n) { //2 x n (floor size)
        //base case
        if(n == 0 || n == 1) {
            return 1;
        }
        //vertical choice
        int fnm1 = tiling(n-1);
        //horizontal choice
        int fnm2 = tiling(n-2);

        int totWays = fnm1 + fnm2;
        return totWays;
    }

    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {
        if(idx == str.length()) {
            System.out.println(newStr);
            return;
        }

        int currIdx = str.charAt(idx) - 'a';
        if(map[currIdx] != true) {
            newStr.append(str.charAt(idx));
            map[currIdx] = true;
        }
        removeDuplicates(str, idx+1, newStr, map);
    }

    public static int friendsPair(int n) {
        if(n == 1 || n == 2) {
            return n;
        }
        return friendsPair(n-1) + (n-1) * friendsPair(n-2);
    }

    public static void printBinStrings(int n, int lastPlace, String str) {
        //baseCase
        if(n == 0) {
            System.out.println(str);
            return;
        }
        //kaam
        printBinStrings(n-1, 0, str+"0");
        if(lastPlace == 0) {
            printBinStrings(n-1, 1, str+"1");
        }
    }

    public static void printBinStrings2(int n, int lastPlace, StringBuilder str) {
        //baseCase
        if(n == 0) {
            System.out.println(str.toString());
            return;
        }
        //kaam
        printBinStrings2(n-1, 0, str.append(0));
        str.deleteCharAt(str.length()-1);
        if(lastPlace == 0) {
            printBinStrings2(n-1, 1, str.append(1));
            str.deleteCharAt(str.length()-1);
        }
    }

    public static void allOccur(int arr[], int i, int key) {
        if(i == arr.length) {
            return;
        }
        if(arr[i] == key) {
            System.out.println(i);
        }
        allOccur(arr, i+1, key);
    }

    static String digits[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public static void printDigit(int num) {
        if(num == 0) return;
        int ld = num % 10;
        printDigit(num / 10);
        System.out.print(digits[ld]+" ");
    }

    public static int length(String str) {
        if(str.length() == 0) return 0;
        return length(str.substring(1)) + 1;
    }
    public static void main(String[] args) {
        // printDec(10);
        // printInc(10);
        // System.out.println(fact(5));
        // System.out.println(fibonacci(5));
        // int[] arr = {2, 3, 4, 5};
        // System.out.println(isSorted(arr, 0));
        // int[] arr = {6, 8, 4, 5, 3, 9, 5, 1, 7};
        // System.out.println(firstOccur(arr, 0, 5));
        // System.out.println(lastOccur(arr, 0, 5));

        // String str = "appnacollege";
        // boolean map[] = new boolean[26];
        // StringBuilder newStr = new StringBuilder();
        // removeDuplicates(str, 0, newStr, map);

        // System.out.println(friendsPair(3));
        // printBinStrings(3, 0, "");
        // printBinStrings2(3, 0, new StringBuilder());

        // allOccur(arr, 0, 5);
        // System.out.println(length("abcdef"));
        // printDigit(2019);
    }
}

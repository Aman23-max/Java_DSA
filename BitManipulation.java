public class BitManipulation {
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }

    public static boolean isPowerOfThree(int n) {
        return n > 0 && Math.pow(3, 19) % n == 0;
    }

    public static int setBits(int n) {
        int count = 0;
        while(n > 0) {
            if((n & 1) != 0) {
                count++;
            }
            n = n>>1;
        }
        return count;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int countPrimeSetBits(int left, int right) {
        int count = 0;
        for(int i=left; i<=right; i++) {
            if(isPrime(Integer.bitCount(i))) {
                count++;
            }
        }
        return count;
    }

    // Brian Kernighan's Algorithm (Most Elegant)
    public int rangeBitwiseAnd(int left, int right) {
        while (right > left) {
            right = right & (right - 1); // Clears the lowest set bit of 1
        }
        return right;
    }

    public static void main(String args[]) {
        // System.out.print(isPowerOfTwo(0));
        // System.out.print(isPowerOfThree(27));
        // System.out.print(setBits(2147483645));
        // System.out.print(countPrimeSetBits(6, 10));
        // int digits = (int) Math.log10(509354546) + 1;
        // System.out.println(digits);
        // System.out.println(Integer.bitCount(7));
    }
}
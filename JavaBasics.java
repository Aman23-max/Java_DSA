public class JavaBasics {
    public static void avg(int a, int b, int c) {
        int average = (a+b+c)/3;
        System.out.println(average);
    }

    public static boolean isEven(int n) {
        if(n % 2 == 0) {
            return true;
        }
        return false;
    }

    public static void palindrome(int n) {
        int myNum = n;
        int rev = 0;

        while(n > 0) {
            int lastDigit = n % 10;
            rev = (rev * 10) + lastDigit;
            n = n / 10;
        }
        if(rev == myNum) {
            System.out.println(myNum+" is Palindrome");
        } else  {
            System.out.println(myNum+" is not Palindrome");
        }
    }

    public static void sumOfDigits(int n) {
        int sum = 0;

        while(n > 0) {
            int digits = n % 10;
            sum = sum + digits;
            n = n / 10;
        }
        System.out.println(sum);
    }

    public static void binToDec(int bin) {
        int myBin = bin;
        int pow = 0;
        int dec = 0;

        while(bin > 0) {
            int lastDigit = bin % 10;
            dec = dec + (lastDigit * (int)Math.pow(2, pow));
            pow++;
            bin = bin / 10;
        }
        System.out.print("decimal of "+ myBin + " = " + dec);
    }

    public static void decToBin(int dec) {
        int myDec = dec;
        int pow = 0;
        int bin = 0;

        while(dec > 0) {
            int lastDigit = dec % 2;
            bin = bin + (lastDigit * (int)Math.pow(10, pow));
            pow++;
            dec = dec / 2;
        }
        System.out.print("binary of " + myDec + " = " + bin);
    }

    public static void rectangle(int row, int col) {
        //outer loop
        for(int i=1; i<=row; i++) {
            //inner loop
            for(int j=1; j<=col; j++) {
                if(i == 1 || i == row || j == 1 || j == col) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    // public static void half_Pyramid(int n) {
    //     //outer loop
    //     for(int i=1; i<=n; i++) {
    //         //inner loop
    //         for(int j=1; j<=n; j++) {
    //             if((i+j) >= n+1) {
    //                 System.out.print("* ");
    //             } else {
    //                 System.out.print("  ");
    //             }
    //         }
    //         System.out.println();
    //     }
    // }

    public static void half_Pyramid(int n) {
        for(int i=1; i<=n; i++) {
            //spaces
            for(int j=1; j<=n-i; j++) {
                System.out.print("  ");
            }
            //stars
            for(int j=1; j<=i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void floyds_triangle(int n) {
        int counter = 1;
        //outer
        for(int i=1; i<=n; i++) {
            //inner
            for(int j=1; j<=i; j++) {
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }

    public static void binary_triangle(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                if((i+j) % 2 == 0) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    public static void butterFly(int n) {
        for(int i=1; i<=n; i++) {
            //stars
            for(int j=1; j<=i; j++) {
                System.out.print("* ");
            }
            //spaces
            for(int j=1; j<=2*(n-i); j++) {
                System.out.print("  ");
            }
            //stars
            for(int j=1; j<=i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int i=1; i<=n; i++) {
            //stars
            for(int j=1; j<=n-i+1; j++) {
                System.out.print("* ");
            }
            //spaces
            for(int j=1; j<=2*i-2; j++) {
                System.out.print("  ");
            }
            //stars
            for(int j=1; j<=n-i+1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void solid_rhombus(int n) {
        for(int i=1; i<=n; i++) {
            //spaces
            for(int j=1; j<=n-i; j++) {
                System.out.print("  ");
            }
            //stars
            for(int j=1; j<=n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void hollow_rhombus(int n) {
        for(int i=1; i<=n; i++) {
            //spaces
            for(int j=1; j<=n-i; j++) {
                System.out.print("  ");
            }
            //stars
            for(int j=1; j<=n; j++) {
                if(i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void diamond(int n) {
        //1st Half
        for(int i=1; i<=n; i++) {
            //spaces
            for(int j=1; j<=n-i; j++) {
                System.out.print("  ");
            }
            //stars
            for(int j=1; j<=2*i-1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        //2nd Half
        for(int i=n; i>=1; i--) {
            //spaces
            for(int j=1; j<=n-i; j++) {
                System.out.print("  ");
            }
            //stars
            for(int j=1; j<=2*i-1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void num_Pyramid(int n) {
        int counter = 1;
        for(int i=1; i<=n; i++) {
            //spaces
            for(int j=1; j<=n-i; j++) {
                System.out.print("  ");
            }
            //numbers
            for(int j=1; j<=i; j++) {
                System.out.print(counter+"   ");
            }
            counter++;
            System.out.println();
        }
    }

    public static void palindromWithNum(int n) {
        for(int i=1; i<=n; i++) {
            // 1. Print leading spaces for alignment
            for(int j=1; j<=n-i; j++) {
                System.out.print("  ");
            }
            
            // 2. Print descending numbers from 'i' to 1
            for (int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }

            // 3. Print ascending numbers from 2 to 'i'
            for (int j = 2; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main() {
        // avg(5,6,9);
        // System.out.println(isEven(13));
        // palindrome(121);
        // sumOfDigits(10899);
        // binToDec(1111111111);
        // decToBin(1023);
        // rectangle(4,5);
        // half_Pyramid(5);
        // floyds_triangle(4);
        // binary_triangle(5);
        // butterFly(4);
        // solid_rhombus(6);
        // hollow_rhombus(5);
        // diamond(5);
        // num_Pyramid(5);
        // palindromWithNum(5);
    }
}
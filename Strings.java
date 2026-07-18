// import java.util.Scanner;

import java.util.HashSet;

public class Strings {
    public static boolean isPalindrome(String str) {
        for(int i=0; i<str.length()/2; i++) {
            if(str.charAt(i) != str.charAt(str.length()-1-i)) {
                return false;
            }
        }
        return true;
    }

    public static int getShortestPath(String path) {
        int x = 0, y = 0;
        for(int i=0; i<path.length(); i++) {
            char dir = path.charAt(i);
            if(dir == 'E') x++;
            else if(dir == 'W') x--;
            else if(dir == 'N') y++;
            else y--;
        }
        return (int)Math.sqrt(x*x + y*y);
    }

    public static boolean isShortest(String path) {
        int x = 0, y = 0;
        HashSet<String> set = new HashSet<>();
        set.add(x + "," + y);

        for(int i=0; i<path.length(); i++) {
            char dir = path.charAt(i);
            if(dir == 'E') x++;
            else if(dir == 'W') x--;
            else if(dir == 'N') y++;
            else y--;

            if(!set.add(x + "," + y)) {
                return true;
            }
        }
        return false;
    }

    public static String subString(String str) {
        int longest = -1;
        for(int i=0; i<str.length(); i++) {
            for(int j=i+1; j<=str.length(); j++) {
                int subNum = Integer.parseInt(str.substring(i, j));
                if(subNum % 2 != 0) {
                    longest = Math.max(longest, subNum);
                }
            }
        }
        return longest == -1 ? "" : String.valueOf(longest);
    }

    public static String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

    public static String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder("");
        sb.append(Character.toUpperCase(str.charAt(0)));

        for(int i=1; i<str.length(); i++) {
            if(str.charAt(i) == ' ' && i < str.length()-1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(Character.toLowerCase(str.charAt(i)));
            }
        }
        return sb.toString();
    }

    public static String compress(String str) {
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<str.length(); i++) {
            Integer count = 1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if(count > 1) {
                sb.append(count.toString());
            }
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        // String str = "Hello";
        // String str2 = new String("xyz");
        // System.out.println(str + " " + str2);

        // Scanner sc = new Scanner(System.in);
        // String name = sc.nextLine();
        // System.out.println(name);

        // String firstName = "Tony";
        // String lastName = "Stark";
        // String fullName = firstName + " " + lastName;
        // System.out.println(fullName.length());
        // System.out.println(fullName.charAt(1));

        // System.out.println(isPalindrome("noon"));
        // System.out.println(getShortestPath("WNEENESENNN"));

        // String s1 = "Tony";
        // String s2 = "Tony";
        // String s3 = new String("Tony");

        // if(s1 == s2) System.out.println("String are equal");
        // else System.out.println("String are not equal");

        // if(s1 == s3.intern()) System.out.println("String are equal");
        // else System.out.println("String are not equal");
        
        // if(s1.equals(s3)) System.out.println("String are equal");
        // else System.out.println("String are not equal");

        // System.out.println(subString("52"));
        // System.out.println(largestOddNumber("52"));

        // StringBuilder sb = new StringBuilder("");
        // for(char ch='a'; ch<='z'; ch++) {
        //     sb.append(ch);
        // }
        // System.err.println(sb.toString());

        // System.err.println(toUpperCase("i Love leetCodE"));
        // System.err.println(compress("aaabbcccd"));

        // String str = "Hello";
        // str.toLowerCase();
        // System.out.println(str);
    }
}

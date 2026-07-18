// import java.util.Arrays;

public class Backtracking {
    public static void changeArr(int arr[], int i, int val) {
        if(i == arr.length) return;

        arr[i] = val;
        changeArr(arr, i+1, val+1);
        arr[i] = arr[i] - 2;
    }

    public static void findSubsets(String str, String ans, int i) {
        //base case
        if(i == str.length()) {
            if(ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }
        //Yes choice
        findSubsets(str, ans+str.charAt(i), i+1);
        //No choice
        findSubsets(str, ans, i+1);
    }

    public static void findPermutation(String str, String ans) {
        //base case
        if(str.length() == 0) {
            System.out.println(ans);
            return;
        }
        //recursion - O(n * n!)
        for(int i=0; i<str.length(); i++) {
            char curr = str.charAt(i);
            //"abcde" => "ab" + "de" = "abde"
            String NewStr = str.substring(0, i) + str.substring(i+1);
            findPermutation(NewStr, ans+curr);
        }
    }

    //N-Queens
    public static boolean isSafe(char board[][], int row, int col) {
        //vertical-top
        for(int i=row-1; i>=0; i--) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }
        //left-top
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
        //right-top
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void nQueens(char board[][], int row) {
        //base case
        if(row == board.length) {
            printBoard(board);
            count++;
            return;
        }
        //column loop
        for(int j=0; j<board.length; j++) {
            if(isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row+1); //function call
                board[row][j] = 'x'; //backtracking step
            }
        }

    }

    static int count = 0;

    public static void printBoard(char board[][]) {
        System.out.println("-------- chess board --------");
        for (char[] row : board) {
            for (char element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static int gridWays(int i, int j, int n, int m) {
        //base case
        if(i == n-1 && j == m-1) {  //condn for last cell
            return 1;
        } else if(i == n || j == m) {  //boundry cross condn
            return 0;
        }

        int w1 = gridWays(i+1, j, n, m);
        int w2 = gridWays(i, j+1, n, m);
        return w1 + w2;
    }

    //Sudoku-Solver
    public static boolean isSafeSudoku(int sudoku[][], int row, int col, int digit) {
        //column
        for(int i=0; i<=8; i++) {
            if(sudoku[i][col] == digit) {
                return false;
            }
        }
        //row
        for(int j=0; j<=8; j++) {
            if(sudoku[row][j] == digit) {
                return false;
            }
        }
        //grid
        int sr = (row/3) * 3;
        int sc = (col/3) * 3;
        //3*3 grid
        for(int i=sr; i<sr+3; i++) {
            for(int j=sc; j<sc+3; j++) {
                if(sudoku[i][j] == digit) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        //base case
        if(row == 9) {
            return true;
        }
        //recursion
        int nextRow = row, nextCol = col+1;
        if(col+1 == 9) {
            nextRow = row+1;
            nextCol = 0;
        }

        if(sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        for(int digit=1; digit<=9; digit++) {
            if(isSafeSudoku(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if(sudokuSolver(sudoku, nextRow, nextCol)) {
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }

        return false;
    }

    public static void printSudoku(int sudoku[][]) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // int[] arr = new int[5];
        // changeArr(arr, 0, 1);
        // System.out.println(Arrays.toString(arr));

        // String str = "abc";
        // findSubsets(str, "", 0);

        // String str = "abc";
        // findPermutation(str, "");

        // int n = 4;
        // char board[][] = new char[n][n];
        // for (int i=0; i<n; i++) {
        //     for (int j=0; j<n; j++) {
        //         board[i][j] = 'x';
        //     }
        // }
        // nQueens(board, 0);
        // System.out.println("total ways to solve n queens = " + count);

        // int n = 3, m = 3;
        // System.out.println(gridWays(0, 0, n, m));

        // int sudoku[][] = {
        //     {0, 0, 8, 0, 0, 0, 0, 0, 0},
        //     {4, 9, 0, 1, 5, 7, 0, 0, 2},
        //     {0, 0, 3, 0, 0, 4, 1, 9, 0},
        //     {1, 8, 5, 0, 6, 0, 0, 2, 0},
        //     {0, 0, 0, 0, 2, 0, 0, 6, 0},
        //     {9, 6, 0, 4, 0, 5, 3, 0, 0},
        //     {0, 3, 0, 0, 7, 2, 0, 0, 4},
        //     {0, 4, 9, 0, 3, 0, 0, 5, 7},
        //     {8, 2, 7, 0, 0, 9, 0, 1, 3},
        // };

        // if(sudokuSolver(sudoku, 0, 0)) {
        //     System.out.println("Solution exists");
        //     printSudoku(sudoku);
        // } else {
        //     System.out.println("Solution does not exists");
        // }
    }
}

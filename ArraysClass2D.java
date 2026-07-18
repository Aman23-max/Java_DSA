public class ArraysClass2D {
    public static boolean searchMatrix(int matrix[][], int target) {
        int startRow = 0, startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;

        while(startRow <= endRow && endCol >= startCol) {
            if(target == matrix[startRow][endCol]) {
                return true;
            } else if(target < matrix[startRow][endCol]) {
                endCol--;
            } else {
                startRow++;
            }
        }
        return false;
    }

    public static void spiralMatrix(int matrix[][]) {
        int startRow = 0, startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;

        while(startRow <= endRow && startCol <= endCol) {
            //top
            for(int j=startCol; j<=endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }
            //right
            for(int i=startRow+1; i<=endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }
            //bottom
            for(int j=endCol-1; j>=startCol; j--) {
                if(startRow == endRow) {
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");
            }
            //left
            for(int i=endRow-1; i>=startRow+1; i--) {
                if(startCol == endCol) {
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");
            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
    }

    public static int[][] generateMatrix(int n) {
        int matrix[][] = new int[n][n];
        int element = 1;

        int startRow = 0, startCol = 0;
        int endRow = n-1, endCol = n-1;

        while(startRow <= endRow && startCol <= endCol) {
            //top
            for(int j=startCol; j<=endCol; j++) {
                matrix[startRow][j] = element;
                element++;
            }
            //right
            for(int i=startRow+1; i<=endRow; i++) {
                matrix[i][endCol] = element;
                element++;
            }
            //bottom
            for(int j=endCol-1; j>=startCol; j--) {
                if(startRow == endRow) break;
                matrix[endRow][j] = element;
                element++;
            }
            //left
            for(int i=endRow-1; i>=startRow+1; i--) {
                if(startCol == endCol) break;
                matrix[i][startCol] = element;
                element++;
            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        return matrix;
    }

    public static int[][] transpose(int arr[][]) {
        int row = arr.length, col = arr[0].length;
        // printMat(arr);

        int trans[][] = new int[col][row];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                trans[j][i] = arr[i][j];
            }
        }

        // printMat(trans);
        return trans;
    }

    public static void printMat(int arr[][]) {
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] arr) {
        int row = arr.length, col = arr[0].length;
        boolean[] rowMarker = new boolean[row];
        boolean[] colMarker = new boolean[col];

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(arr[i][j] == 0) {
                    rowMarker[i] = true;
                    colMarker[j] = true;
                }
            }
        }

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(rowMarker[i] || colMarker[j]) {
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void main(String args[]) {
        // int target = 3;
        // int matrix[][] = {  {1, 3, 5, 7},
        //                     {10, 11, 16, 20},
        //                     {23, 30, 34, 60} };
        // System.out.println(searchMatrix(matrix, target));
        // spiralMatrix(matrix);
        // int n = 4;
        // int matrix[][] = generateMatrix(n);
        // for(int i=0; i<matrix.length; i++) {
        //     for(int j=0; j<matrix[i].length; j++) {
        //         System.out.print(matrix[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // System.out.print(transpose(matrix));
        // printMat(transpose(matrix));

        // int matrix[][] = {  {1, 1, 1},
        //                     {1, 0, 1},
        //                     {1, 1, 1}};
        // setZeroes(matrix);
        // printMat(matrix);
    }
}
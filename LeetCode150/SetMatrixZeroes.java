package LeetCode150;
//73. Set Matrix Zeroes
//
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] arr = { {0,1,9,0},{2,4,8,1},{3,3,0,7},{5,4,1,6} };
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("-----------------------");
        setZeroes(arr);
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void setZeroes(int[][] matrix) {
        boolean firstRow = false,firstCol = false;
        for (int i = 0; i < matrix.length ; i++)
            for (int j = 0; j <matrix[i].length ; j++)
                if (matrix[i][j] ==0){
                    if (i == 0) firstRow = true;
                    if (j == 0) firstCol = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
        for (int i = 1; i < matrix.length ; i++) {
            for (int j = 1; j <matrix[i].length ; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstRow)
            for (int i = 0; i <matrix[0].length ; i++) {
                matrix[0][i]  = 0;

            }
        if (firstCol)
            for (int i = 0; i < matrix.length ; i++) {
                matrix[i][0] = 0;
            }

    }
}

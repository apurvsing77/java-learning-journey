package LeetCode150;
//48. Rotate Image
//
public class RotedMatrix {
    public static void main(String[] args) {
    int[][] arr = { {5,1,9,11},{2,4,8,10},{13,3,6,7},{5,14,12,16} };
    rotate(arr);
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void rotate(int[][] matrix) {
   int n = matrix.length;
        for (int i = 0; i <(n+1)/2 ; i++) {
            for (int j = 0; j <n/2 ; j++) {
                //temp = down left
                int temp= matrix[n-1-j][i];
                //down left = down right
                matrix[n-1-j][i] = matrix[n-1-i][n-j-1];
                //down right = top right
                matrix[n-1-i][n-j-1] = matrix[j][n-1-i];
                //top right = top left
                matrix[j][n-1-i] = matrix[i][j];
                //top left = temp
                matrix[i][j] = temp;
            }
        }
    }
}

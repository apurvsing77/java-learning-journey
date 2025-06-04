package LeetCode150;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
    int[][] matrix ={
            {1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int rowbegin=0,rowend = matrix.length-1,colbegin = 0,colend = matrix[0].length-1;
       List<Integer> list = new ArrayList<>();
        while(rowbegin <= rowend && colbegin <= colend){
           //Traverse L to R
            for(int i =rowbegin; i<= colend ; i++){
                list.add(matrix[rowbegin][i]);

            }
            rowbegin++;
            // Traverse R to D
            for (int i = rowbegin; i <= rowend ; i++) {
              list.add(matrix[i][colend]);

            }
            colend--;
            if (rowbegin<=rowend) {
                for (int i = colend; i >= colbegin; i--) {
                    list.add(matrix[rowend][i]);

                }
                rowend--;
            }
            if (colbegin <= colend){
                for (int i = rowend; i >= rowbegin ; i--) {
                    list.add(matrix[i][colbegin]);

                }
                colbegin++;
            }
        }
        return list;
    }
}

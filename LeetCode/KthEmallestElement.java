package LeetCode;

import java.util.Collections;
import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
//378. 7th smallest element in a sorted matrix
public class KthEmallestElement {
    public static void main(String[] args) {
    int[][] matrix ={
            {1,5,9},
            {10,11,13},
            {12,13,15}
    };
        System.out.println(kthSmallest(matrix,8));
    }
    static PriorityQueue<Integer> kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int m = matrix.length;
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <m ; j++) {
                if (pq.size()<k) pq.add(matrix[i][j]);
                else {
                    if (pq.peek() > matrix[i][j]) {
                        pq.poll();
                        pq.add(matrix[i][j]);

                    }
                }
            }
        }
        return pq;
    }
    static int kthSmallest2(int[][] matrix, int k) {
       int m = matrix.length,n = matrix[0].length, ans = -1;
       int low = matrix[0][0] , high =matrix[m-1][n-1];
       while (low <= high){
           int mid = low + (high-low) / 2;
           if (lessElement(matrix,mid) < k){
               low = mid +1;

           }else {
               ans = mid;
               high = mid -1;
           }
       }
return  ans;
    }
        static  int lessElement(int[][] matrix , int x){
        int m = matrix.length , n = matrix[0].length , count = 0 ;
            for (int i = 0; i <m ; i++) {
                int j = n-1;
                while (j >= 0 && matrix[i][j] > x) {
                    j--;

                }
                count = count + j + 1;
            }
return count;
        }

    }



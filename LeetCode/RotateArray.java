package LeetCode;
//189. Rotate Array

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {2147483647, -2147483648, 33, 219, 0};
        rotate(nums, 4);
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int r = nums.length;
//       int i = 0;
//       while (i<=r){
//           int temp = nums[i];
//           nums[i] = nums[r];
//           nums[r] = temp;
//           i++;
//           r--;
//       }
//        System.out.println(Arrays.toString(nums));
//       i=0;
//       int lk =k-1;
//       while (i<k-1){
//           int temp = nums[i];
//           nums[i] = nums[lk];
//           nums[lk] = temp;
//           lk--;
//           i++;
//       }
//        System.out.println(Arrays.toString(nums));
//       i=k;
//        r = nums.length - 1;
//       while(i<=r){
//           int temp = nums[i];
//           nums[i] = nums[r];
//           nums[r] = temp;
//           r--;
//           i++;
//       }
//            System.out.println(Arrays.toString(nums));
        reverce(nums,0,r-1);
        reverce(nums,0,k-1);
        reverce(nums,k,r-1);
        System.out.println(Arrays.toString(nums));


    }

        public static  void reverce (int[] nums, int start, int end ){
           while (start<end){
               int temp = nums[start];
               nums[start] = nums[end];
               nums[end] = temp;
               start++;
               end--;
           }
        }

}

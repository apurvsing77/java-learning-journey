
/*
Input: nums = [1,2,3,4,5,6,7], k = 3 => [7,6,5,4,3,2,1]
Output: [5,6,7,1,2,3,4]
* */

package Leetcode150Part2;

public class RoteteArray2 {
    public static void main(String[] args){
//     int[] nums = {1,2,3,4,5,6,7};
        int[] nums = {1,2};
     rotate(nums,7);
     for(int i = 0; i <nums.length ; i++) {
      System.out.print(nums[i]+",");
     }
    }
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        //First rotate entire Array
        rotateArray(nums,0,nums.length-1);

        //Now Rotate array till k-1
        rotateArray(nums,0,k-1);
        rotateArray(nums,k,nums.length-1);
    }
    public static void rotateArray(int[] nums , int start, int end){

        while(start < end){

        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
        }
    }
}

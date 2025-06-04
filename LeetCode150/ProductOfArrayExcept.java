package LeetCode150;
//238. Product of Array Except Self
//


import java.util.Arrays;

public class ProductOfArrayExcept {
    public static void main(String[] args) {
    int[] arr = {3,4,6,1,2};
        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }
    public static int[] productExceptSelf(int[] nums) {
          int[] left = new int[nums.length];
          int[] rigt = new  int[nums.length];
        int product =1;
        for (int i = 0; i < nums.length ; i++) {
            if (i == 0){
                left[i] = 1;
            }else {
                product = product * nums[i-1];
                left[i] = product;
            }
        }
        product = 1;
        for (int i = nums.length-1; i >=0 ; i--) {
            if (i == nums.length-1){
                rigt[i] =1;
            }else {
                product = product * nums[i+1];
                rigt[i] = product;
            }
        }
        for (int i = 0; i < nums.length ; i++) {
            nums[i] = left[i] * rigt[i];
        }

return nums;
    }
}

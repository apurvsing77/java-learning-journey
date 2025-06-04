package LeetCode;
//80. Remove Duplicates from Sorted Array II

import java.util.Arrays;

public class RemoveDuplicatesII {
    public static void main(String[] args) {
    int[] nums ={1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));

    }
    public static int removeDuplicates(int[] nums) {

        int i=0;
        for (int n:nums ) {
            if (i<2 || n != nums[i-2] )
               nums[i++] = n;

        }
        System.out.println(Arrays.toString(nums));
        return i;
    }
}

package LeetCode;
//Find First and Last Position of Element in Sorted Array
        // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
import java.util.Arrays;

public class FirstAndLastPosition {
    public static void main(String[] args) {
        //int[] arr = {5, 7, 7, 8, 8, 10};
        int[] arr = {1,2,8,8,8,8,8,10,11};
//        int[] arr = {1};
        System.out.println(Arrays.toString(searchRange(arr , 8)));
    }

    static int[] searchRange(int[] nums, int target) {
        int left = findLeft(nums, target);
        int right = findRight(nums, target);
        return new int[]{left, right};
    }

    static int findLeft(int[] nums, int target){
        int index=-1;
        int low = 0;
        int high = nums.length-1;

        while ( low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target){
                index = mid;
               high = mid-1;

            }else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }
    static int findRight(int[] nums, int target){
        int index=-1;
        int low = 0;
        int high = nums.length-1;

        while ( low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target){
                index = mid;
                low = mid + 1;

            }else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }

}
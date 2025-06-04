package LeetCode;
//35. Search Insert Position
//https://leetcode.com/problems/search-insert-position/submissions/1193556527/

public class SearchInsertPosition {
    public static void main(String[] args) {
    int[] num ={1,3,5,6};
        System.out.println(searchInsert(num,5));
    }
    static int searchInsert(int[] nums, int target) {
     int low =0;
     int high = nums.length-1;
     while (low <= high){
         int mid = low + (high - low)/2;
         if (nums[mid] == target){
             return mid;
         } else if (target > nums[mid]) {
             low = mid + 1;
         }else {
             high = mid - 1;
         }

     }
     return low;
    }
}

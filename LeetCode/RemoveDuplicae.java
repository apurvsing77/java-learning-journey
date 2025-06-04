package LeetCode;
//26. Remove Duplicates from Sorted Array
//https://leetcode.com/problemset/?page=1&sorting=W3sic29ydE9yZGVyIjoiQVNDRU5ESU5HIiwib3JkZXJCeSI6IkZST05URU5EX0lEIn1d&difficulty=EASY

public class RemoveDuplicae {
    public static void main(String[] args) {
int[] arr ={1,1,1,2,3,3,4,5,5,6};
        System.out.println(removeDuplicates(arr));
    }
    static int removeDuplicates(int[] nums) {

      int rd=0;

        for (int i = 1; i < nums.length ; i++) {
           if (nums[i] != nums[rd] ) {
               rd++;
               nums[rd] = nums[i];
           }
        }
        return rd+1;
    }
}

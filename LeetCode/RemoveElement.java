package LeetCode;
//27. Remove Element
//https://leetcode.com/problems/remove-element/submissions/
public class RemoveElement {
    public static void main(String[] args) {
int[]  arr = {0,1,2,2,3,0,4,2};
int len = removeDuplicates(arr,2);
        System.out.println(len);
        for (int i = 0; i <len ; i++) {
            System.out.print(arr[i]+",");
        }


    }
    static int removeDuplicates(int[] nums ,int val) {

        int rd=0;

        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] != val ) {

                nums[rd] = nums[i];
                rd++;
            }
        }
        return rd;
    }

}

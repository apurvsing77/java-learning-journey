package LeetCode150;
//55. Jump Game
//


public class JumpGame {
    public static void main(String[] args) {
    int[] arr ={1,1,2,5,2,1,0,0,1,3};
    int[] arr1 ={0};
        System.out.println(canJump(arr1));
    }
    public static boolean canJump(int[] nums) {
     int len = nums.length - 1;

        for (int indx = nums.length - 2; indx >= 0; indx--) {
            if (indx + nums[indx] >= len){
                len = indx;
            }

        }
        return len == 0;
    }


}

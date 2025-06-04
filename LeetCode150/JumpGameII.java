package LeetCode150;
//45.Jump Game II
//

public class JumpGameII {
    public static void main(String[] args) {
        int[] arr ={1,1,2,5,2,1,0,0,1,3};
        int[] arr1 ={1,2};
        System.out.println(canJump(arr1));

    }
    public static int  canJump(int[] nums) {
        int len = nums.length - 1;
        int count =0;
        int coveres =0, lastjump = 0;
        if (len == 1) return 0;

        for (int i = 0; i <len ; i++) {
            coveres = Math.max(coveres , i + nums[i]);
            if (i == lastjump) {
                lastjump = coveres;
                count++;

                if (coveres >= len){
                    return count;
                }
            }
        }
      return  count;
    }
}

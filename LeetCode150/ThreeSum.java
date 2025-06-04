package LeetCode150;

import java.util.*;

//15. 3Sum
public class ThreeSum {
    public static void main(String[] args) {
    int[] arr = {-1,0,1,2,-1,-4};
        System.out.println(Arrays.toString(new List[]{threeSum(arr)}));
    }
    public static  List<List<Integer>> threeSum(int[] nums ) {
        if (nums == null || nums.length < 3) return  new ArrayList<>();
        Arrays.sort(nums);
        Set<List<Integer>> ll = new HashSet<>();
        int fixedpoint ,start,last;
        for (int i = 0; i < nums.length ; i++) {
            fixedpoint =i;
            start = fixedpoint+1;
            last = nums.length-1;
            while (start < last){
                int sum = nums[fixedpoint] + nums[start] + nums[last];
                if (sum == 0) {
                  ll.add(Arrays.asList(nums[fixedpoint] , nums[start] , nums[last]));
                  start++;
                  last--;
                }else {
                    if (sum > 0){
                        last--;
                    }else {
                        start++;
                    }
                }
            }
        }
        return new ArrayList<>(ll);
    }
}

package LeetCode150;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//167. Two Sum II
public class TwoSumIISortedArray {
    public static void main(String[] args) {
    int[] arr = {2,7,11,15};
    int target =9;
        System.out.println(Arrays.toString(twoSum2(arr,target)));
    }
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map =new HashMap<>();
        for (int i = 0; i < numbers.length ; i++) {
            map.put(numbers[i],i);
        }
        for (int i = 0; i < numbers.length ; i++) {
            if (map.containsKey(target-numbers[i]) && map.get(target-numbers[i]) != i){
                return new int[]{i+1,map.get(target-numbers[i])+1};
            }
        }
        return  new int[]{-1,-1};
    }
    public  static int[] twoSum2(int[] nums , int target){
        int start =0,last = nums.length - 1;
        while (start < last){
            if (nums[start] +nums[last] == target) return new int[]{start + 1,last + 1};

            if (nums[start] +nums[last] > target){
                last--;
            }else {
                start++;
            }
        }
        return new  int[]{-1,-1};
    }
}

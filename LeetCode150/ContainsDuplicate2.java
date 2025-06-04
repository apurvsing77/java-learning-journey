package LeetCode150;

import java.util.HashMap;
import java.util.Map;

//219. Contains Duplicate II
public class ContainsDuplicate2 {
    public static void main(String[] args) {
   int[] arr = {1,0,1,1};
        System.out.println(containsNearbyDuplicate(arr,1));
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i],i );
            }else {
                if (Math.abs(map.get(nums[i])-i) <= k){
                    return true;
                }else {
                    map.put(nums[i], i);
                }
            }
        }

return false;
    }
}

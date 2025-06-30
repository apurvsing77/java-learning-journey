package LeetCode150;
//169. Majority Element
//

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
    int[] num = {3,2,3};
        System.out.println(majorityElement(num));
    }
    public static int majorityElement(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

        }


        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (freq > nums.length/2)
                return key;
        }
return 0;
    }
}

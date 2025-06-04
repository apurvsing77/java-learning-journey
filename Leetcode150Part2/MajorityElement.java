package Leetcode150Part2;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
    int[] nums = {2,2,1,1,1,2,2};
        System.out.println(findMajority(nums));
    }

    static int findMajority(int[] num){

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < num.length ; i++) {
            map.put(num[i],map.getOrDefault(num[i],0)+1 );
        }
        for (int key: map.keySet()) {
            int freq = map.get(key);
            if (freq > num.length/2)
                return key;
        }
        return 0;
    }
}

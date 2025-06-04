package LeetCode150;
//128. Longest Consecutive Sequence

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
    int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        Map<Integer,Boolean> map = new HashMap<>();
        int longestLength = 0;
        for (int i = 0; i < nums.length ; i++) {
            map.put(nums[i],Boolean.FALSE );
        }
        for (int i = 0; i <nums.length ; i++) {
            int currentlength =1;

            int nextnum = nums[i]+1;
            while (map.containsKey(nextnum) && map.get(nextnum) == false){
                currentlength++;
                map.put(nextnum,Boolean.TRUE );
                nextnum++;
            }
            int prevnum = nums[i]-1;
            while (map.containsKey(nextnum) && map.get(nextnum) == false){
                currentlength++;
                map.put(prevnum,Boolean.TRUE );
                prevnum--;
            }
            longestLength = Math.max(longestLength,currentlength);
        }
        return longestLength;
    }
}

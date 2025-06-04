package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/description/
public class SumTwo {

    public static void main(String[] args) {
        int nums[] = {2,7,11,15};
        int target =9;
        System.out.println(Arrays.toString(checkPosition(nums,target)));
        String str= check(nums,target);
        if (str.equalsIgnoreCase("yes")) {
            System.out.println("Thes elements are available in array whjich sum is 9");

        }else System.out.println("sum of two elements are note available");
    }



    static String check(int num[],int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            map.put(i,num[i]);
        }
        for (int i = 0; i < num.length ; i++) {
            if (map.containsValue(target-num[i])) {
                return "yes";
            }

        }

        return "no";
    }

    static int[] checkPosition(int num[],int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            map.put(num[i],i);
        }
        for (int i = 0; i < num.length ; i++) {
            if (map.containsKey(target-num[i]))
                return new int[] {i,map.get(target-num[i])};


        }
return  new int[] {};
    }
}

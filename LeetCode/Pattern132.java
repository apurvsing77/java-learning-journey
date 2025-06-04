package LeetCode;

import java.util.Stack;

//456. 132 Pattern
//https://leetcode.com/problems/132-pattern/description/
public class Pattern132 {
    public static void main(String[] args) {
    int[] nums = {3,1,6,4};


        System.out.println(find132pattern2(nums));
       // check();
    }
    static boolean find132pattern(int[] nums) {
        int leftMin = nums[0];
            for (int j = 1; j < nums.length-1 ; j++) {

                for (int k = j + 1; k < nums.length ; k++) {
                    if (leftMin < nums[k] && nums[k] < nums[j]) return true;
                }
                leftMin = Math.min(nums[j], leftMin);
            }

        return false;
    }
    static boolean find132pattern2(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for (int i = nums.length-1; i >=0 ; i--) {
            if (nums[i] < min) return true;
            while (!stack.empty() && stack.peek() < nums[i]){

                min = stack.pop();

            }
            stack.push(nums[i]);
        }
        return false;
    }
    static  void check(){
        char ch ='8';

        System.out.println(ch-'1');
    }

    }

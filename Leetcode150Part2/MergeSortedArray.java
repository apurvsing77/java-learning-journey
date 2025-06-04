package Leetcode150Part2;

import java.util.Arrays;

//88. Merge Sorted Array
//https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
//You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
//
//        Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//
//        The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
//
//
//
//        Example 1:
//
//        Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//        Output: [1,2,2,3,5,6]
//        Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//        The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
//        Example 2:
//
//        Input: nums1 = [1], m = 1, nums2 = [], n = 0
//        Output: [1]
//        Explanation: The arrays we are merging are [1] and [].
//        The result of the merge is [1].
//        Example 3:
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] num1={1,2,3,0,0,0};
        int[] num2 = {2,5,6};
        meargrsortarray(num1,3,num2,3);

    }
     public static void meargrsortarray(int[] num1,int m , int[] num2, int n){
        int i= m-1,j=n-1,k= num1.length-1;

        while(j>=0){
            if(i>=0 && num1[i] > num2[j]){
                num1[k] =num1[i];
                i--;
                k--;
            }else {
                num1[k] =num2[j];
                j--;
                k--;
            }
        }
         System.out.println(Arrays.toString(num1));
     }
}

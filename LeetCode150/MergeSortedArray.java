package LeetCode150;

import java.util.Arrays;

//88. Merge Sorted Array
//https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150

public class MergeSortedArray {
    public static void main(String[] args) {
    int[] arr1 ={0};
    int[] arr2 ={1};
    merge(arr1,0,arr2,1);
    }
    static void merge(int[] nums1, int m, int[] nums2, int n) {

       int i = m-1 , j = n-1 , k = nums1.length-1;

       while ( j >= 0){
           if (i >= 0 && nums1[i] > nums2[j] ){
               nums1[k] = nums1[i];
               k--;
               i--;
           }else {
               nums1[k] = nums2[j];
               j--;
               k--;
           }
       }
        System.out.println(Arrays.toString(nums1));

    }
}

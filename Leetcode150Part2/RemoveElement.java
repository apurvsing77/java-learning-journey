package Leetcode150Part2;
//27. Remove Element
//https://leetcode.com/problems/remove-element/submissions/
public class RemoveElement {
    public static void main(String[] args) {
        int[] arr ={3,2,2,3};
        int k = checkDuplicate(arr,3);
        System.out.print("[ ");
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.print("] ");

    }
    public static int checkDuplicate(int[] arr, int val){
        int count =0,i=0;
        while(i <= arr.length-1){
            if (arr[i] != val) {
                arr[count] = arr[i];
                count++;
                i++;
            }else {

                i++;

            }        }
        return count;
    }
}

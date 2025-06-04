package Leetcode150Part2;

public class RotateArray {
    public static void main(String[] args) {
    int[] arr ={1,2,3,4,5,6,7};
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
        rotatearray(arr,3);
        System.out.println();
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    static void rotatearray(int[] arr , int k){
        rotate(arr,0, arr.length-1);
        rotate(arr,0, k-1);
        rotate(arr,k, arr.length-1);
    }
    static  void rotate(int[] arr,int start, int end){
//        for (int i = 0; i <k ; i++) {
//            int temp
//        }
        int i=start,j=end;
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

}

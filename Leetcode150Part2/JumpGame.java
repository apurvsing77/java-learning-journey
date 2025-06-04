package Leetcode150Part2;

public class JumpGame {
    public static void main(String[] args) {
   int[] arr ={2,3,1,1,4 }; //2,3,1,1,4 | 3,2,1,0,4
        System.out.println(jump(arr));
    }
    static  boolean jump(int[] arr){
        int len = arr.length-1;
        int jump=0;
        for (int i = arr.length-2;i >=0 ; i--) {
            if (i+arr[i] >= len) {
                len =i;
                jump++;
            }
        }
        System.out.println("Numbers of jumps is : "+jump);
        return  len ==0;
    }
}

package Leetcode150Part2;

public class JumpGameII {
    public static void main(String[] args) {
        int[] arr ={2,3,1,1,4 }; //2,3,1,1,4 | 3,2,1,0,4
        System.out.println(jump(arr));
    }
    static int jump(int[] arr){
        int len = arr.length-1;
        int cover=0,lastjump=0;
        int total_jumps=0;
        if (len == 1) {
            return 0;
        }
        for (int i = 0; i < arr.length ; i++) {
            cover =Math.max(cover,i+arr[i]);

            if (i == lastjump) {
                lastjump =cover;
                total_jumps++;

            }
            if (cover >= len) {
                return total_jumps;
            }
        }

     return total_jumps;
    }}

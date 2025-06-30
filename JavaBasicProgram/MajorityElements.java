package JavaBasicProgram;

import java.util.Arrays;

public class MajorityElements {
    public static void main(String[] args) {
   int[] arr ={2,2,3,4,4,3,4,4,4};
   int res = chekMajority(arr);
        System.out.println(res);
    }
    static  int chekMajority(int[] arr){
        Arrays.sort(arr);
        int firstPosition=0;
        int lastPosition =0;
        int count =0;
        for (int i = 1; i <arr.length ; i++) {
            lastPosition =i;
            if (arr[i] == arr[i-1]){
                count++;
                if (count > arr.length/2) {
                    System.out.println("count : "+count);
                    return arr[lastPosition];
                }
            }else {
                count =1;
                firstPosition =i;
            }
        }
 return  -1;
    }
}

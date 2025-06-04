package Leetcode150Part2;

public class RemoveDuplicatesSortedArrayII {
    public static void main(String[] args) {
    int[] arr = {1,1,1,2,2,3};
    int k = checkDuplicatet(arr);
        System.out.println(k);
        for (int i = 0; i <k ; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    static int checkDuplicatet(int[] arr){
        int j=0;
        for (int n:arr ) {
            if (j <2 || n !=arr[j-2]) {
                arr[j] = n;
                j++;
            }
        }
        return j;
    }
}

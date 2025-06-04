package Leetcode150Part2;

public class RemoveDuplicateElement {
    public static void main(String[] args) {
        int[] arr ={0,0,1,1,2,2,3,3,4};//0,0,1,1,1,2,2,3,3,4 | 1,2,3,4,5
        int k = checkDuplicate(arr);
        for (int i = 0; i <k ; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    static  int checkDuplicate(int[] arr){
        int count = 0 ,i=1;
        while(i< arr.length){
            if(arr[i] != arr[count]){
                count++;
              arr[count] = arr[i];

              i++;
            }     else {
                i++;
            }   }
    return count+1;
    }}

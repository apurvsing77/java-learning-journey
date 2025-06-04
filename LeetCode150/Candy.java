package LeetCode150;
//135. Candy


public class Candy {
    public static void main(String[] args) {
    int[] arr ={1,2,87,87,87,2,1};
        System.out.println(candy(arr));
    }

    public static int candy(int[] ratings) {
    int[] left = new int[ratings.length];
    int[] right = new int[ratings.length];
        for (int i = 0; i < left.length ; i++) {
            left[i] =1;
        }
        for (int i = 0; i < right.length ; i++) {
            right[i] =1;
        }
        int i=1;
        while (i< ratings.length){
            if (ratings[i] > ratings[i-1]){
                left[i] = left[i-1]+1;
            }
            i++;
        }
        i = ratings.length - 2;
        while (i >=0){
            if (ratings[i] > ratings[i+1]){
                right[i] = right[i+1]+1;
            }
            i--;
        }
        int result=0;
        for (int j = 0; j < ratings.length ; j++) {
            result = result+Math.max(left[j],right[j]);
        }
        return result;
    }
}

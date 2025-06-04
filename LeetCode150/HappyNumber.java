package LeetCode150;

import java.util.HashSet;

//202. Happy Number
public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy2(2));
    }
    public static boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();

        while (true){
            int sum = 0;
            while (n!=0){
                sum += Math.pow(n%10,2.0);
                n= n/10;
            }
            if(sum ==1) return true;

            n= sum;

            if (hashSet.contains(sum)){
                return false;
            }else {
                hashSet.add(sum);
            }
        }
    }

    public static boolean isHappy2(int n) {
        while(n!=1 && n!=4){
            int sum = 0;
            while(n!=0){
                int r = n%10;
                sum += r*r;
                n /= 10;
            }
            n = sum;
        }
        return n==1;
    }
}

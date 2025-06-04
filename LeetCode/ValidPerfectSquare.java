package LeetCode;
//367. Valid Perfect Square
//https://leetcode.com/problems/valid-perfect-square/submissions/1195840565/

public class ValidPerfectSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(808201));
    }

    static boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int low = 1;
        int high = num / 2 + 1;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if ((mid * mid) == num) {
                return true;
            } else if ((mid * mid) > num) {
                high = (int) (mid - 1);
            } else {
                low = (int) (mid + 1);
            }
        }
        return false;

    }
}
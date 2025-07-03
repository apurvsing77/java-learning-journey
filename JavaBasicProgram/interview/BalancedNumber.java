package JavaBasicProgram.interview;

import java.util.Arrays;

/*
Given an odd-digit-number N, you need to find whether the given number is a balanced-number or not.
An odd digit number is called a balanced number if the sum of all digits to the left of the middle digit and the sum of all
digits to the right of the middle digit is equal.
Note: The number of digits of 1234006 is 7, i.e., odd digits.
The middle digit is 4. LHS sum is 1+2+3=6, and RHS sum is 0+0+6=6.


*/
public class BalancedNumber {

		public static void main(String[] args) {
		int number = 1534316;
     boolean res= chekBalance(number);
		 if (res){
				 System.out.println(number+" Number is balanced");
		 }else
				 System.out.println(number+" Number is not balanced");
		}
	static boolean chekBalance(int number){
				String str = Integer.toString(number);
        int[] arr = new int[str.length()];

			for (int i = 0; i <str.length() ; i++) {
					arr[i] = str.charAt(i) - '0';
			}
//			System.out.println(Arrays.toString(arr));
         int mid = (0 + arr.length)/2;
			int leftSum = checkSum(arr,0,mid);
			int rightSum = checkSum(arr,mid+1,arr.length);
			if (leftSum == rightSum)
					return true;
			return  false;
	}
static int checkSum(int[] arr,int start,int end){
				int sum = 0;
		for (int i = start; i <end ; i++) {
				sum = sum + arr[i];
		}
		return sum;
}

}

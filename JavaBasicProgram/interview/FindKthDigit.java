package JavaBasicProgram.interview;

import java.math.BigInteger;

//Given two integer number A and B Find the Kth digit from right of A to the power B
public class FindKthDigit {


    public static void main(String[] args) {
        int a = 4;
        int b= 2 ;
        int k = 3;
   char ch =findKthdigit(a,b,k);
        if (ch =='-'){
            System.out.println(" Invalid Kth position ");
        }else {
            System.out.println("Kth position is: "+ch);
        }
    }

    static char findKthdigit(int a , int b, int k ){
        BigInteger base = BigInteger.valueOf(a);
        BigInteger power =base.pow(b);

        String str = power.toString();
        if (k > str.length()){
            return '-';

        }     else
              return str.charAt(str.length()-k);
    }
}


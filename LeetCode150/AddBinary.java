package LeetCode150;

import java.util.Arrays;

//67. Add Binary
public class AddBinary {
    public static void main(String[] args) {
    String a = "1010";
    String b = "1011";
        System.out.println(addBinary(a,b));
    }
    public static String addBinary(String a, String b) {

        int la =  a.length()-1;
        int lb = b.length()-1;
        StringBuilder sb = new StringBuilder();
        int cary = 0, base =2;
        while (la >= 0 || lb >=0){
            int t1 = 0,t2=0, sum;
            if(la>=0){
                t1 = a.charAt(la--) - '0';
            }
            if(lb>=0){
                t2 = b.charAt(lb--) - '0';
            }
            sum = t2 +t1 + cary;
            if (sum >= base){
                cary=1;
                sum=sum-base;
            }else cary=0;
            sb.append(sum);
        }
        if (cary ==1){
            sb.append(cary);
        }
      return sb.reverse().toString();
    }
}

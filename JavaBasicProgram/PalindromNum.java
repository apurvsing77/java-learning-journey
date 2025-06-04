package JavaBasicProgram;

public class PalindromNum {
    public static  void main(String args[]){
isPalindrome(101);
    }
    static  void isPalindrome(int num ){

      int degit,sum=0,temp,x;
      temp=num;

      while(temp>0) {
          degit = temp % 10;
          sum = (sum * 10) + degit;
          temp=temp/10;
      }
      if (num==sum){
          System.out.println(num+" Is palindrom number");
      }else {
          System.out.println(num+" Is not Palindrome number");
      }


    }
}

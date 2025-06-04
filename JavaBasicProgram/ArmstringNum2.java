package JavaBasicProgram;

public class ArmstringNum2 {
    public static void main(String[] args) {
        for (int i = 1; i <1000 ; i++) {
           int res=checkArmstrong(i,String.valueOf(i).length());
           if (res == i)
               System.out.print(res+",");
         }
    }
    static int checkArmstrong(int num,int len){
        int result =0;
        while (num>0) {
            int orignal_digit = num;
            int digit = orignal_digit % 10;
            result += (int) Math.pow(digit, len);
            num=orignal_digit/10;
        }
        return result;
    }
}

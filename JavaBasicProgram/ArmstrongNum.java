package JavaBasicProgram;

public class ArmstrongNum {
    public static void  main(String args[]){
      int num=153;
      int len=(int)(Math.log10(num)+1);
        int rs=armsstrong(153,len);
        if (rs == num)
            System.out.println(num+" is armstrong num");
        else
            System.out.println(num+" is not armstrong Num");

    }
    static int armsstrong(int num,int len){
        int result=0,temp,degit;
        temp=num;
        while (num>0){
            degit=num % 10;
            result= result+(int)Math.pow(degit,len);
            num=num/10;
        }

        return result;
    }
}

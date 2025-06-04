package JavaBasicProgram;

public class FactorialNum {
    public static  void main(String args[]){
factorial(5);
        System.out.println(factorial1(6));
    }
    static  void factorial(int num){
        int res=1;
        for (int i = 1; i <=num ; i++) {
            res=res*i;
        }
        System.out.println("Result is "+res);

    }
    static int  factorial1(int num){
        if (num == 1) {
            return 1;
        }
        return num*factorial1(num-1);
    }
}

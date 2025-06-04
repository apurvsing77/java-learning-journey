package JavaBasicProgram;

public class PrimeNumber {
    public static void main(String args[]){
        int count=0;
        for (int i = 1; i <=50 ; i++) {
            boolean result=isprime(i);
            if (result == true) {
                System.out.print(i+" ");
                count++;
            }
        }
        System.out.println(" All are  prime Number Between 1 To 50 & Total count is  "+count);

    }
    static  boolean isprime(int num){

        if (num <=1 ) {
            return false;
        }
        for (int i = 2; i <Math.sqrt(num) ; i++) {
            if (num % i==0) {
                return false;
            }
        }
        return true;
    }
}

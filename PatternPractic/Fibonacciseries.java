package PatternPractic;

public class Fibonacciseries {

    public static void main(String[] args) {

        System.out.print(0+" ");
        System.out.print(1+" ");
        int first=0,second=1,target=10;
        fibonacci(first,second,target);
        System.out.println();
        System.out.print(0+" ");
        System.out.print(1+" ");
        fibonacci2(10-2);
    }
    static  void fibonacci(int first,int second,int target){
        int res,num=2;
        while(num<target) {
           res=first+second;
            first=second;
            second=res;
            num++;
            System.out.print(res+" ");
        }

    }

   static int n1=0,n2=1,n3=0;
    static void fibonacci2(int target){

        if (target > 0) {
          n3=n1 + n2;
          n1=n2;
          n2=n3;
            System.out.print(n3+" ");
            fibonacci2(target-1);
        }

    }
}

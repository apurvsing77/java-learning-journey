package Loop;

public class Program1 {

    public static void main(String[] args) {

        situation_1(10);
    }
    static void situation_1(int n){
        System.out.println("pattern 1 :");
        for (int r1=1;r1<=n;r1++){

            System.out.print(r1+",");

        }
    }
    static void situation_2(int n) {
        int r2 = 1;
        System.out.println("pattern 2 :");

        for (;r2<=n;r2++) {
             System.out.print(r2 + " , ");
        }
    }

    static void situation_3(int n){
        int r3=1;
        System.out.println("pattern 3 :");
        for (;;r3++){
            if(r3<=n) {
                System.out.print(r3 + " , ");

            }else {
                break;
            }
        }
    }

    static void situation_4(int n){
        int r4=1;
        System.out.println("pattern 4 :");
        for (;;){
            if(r4<=n) {
                System.out.print(r4 + " , ");
                r4++;
            }else {
                break;
            }
        }
    }
}

package Loop.Pattern;

public class TrienglarArray {
    public static void main(String[] args) {
    print(5);
    }
    static  void print(int n){
        for (int i = 1; i <= n ; i++) {
            for (int j = 0; j < n-i ; j++) {
                System.out.print(" ");
            }
            int c=1;
            for (int j = 1; j <= i ; j++) {
                if ((i > 1 && i % 2 !=0) && (j<i && j !=1)){
                    System.out.print(c+1);
                }else {
                    System.out.print(c);
                }
                if (j >=1 && j < i )
                    System.out.print("*");
                c = c * (i-j)/j;
            }
            System.out.println();
        }
    }
}

package Loop.Pattern;

public class PatternCharractor {
    public static void main(String[] args) {
 patterncharTrangle(5);
    }
    static  void patternchar1(int n){
        int asciiVal=65;
        System.out.println((char)asciiVal+" ");
    }
    static  void dimentpattern(int n){

        for (int row = 1; row <= 2*n ; row++) {
            int space = row  > n ? row-n :n-row;
            for (int i = 1; i <=space ; i++) {
                System.out.print("_");
            }
            int newCol= row > n ? 2*n-row-1:row;
            for (int col = newCol; col >=1 ; col--) {
                System.out.print("*");
            }
            for (int col = 2; col <=newCol ; col++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
    static  void patternchar(int n){

        int asciiVal=65;


        for (int row = 0; row < 2*n ; row++) {
            System.out.print(row+".");
            int space = row  >= n ? row-n+2 :n-row;
            for (int i = 0; i < space-1 ; i++) {
                System.out.print(" ");
            }
            int newCol= row >= n ? 2*n-row-1-1:row;
            for (int col = newCol; col >=0 ; col--) {
                System.out.print((char)(asciiVal+col)+"");

            }
            for (int col = 1; col <=newCol ; col++) {
                System.out.print((char)(asciiVal+col)+"");
            }
            System.out.println();
        }


    }
    static  void patterncharTrangle(int n){

        int asciiVal=65;


        for (int row = 0; row < 2*n-1 ; row++) {
            System.out.print(row+".");
            int space = row  >= n ? row-n+2 :n-row;
            for (int i = 0; i < space ; i++) {
                System.out.print("*");
            }
            int newCol= row >= n ? 2*n-row-2:row;
            for (int col = newCol; col >=0 ; col--) {
                if (col == row || col==2*n-row-2)  System.out.print((char)(asciiVal+col)+"");
                System.out.print(" ");

            }
            for (int col = 1; col <=newCol ; col++) {
                if (col==row || col==2*n-row-2  )
                    System.out.print((char)(asciiVal+col)+"");
                System.out.print(" ");
            }
            System.out.println();
        }


    }

}

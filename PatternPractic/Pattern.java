package PatternPractic;

public class Pattern {
    public static void main(String args[]){
        pattern16(5);
    }
    public static void pattern1(int n){
        int i,j,k,max;
        max=2*n;
        for (i = 1; i <max; i++) {
//           if (i<=n){
//               k=i*2-1;
//           }else {
//               k=(max-i)*2-1;
//           }
            int newCol=i<n?i*2-1:(max-i)*2-1;
            for ( j = 0; j <newCol ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void pattern15(int n) {

        for (int row = 1; row < 2 * n; row++) {
            System.out.print(row+".");
            int space = row > n ? row - n : n - row;
            for (int s = 1; s <= space; s++) {
                System.out.print("*");
            }
            int newCol = row > n ? 2 * (2 * n - row) - 1 : 2 * row - 1;
            for (int col = 1; col <= newCol; col++) {//if here row value is 2*row then in next if condition
                if (col == 1 || col == 2 * row - 1 || col == 2 * (2 * n - row) - 1) {//row should be 2*row
                    System.out.print("*");//if here is one space
                } else {
                    System.out.print(" ");
                }
                //System.out.print("*");
            }
            for (int s = 1; s <= space; s++) {
                System.out.print("*");
            }
            System.out.println();
        }


    }
    static void pattern16(int n) {

        for (int row = 0; row < 2 * n; row++) {
            System.out.print(row+".");
            int newCol = row >= n ? row-n+1 : n-row;
            for (int i = 0; i < newCol ; i++) {
                System.out.print("*");
            }

            int space=row >=n ? (2 * n -row-1)*2:2*row;
            for (int s = 0; s <space ; s++) {
                System.out.print(" ");
            }

            for (int i = 0; i < newCol ; i++) {
                System.out.print("*");
            }

            System.out.println();
        }


    }


}

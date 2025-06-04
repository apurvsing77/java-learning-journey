package Loop.Pattern;

public class BinaryPattern {
    public static void main(String[] args) {
      binarypattern(5);
    }
    static void binarypattern(int n){

        for (int i = 1; i <=n ; i++) {
            for (int j = 0; j<i ; j++) {
                if ((i +j) % 2 != 0){
                    System.out.print(1);
                }else
                    System.out.print(0);
            }
            System.out.println();

        }
        System.out.println(2%2);

    }
    static void pattern15(int n) {

        for (int row = 1; row <= 2 * n; row++) {
            int space = row > n ? row - n : n - row;
            for (int s = 1; s <= space; s++) {
                System.out.print(" ");
            }
            int newCol = row > n ? 2 * n - row : row;
            for (int col = 1; col <= newCol; col++) {//if here row value is 2*row then in next if condition
                System.out.print("* ");
            }
            System.out.println();
        }

    }

}

package Loop.Pattern;

public class SandGlass {
    public static void main(String[] args) {
sandGlass(10);
    }
    public static void sandGlass(int num){
        for (int row = 1; row <=2*num ; row++) {
            int newCol=row > num ?2*row-num-1:num;
            int space=row>num ? 2*num-row+1:row;
            for (int s = 1; s <=space ; s++) {
                System.out.print(" ");
            }
//            for (int j = 1; j <=newCol-row+1; j++) {
//
//                    System.out.print("* ");
//
//
//            }
            for (int j = 1; j <=newCol-row+1; j++) {
                if (row==1 || row==2*num || j == 1 || j==newCol-row+1) {
                    System.out.print("* ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.println();
            }

        }

    }


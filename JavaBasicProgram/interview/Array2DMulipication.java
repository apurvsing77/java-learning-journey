package JavaBasicProgram.interview;

import static java.lang.System.exit;

public class Array2DMulipication {
    public static void main(String[] args) {
        int[][] a1 ={{1,2,3},{4,5,6},{7,8,9}};
        int[][] a2 ={{1,2,3},{4,5,6},{7,8,9}};

        int[][] res = multiplyMatrix(a1,a2);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] multiplyMatrix(int[][] a1, int[][] a2) {
        int[][] res = new int[0][0];
        if(a1[0].length == a2.length){
              res = new int[a1.length][a2[0].length];

            for (int i = 0; i < a1.length ; i++) {
                for (int j = 0; j <a2[0].length ; j++) {
                    for (int k = 0; k <a1[0].length ; k++) {
                        res[i][j] += a1[i][k] * a2[k][j];
                    }
                }
            }

        } else if (a2[0].length == a1.length) {
              res = new int[a2.length][a1[0].length];
            for (int i = 0; i < a2.length ; i++) {
                for (int j = 0; j < a1[0].length; j++) {
                    for (int k = 0; k < a1.length ; k++) {
                        res[i][j] += a2[i][k] * a1[k][j];
                    }
                }
            }
        } else {
            System.out.println("Multiplication can't be done ");
            exit(0);
        }


        return res;
    }
}

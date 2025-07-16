package JavaBasicProgram.interview;

public class Array3DMultiplication {
    public static void main(String[] args) {
        int[][][] arr1 = {{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},{{2, 3, 1}, {4, 5, 6}, {7, 8, 9}}};
        int[][][] arr2 = {{{1, 2, 3},{4, 5, 6},{7, 8, 9}},{{2, 3, 1},{4, 5, 6},{7, 8, 9}}};

        int[][][] result = check3DMatrix(arr1,arr2);

        if (result != null) {
            for (int i = 0; i < result.length; i++) {
                System.out.println("--- Plane " + i + " ---");
                for (int j = 0; j < result[i].length; j++) {
                    for (int k = 0; k < result[i][j].length; k++) {

                        System.out.print(result[i][j][k] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }else {
            System.out.println("No plane found");
        }

    }
    public static  int[][][] check3DMatrix(int[][][] arr1, int[][][] arr2){
        int depthA = arr1.length;
        int rowA = arr1[0].length;
        int colA = arr1[0][0].length;

        int depthB = arr2.length;
        int rowB = arr2[0].length;
        int colB = arr2[0][0].length;

        System.out.println("rowA: " + rowA);
        System.out.println("colA: " + colA);
        System.out.println("depthA: " + depthA);
        System.out.println("rowB: " + rowB);
        System.out.println("colB: " + colB);
        System.out.println("depthB: " + depthB);


        int [][][] res = new int[depthA][rowA][colB];

        if (arr1[0][0].length != arr2[0].length) {
            System.out.println("Error !,  We cant multiply");
            return null;
        }
        else if (arr1.length != arr2.length){
            System.out.println("Error ,  We cant multiply");
            return null;
        }
        else {
            for (int k = 0; k < depthA; k++) {
                for (int i = 0; i < rowA; i++) {
                    for (int j = 0; j < colB; j++) {
                        for (int p = 0; p < rowB; p++) {
                            res[k][i][j] += arr1[k][i][p] * arr2[k][p][j];
                        }
                    }
                }
            }
        }
        return res;
    }
}

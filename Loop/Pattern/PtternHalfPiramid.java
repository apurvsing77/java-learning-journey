package Loop.Pattern;

public class PtternHalfPiramid {
    public static void main(String[] args) {
halfPiramid(5);
    }
    public static void halfPiramid(int num){
        //For Row print
        for (int i = 0; i <2*num ; i++) {

            int newCol=i >= num ? 2*num-i:i;
            //for space print
            for (int s = 0; s <num-newCol ; s++) {
                System.out.print(" ");
            }
            for (int j = 0; j <newCol ; j++) {
                System.out.print("* ");
            }


            System.out.println();
        }
    }
}

package Loop.Pattern;

public class Pattern {
    public static void main(String[] args) {

        pattern2(5);

    }


    static void pattern2(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(" " + col);
            }
            System.out.println();

        }
    }
    static void pattern3(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = n; col >= 1; col--) {
                if (col >= row) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();

        }
    }
    static void patternn3(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = n; col >= row; col--) {
                System.out.print("*");
            }
            System.out.println();

        }
    }

    static void pattern5(int n) {
        for (int row = 1; row <= 2 * n; row++) {

            int newCol = row > n ? 2 * n - row : row;
            for (int col = 1; col <= newCol; col++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    static void pattern6(int n) {

        for (int row = 1; row <= n; row++) {
            //   int k=2*n;
            for (int col = n; col >= 1; col--) {
                // System.out.print("-");
                if (col <= row) {
                    if (col == 1 || col == row) {
                        System.out.print("* ");//if here is one space
                    } else if (row == n) {
                        System.out.print("**");// then here shoud be two space requir
                    } else {
                        System.out.print("  ");
                    }
                } else {
                    System.out.print(" ");
                }
                //  System.out.print("*");
            }
            System.out.println();
        }
    }
    static void pattern7(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                if (col >= row) {
                    System.out.print("*");
                } else {
                    System.out.print("-");
                }
                // System.out.print("*");
            }
            System.out.println();

        }
    }
    static void pattern8(int n) {

        for (int row = 1; row <= n; row++) {
            for (int s = 1; s <= n - row; s++) {
                System.out.print(" ");

            }
            for (int col = 1; col <= 2 * row - 1; col++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }
    static void pattern9(int n) {

        for (int row = n; row >= 1; row--) {
            for (int s = 1; s <= n - row; s++) {
                System.out.print(" ");

            }
            for (int col = 1; col <= 2 * row - 1; col++) {
                System.out.print("*");
            }
            System.out.println();

        }

    }
    static void pattern10(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 5; col >= 1; col--) {
                if (col <= row) {
                    System.out.print("  * ");
                } else {
                    System.out.print("  ");
                }
                // System.out.print("*");
            }
            System.out.println();

        }
    }

    static void pattern11(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                if (col >= row) {
                    System.out.print(" *  ");
                } else {
                    System.out.print("  ");
                }
                // System.out.print("*");
            }
            System.out.println();

        }
    }
    static void pattern12(int n) {
        for (int row = 1; row <=2* n; row++) {
            int space=row > n ? 2*n-row+1 : row;
            for (int i = 0; i <space ; i++) {
                System.out.print(" ");
            }
            int newCol= row > n ? row-n : n-row+1;
            for (int col = newCol; col >0; col--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern13(int n) {
        for (int row = 1; row <= n; row++) {
            for (int s = 1; s <= n - row; s++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= 2 * row - 1; col++) {//if here row value is 2*row then in next if condition
                if (col==1||col==2*row-1||row==n){//row should be 2*row
                    System.out.print("*");//if here is one space
                }else {
                    System.out.print(" ");
                }
                  System.out.print("*");
            }
            System.out.println();
        }

    }
    static void pattern14(int n) {


        for (int row = n; row >= 1; row--) {
            for (int s = 1; s <= n - row; s++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= 2 * row - 1; col++) {
                if (col == 1 || col == 2 * row - 1 || row == n) {
                    System.out.print("*");//if here is one space
                } else {
                    System.out.print(" ");
                }
                // System.out.print("*");
            }
            System.out.println();
        }
    }
    static void pattern15(int n) {

        for (int row = 1; row <= 2 * n; row++) {
            int space = row > n ? row - n : n - row;
            for (int s = 1; s <= space; s++) {
                System.out.print(" ");
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
            System.out.println();
        }

    }

    static void pattern17(int n) {


        for (int row = 1; row <= 2 * n; row++) {
            int space = row > n ? row - n : n - row;
            for (int s = 1; s <= space; s++) {
                System.out.print(" ");
            }
            int newCol = row >= n ? 2 * n - row : row ;
            for (int col = newCol; col >= 1; col--) {

                System.out.print(col);
            }
            for (int col = 2; col <= newCol; col++) {

                System.out.print(col);
            }

            System.out.println();
        }

    }
    static void pattern18(int n) {

        for (int row = 1; row <= 2 * n; row++) {

            int newCol = row > n ? row - n : n - row + 1;
            for (int col = newCol; col >= 1; col--) {
                System.out.print(row);
            }
            int space = row > n ? 2 * (2 * n - row) : 2 * (row - 1);
            for (int s = 1; s <= space; s++) {
                System.out.print(" ");
            }
            int newCol1 = (row > n )? row - n : n - row + 1;
            for (int col = 1; col <= newCol1; col++) {
                System.out.print(row);
            }
            System.out.println();
        }
    }
    static void pattern19(int n) {
        for (int row = 1; row <= 2 * n; row++) {

            int newCol = row > n ? 2 * n - row : row;
            for (int col = 1; col <= newCol; col++) {
                System.out.print("*");
            }
            int space = row > n ? 2 * (row - n) : 2 * (n - row);

            for (int s = space; s >= 1; s--) {
                System.out.print(" ");
            }
            int newCol2 = row > n ? 2 * n - row : row;
            for (int col = newCol2; col >= 1; col--) {
                System.out.print("*");
            }
            System.out.println();
         }
    }
    static void pattern20(int n){
        for (int row = 1; row <=n ; row++) {

            for (int col = 1; col <=n-1 ; col++) {
                if (col==1||row==1||row==n||col==n-1) {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static  void pattern21(int n){
        int count=1;
        for (int row = 1; row <=n ; row++) {
            for (int col = 1; col <=row ; col++) {
                System.out.print(count+" ");
                count++;
            }
            System.out.println();
        }
    }

    static void pattern24(int n){

        for (int row = 1; row <= 2 * n; row++) {

            int newCol = row > n ? 2 * n - row+1 : row;
            for (int col = 1; col <= newCol; col++) {
                if (col==1||col==row||col==2*n-row+1) {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            int space = row > n ? 2 * (row - n-1) : 2 * (n - row);

            for (int s = space; s >= 1; s--) {
                System.out.print(" ");
            }
            int newCol2 = row > n ? 2 * n - row+1 : row;
            for (int col = newCol2; col >= 1; col--) {
                if (col==1||col==row||col==2*n-row+1) {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static void pattern25(int n){
        for (int row = 1; row <=n ; row++) {
            for (int s =1 ; s <=n-row ; s++) {
                System.out.print(" ");

            }
            for (int col = 1; col <=n-1 ; col++) {
                if (col==1||row==1||row==n||col==n-1) {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static  void pattern26(int n){
        for (int row = 1; row <=n ; row++) {
            for (int col = 1; col <=n-row+1 ; col++) {
                System.out.print(row+" ");
            }
            System.out.println();
        }
    }

    static void pattern27(int n) {
        int count = 1;
        int count2=17;
        int result;
        for (int row = 1; row <= n; row++) {
            for (int s = 1; s <= row - 1; s++) {
                System.out.print("  ");
            }
            for (int col = 1; col <= n - row + 1; col++) {
                System.out.print(count+" ");
                count++;
            }
            for (int s = 1; s <=n ; s++) {
                if (s==1&&row!=n) {
                    System.out.print(" ");

                }
            }

             result=count2;
            for (int col = 1; col <=n-row+1; col++) {
                System.out.print( result+" ");
                result++;

            }
             count2=count2-n+row;
            System.out.println();


        }



    }

      //29 is same as 19 & 28 is same as 17,8&9
    static void pattern30(int n){
        for (int row = 1; row <= n ; row++) {

            for (int s = 1; s <=n-row; s++) {
                System.out.print("  ");
            }

            for (int col = row; col >= 1; col--) {

                System.out.print(col+" ");
            }
            for (int col = 2; col <= row; col++) {

                System.out.print(col+" ");
            }

            System.out.println();
        }
    }
    static void pattern31(int n) {
        int nn = n;
        n = 2 * n;
        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= n; col++) {
                int print = Math.max(Math.max(col, n - row), Math.max(n - col, row));
                System.out.print(print + " ");
            }
            System.out.println();
        }

    }
    static  void pattern32(int n){
        char temp;
        char ch=69;
        for (int row =1; row <=n ; row++) {

            temp=ch;
            for (int col = 1; col <=row ; col++) {
                System.out.print(temp+" ");
                temp++;
            }
            ch--;
            System.out.println();
        }

    }

    static  void pattern33(int n){

        char ch=97;
        for (int row =1; row <=n ; row++) {


            for (int col = 1; col <=row ; col++) {
                System.out.print(ch+" ");
                ch++;
            }

            System.out.println();
        }

    }

    static  void pattern34(int n){
        char temp;
        char ch=69;
        for (int row =1; row <=n ; row++) {

            temp=ch;
            for (int col = 1; col <=n-row+1 ; col++) {
                System.out.print(temp+" ");
                temp--;
            }
            ch--;
            System.out.println();
        }

    }

    static  void pattern35(int n){
        int temp;
        int res2=1;

        for (int row =1; row <=n ; row++) {
            int temp1=1;

           // temp=ch;
            for (int col = 1; col <=row ; col++) {
                System.out.print(temp1);
                temp1++;
            }
            for (int s = 1; s <=2*(n-row); s++) {
                System.out.print(" ");

            }
             temp=res2;
            for (int col = 1; col <=row ; col++) {
                System.out.print(temp);
                temp--;
            }
            res2++;

            System.out.println();
        }

    }
    static void pattern16(int n){
        int k=1;

        for (int row = 0; row <n; row++) {
            for (int s = 1; s <=n-row ; s++) {
                System.out.print(" ");
            }
            for (int col = 0; col <=row ; col++) {
                if (row==0||col==0){
                   k=1;
                }else{
                    k=k*(row-col+1)/col;
                }

                System.out.print(k+" ");
            }
            System.out.println();
        }
    }
    static void pattern37(int n) {
        int count=17;
        int result;
        for (int row = 1; row <= n; row++) {
            result=count;
            for (int col =0; col <=n-row; col++) {
                System.out.print( result+" ");
                result++;
            }
            count=count-n+row;
            System.out.println();

        }
    }

  //  https://www.edureka.co/blog/30-pattern-programs-in-java/
    static  void pattern38(int n){

        for (int i = 1; i <2*n ; i++) {
            int newCol;
            newCol=(i<=n) ? i :2*n-i;
            for (int s = 1; s <=n-newCol ; s++) {
                System.out.print("_");
            }
            for (int j = 1; j <=newCol ; j++) {
                System.out.print("*");
            }
            for (int j = 2; j <=newCol ; j++) {
                System.out.print("*");

            }

            System.out.println();
        }

    }

    static  void pattern39(int n){
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n-i+1 ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }

    static  void pattern40(int n){
        for (int i = 0; i <=n ; i++) {
            for (int s = 1; s <=n-i ; s++) {
                System.out.print("_");
            }
            for (int j = 0; j <=i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }


    static  void pattern41(int n){
        for (int i = 1; i <= 2*n ; i++) {
            int newCol;
            newCol=(i<=n) ? i :2*n-i;
            for (int j = 1; j <= newCol ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }

    static  void pattern42(int n){
        for (int i = 1; i <= 2*n ; i++) {
            int newCol;
            newCol=(i<=n) ? i :2*n-i;
            for (int s = 1; s <= n- newCol ; s++) {
                System.out.print("_");
            }
            for (int j = 1; j <= newCol ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    static  void pattern43(int n){
        for (int i = 1; i <= 2*n ; i++) {
            int newCol;
            newCol=(i<=n) ? n-i+1 :i-n;
            for (int s = 1; s <= n-newCol ; s++) {
                System.out.print("_");
            }
            for (int j = 1; j <= newCol ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }

    static  void pattern44(int n){

        for (int i = 1; i <2*n ; i++) {
            int newCol;
            newCol=(i<=n) ? i :2*n-i;
            for (int s = 1; s <=n-newCol ; s++) {
                System.out.print(" ");
            }
            for (int j = 1; j <=newCol ; j++) {
                if (j == 1) {
                    System.out.print("*");
                }else System.out.print(" ");
            }
            for (int j = 2; j <=newCol ; j++) {
                if (j == newCol) {
                    System.out.print("*");
                }else System.out.print(" ");

            }

            System.out.println();
        }

    }

    static  void pattern45(int n){
        for (int i = 1; i <= n ; i++) {

            for (int s = 1; s <= n-i ; s++) {
                System.out.print(" ");
            }
            int k=1;
            for (int j = 1; j <= i ; j++) {
                System.out.print(k+" ");
                k=k*(i-j)/j;
            }
            System.out.println();
        }

    }

    static  void pattern46(int n){

        for (int i = 1; i <2*n ; i++) {
            int newCol;
            newCol=(i<=n) ? i :2*n-i;
            for (int s = 1; s <=n-newCol ; s++) {
                System.out.print("_");
            }
            int val=newCol;
            for (int j = 1; j <=newCol ; j++) {
                System.out.print(val);
                val--;
            }
            ++val;
            for (int j = 2; j <=newCol ; j++) {
                val++;
                System.out.print(val);


            }

            System.out.println();
        }

    }

    static  void pattern47(int n){

        for (int i = 1; i <2*n ; i++) {
            int newCol;
            newCol=(i<=n) ? i :2*n-i;
            for (int s = 1; s <=n-newCol ; s++) {
                System.out.print("_");
            }
            for (int j = newCol; j >=1 ; j--) {
                System.out.print(j);
            }
            for (int j = 2; j <=newCol ; j++) {
                System.out.print(j);
            }

            System.out.println();
        }

    }

    static  void pattern48(int n){

        for (int i = n; i >=1 ; i--) {
            for (int j = n; j >= i ; j--) {
                System.out.print(j+" ");
            }
            System.out.println();
        }

    }
    static  void pattern49(int n){

        for (int i = 1; i <=n ; i++) {
            for (int j = i; j >= 1 ; j--) {
                System.out.print(j+" ");
            }
            System.out.println();
        }

    }

    static  void pattern50(int n){

        for (int i = 1; i <=n ; i++) {
            int num;
            if (i%2 == 0 ) {
              num=0;
                for (int j = 1; j <=n ; j++) {
                    System.out.print(num);
                    num=(num==0)?1:0;

                }

            }else {
                num =1;
                for (int j = 1; j <=n ; j++) {
                    System.out.print(num);
                    num=(num==0)?1:0;

                }

            }

            System.out.println();
        }

    }

    static  void pattern51(int n){

        for (int i = 1; i <=n ; i++) {
            int num;

                for (int j = 1; j <=i ; j++) {
                    if (j%2 ==0) {
                        num = 0;
                        System.out.print(num);
                    } else {
                        num=1;
                        System.out.print(num);
                    }
                }
            System.out.println();
            }
        }

    static  void pattern52(int n){

        for (int i = 1; i <2*n ; i++) {
            int newCol;
            newCol=(i<=n) ? i :2*n-i;
            for (int s = 1; s <=newCol ; s++) {
                System.out.print(" ");
            }
            int value;
            value=newCol;
            for (int j = 1; j <=n-newCol+1 ; j++) {
                System.out.print(value+" ");
                value++;
            }
            System.out.println();
        }

    }
    static void pattern53(int n) {
        for (int i = 1; i <= 2*n ; i++) {
            int newCal;
            newCal = (i<=n)? i : 2*n - i + 1;
            for (int j = 1; j <= n-newCal +1 ; j++) {
                System.out.print("* ");
            }
            for (int s = 1; s <= 2*newCal-2 ; s++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= n-newCal +1 ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern54(int n) {
        for (int i = 1; i <= 2*n ; i++) {
            int newCal;
            newCal = (i<=n)? i : 2*n - i ;
            for (int j = 1; j <= newCal  ; j++) {
                System.out.print("*");
            }
            for (int s = 1; s <=2*n - 2*newCal ; s++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= newCal ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern55(int n) {
        for (int i = 1; i <= 2*n ; i++) {
            int newCal;
            newCal = (i<=n)? i : 2*n - i +1;
            for (int j = 1; j <= newCal  ; j++) {
                if (j == 1 || j == newCal) {
                    System.out.print("*");
                }else System.out.print(" ");
            }
            for (int s = 1; s <=2*n - 2*newCal ; s++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= newCal ; j++) {
                if (j == 1 || j == newCal) {
                    System.out.print("*");
                }else System.out.print(" ");
            }
            System.out.println();
        }
    }
    static void pattern56(int n) {
        for (int i = 1; i <2*n ; i++) {
            int newCal;
            newCal = (i <= n) ? n-i +1 :i - n +1;
            for (int s = 1; s <=n-newCal ; s++) {
                System.out.print(" ");
            }
            for (int j = 1; j <=newCal ; j++) {
                System.out.print("*");
            }
            for (int j = 2; j <= newCal; j++) {
                System.out.print("*");
            }
            System.out.println();
            }

        }

    static void pattern57(int n) {
        for (int i = 1; i <2*n ; i++) {
            int newCal;
            newCal = (i <= n) ? i : 2*n-i;
            for (int j = 1; j <=newCal ; j++) {
                System.out.print("*");
            }
            for (int s = 1; s <=2*n-2*newCal ; s++) {
                System.out.print(" ");
            }
            for (int j = 1; j <=newCal ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    static void pattern58(int n) {
        for (int i = 1; i <=2*n ; i++) {
            int newCal;
            newCal = (i <= n) ? i : 2*n-i+1;
            for (int j = 1; j <=newCal ; j++) {
                if (j==1 || j == newCal){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            for (int s = 1; s <=2*n-2*newCal ; s++) {
                System.out.print(" ");
            }
            for (int j = 1; j <=newCal ; j++) {
                if (j==1 || j == newCal){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    static void pattern59(int n) {
        for (int i = 1; i <= n ; i++) {
            for (int s = 1; s <= n-i ; s++) {
                System.out.print("  ");
            }
            for (int j = i; j >=1 ; j--) {
                System.out.print(j+" ");
            }
            for (int j = 2; j <=i ; j++) {
                System.out.print(j+" ");
            }
            System.out.println();

        }

        }

    static void pattern60(int n) {
        for (int i = 0; i < n ; i++) {
            for (int s = 0; s <i ; s++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * n - (2 * i+1) ; j++) {
                System.out.print("*");
            }

            System.out.println();

        }

    }

}






















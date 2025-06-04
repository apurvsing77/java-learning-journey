package Leetcode150Part2.pattern;


public class Pattern1 {
    public static void main(String[] args) {
     pattern22(5);
    }
    static void  print(int n){
        for (int i = 1; i <2*n ; i++) {
            int space =i > n ?i-n:n-i;
            int newCol = i >n ? 2*n-i:i;

            for (int j = 0; j <space ; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <newCol ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void  pattern18(int n){
        for (int i = 1; i <= 2*n ; i++) {
            int space =i > n ? (2*n -i)*2 : (i-1)*2;
            int newCol = i >n ? i-n:n-i+1;
            for (int j = 0; j <newCol ; j++) {
                System.out.print("*");
            }
            for (int j = 0; j <space ; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <newCol ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void  pattern19(int n){
        for (int i = 1; i <= 2*n ; i++) {
            int space =i > n ? (i-n)*2 :  (2*n -2*i);
            int newCol = i >n ? (2*n-i) : i;
            for (int j = 0; j <newCol ; j++) {
                System.out.print("*");
            }
            for (int j = 0; j <space ; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <newCol ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    static void  pattern22(int n){

        for (int i = 1; i <= n ; i++) {

            int num = (i % 2== 0) ? 0 :1;

            for (int j = 1; j <=i ; j++) {
                System.out.print(num+" ");
                num = 1-num;
            }

            System.out.println();
        }

    }

    static void  pattern24(int n){
        for (int i = 1; i <= 2*n ; i++) {
            int space =i > n ? (i-(n+1))*2 :  (2*n -2*i);
            int newCol = i >n ? (2*n-i+1) : i;
            for (int j = 0; j <newCol ; j++) {
                if (j == 0 || j == newCol-1) {
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            for (int j = 0; j <space ; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <newCol ; j++) {
                if (j == 0 || j == newCol-1) {
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }


    static void  pattern27(int n){
        int count = 1;
        int second_count =17;
        for (int i = 1; i <= n ; i++) {

            for (int space = 1; space <=i-1 ; space++) {
                System.out.print("__");
            }
            for (int j = 1; j <=n-i+1 ; j++) {
                if (j==n-i+1 && count != 10) {
                    System.out.print(count + "  ");
                }else {
                    System.out.print(count + " ");
                }
                count++;
            }
            int digit =second_count;
            for (int j = 1; j <=n-i+1 ; j++) {
                System.out.print(digit+" ");
                digit++;

            }
            digit=second_count -n + i;
            second_count =digit;
            System.out.println();
            }

        }



    static void  pattern30(int n){

        for (int i = 1; i <= n ; i++) {
              int count =i;
            for (int space = 1; space <=n-i ; space++) {
                System.out.print("__");
            }
            for (int j = 1; j <=i ; j++) {
                System.out.print(count+" ");
                count--;
            }
            int second_count=2;
            for (int j = 1; j <i ; j++) {
                System.out.print(second_count+" ");
                second_count++;

            }

            System.out.println();
        }

    }


    static void  pattern33(int n){
        char ch = 'a';
        for (int i = 1; i <= n ; i++) {

            char capital_latter =65;

            for (int j = 1; j <=i ; j++) {
                if ((ch-'a')%2 == 0) {
                    System.out.print(Character.toLowerCase(ch)+" ");
                    ch++;
                }else {
                    System.out.print(Character.toUpperCase(ch)+" ");
                    ch++;
                }


            }

          System.out.println();
        }

    }

    static void  pattern35(int n){

        for (int i = 1; i <= n ; i++) {
            int count =i;

            for (int j = 1; j <=i ; j++) {
                System.out.print(j+"");

            }
            for (int space = 1; space <=2*n-2*i ; space++) {
                System.out.print("_");
            }
            int second_count=2;
            for (int j = 1; j <=i ; j++) {
                System.out.print(count+"");
                count--;

            }

            System.out.println();
        }

    }





}



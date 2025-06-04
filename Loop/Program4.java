package Loop;

public class Program4 {
    public static void main(String[] args) {
        situation_4(90);
    }
    static void situation_1(int n)
    {
        System.out.println("pattern 1 :");
        for (int i = 65; i <=n; i++) {
            char ch=(char)i;
            System.out.print(ch+" ");

        }

    }

    static void situation_2(int n)
    {
        System.out.println("pattern 2 :");
        int i = 65;
        for (; i <=n; i++) {
            char ch=(char)i;
            System.out.print(ch+" ");

        }

    }

    static void situation_3(int n)
    {
        System.out.println("pattern 3 :");
        int i = 65;
        for (;; i++) {
            char ch=(char)i;
            if( i <=n) {
                System.out.print(ch + " ");
            }else{
                break;
            }
        }

    }

    static void situation_4(int n)
    {
        System.out.println("pattern 4 :");
        int i = 65;
        for (; ; ) {
            char ch=(char)i;
            if(i <=n) {
                System.out.print(ch + " ");
                i++;
            }else{
                break;

            }
        }

    }
}

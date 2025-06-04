package Loop;

public class program5 {
    public static void main(String[] args) {
     situation_4(90);
    }
    static void situation_1(int n)
        {
            System.out.println("pattern 1:");
            for (int i = n; i >=65 ; i--) {
                char ch=(char)i;
                System.out.print(ch+" ");
            }
        }
    static void situation_2(int n)
    {
        System.out.println("pattern 2:");
        int i = n;
        for (; i >=65 ; i--) {
            char ch=(char)i;
            System.out.print(ch+" ");
        }
    }
    static void situation_3(int n)
    {
        System.out.println("pattern 3:");
        int i = n;
        for (; ; i--) {
            char ch=(char)i;
            if(i >=65 ) {
                System.out.print(ch + " ");
            }else{
                break;
            }
        }
    }
    static void situation_4(int n)
    {
        System.out.println("pattern 4:");
        int i = n;
        for (; ; ) {
            char ch=(char)i;
            if(i >=65 ) {
                System.out.print(ch + " ");
                i--;
            }else{
                break;
            }
        }
    }
}

package Loop;

public class program2 {
    public static void main(String[] args) {
       situation_4(100);
    }
        static void situation_1(int n)
        {
            System.out.println("Pattern 1 ");
            for (int i = 50; i <=n ; i=i+5)
            {
                System.out.print(i+",");
            }
        }

    static void situation_2(int n)
    {
        System.out.println("Pattern 2 : ");
        int i = 50;
        for (; i <=n ; i=i+5)
        {
            System.out.print(i+",");
        }
    }

    static void situation_3(int n)
    {
        System.out.println("Pattern 3 : ");
        int i = 50;
        for (; ; i=i+5)
        {
            if(i <=n ) {
                System.out.print(i + ",");
            }
            else {
                break;
            }
        }
    }

    static void situation_4(int n)
    {
        System.out.println("Pattern 4 : ");
        int i = 50;
        for (; ; )
        {
            if(i <=n ) {
                System.out.print(i + ",");
                i=i+5;
            }
            else {
                break;
            }
        }
    }



}

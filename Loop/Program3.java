package Loop;

public class Program3 {
    public static void main(String[] args) {
    situation_4(1000);
    }
    static void situation_1(int n)
    {
        System.out.println("Pattern 1 :");
        for (int i=n;i>=100;i=i-100)
        {
            System.out.print(i+" ");
        }

    }

    static void situation_2(int n)
    {
        System.out.println("Pattern 2 :");
        int i=n;
        for (;i>=100;i=i-100)
        {
            System.out.print(i+" ");
        }

    }


    static void situation_3(int n)
    {
        System.out.println("Pattern 3 :");
        int i=n;
        for (;;i=i-100)
        {
            if(i>=100) {
                System.out.print(i + " ");
            }
            else{
                break;
            }
        }

    }

    static void situation_4(int n)
    {
        System.out.println("Pattern 4 :");
        int i=n;
        for (;;)
        {
            if(i>=100) {
                System.out.print(i + " ");
                i=i-100;
            }
            else{
                break;
            }
        }

    }
}

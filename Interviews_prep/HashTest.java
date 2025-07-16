package Interviews_prep;

public class HashTest {
    public static void main(String[] args) {
        int a = 23652;
        String str= "apurv";

        int h = "exampleKey".hashCode(); // Suppose this returns 123456789
        int hash = h &(16-1);

//        int hash = hash(a);
        int result =32 & (16-1);
        System.out.println(result);
        System.out.println(h);


    }
    static final int hash(int key) {
        int h;
        return (key == 0) ? 0 : (h = key) ^ (h >>> 16);
    }
}

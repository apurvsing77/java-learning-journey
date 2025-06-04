package StringProblems;

public class DividibilBy7 {
    public static void main(String[] args) {

        if (check(617)) {
            System.out.println("616 is divisible by 7");
        }else
            System.out.println("616 is NOT divisible by 7");

    }
    static boolean check(int num){
        if (num < 0) return check(-num);
        if (num==0 || num==7) return true;
        if (num<10) return false;
        return check((num/10) - 2*(num-(10*(num/10))));

    }
}

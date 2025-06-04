package StringProblems;

public class DivisibilityBy7 {
    public static void main(String[] args) {
     int num =3721;
        System.out.println(checkDivision(num));
    }
    static  boolean checkDivision(int num){
        if (num<0)
            return checkDivision(-num);
        if (num == 0 || num == 7)
            return true;
        if (num<10){
            return false;
        }
        return checkDivision(num/10 - 2*(num - num/10*10));
    }
}

package StringProblems;

public class MakePalindrome {
    public static void main(String[] args) {
    String str="aebcbda";
        System.out.println(check(str,0,str.length()-1));
        System.out.print("Minimum deletion for longest substring palindrom is :");
        System.out.print(str.length() - check(str,0,str.length()-1));
    }
    static  int check(String str ,int s, int e){
        if (s >e) return 0;
        if (s == e)
            return 1;
        if (str.charAt(s) == str.charAt(e)) {
            return 2 + check(str, s + 1, e - 1);
        }else
//            return Math.min(check(str,s,e-1),check(str,s+1,e)); for minimum palindrom
            return Math.max(check(str,s,e-1),check(str,s+1,e));// for max palindrom

    }
}

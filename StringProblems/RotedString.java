package StringProblems;

public class RotedString {
    public static void main(String[] args) {
    String str1="amazon";
    String str2="azonam";
    if (roted(str1,str2)){
        System.out.println("YES....");
    }else
        System.out.println("NO____");
    }
    static boolean roted(String str1, String str2){
        if (str1.length() != str2.length()) return false;
        if (str1.length() < 2){
            return str1.equals(str2);
        }
        String clock_wise="";
        String antiClock_wise="";
        clock_wise = str1.substring(2)+str1.substring(0,2);
        antiClock_wise = str1.substring(0,2) + str1.substring(2);

        return (clock_wise.equals(str2) ||antiClock_wise.equals(str2));
    }
}

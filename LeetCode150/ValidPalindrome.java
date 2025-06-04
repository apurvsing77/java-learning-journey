package LeetCode150;
//125. Valid Palindrome


public class ValidPalindrome {
    public static void main(String[] args) {
        String s="0P";
        System.out.println(isPalindrome(s));
    }
    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) return true;
        int stat = 0;
        int last = s.length()-1;
        while (stat <= last){
            if(!Character.isLetterOrDigit(s.charAt(stat))){
                stat++;
            } else if (!Character.isLetterOrDigit(s.charAt(last))) {
                last--;
            } else {
                if (Character.toLowerCase(s.charAt(stat)) != Character.toLowerCase(s.charAt(last))){
                    return  false;
                }
                stat++;
                last--;
            }
        }
        return  true;
    }
}

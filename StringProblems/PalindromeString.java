package StringProblems;

public class PalindromeString {
    public static void main(String[] args) {
        String str = "abba";
//        if (chekPalindron(str)) {
//            System.out.println(str +" is palendrom");
//        }else {
//            System.out.println(str +" is Not palendrom");
//        }
        System.out.println(revarseString("abcdef"));
    }
    public static  boolean chekPalindron(String str){
        int left = 0,right = str.length()-1;
        while(left< right) {
            char leftStr = str.charAt(left);
            char rigtStr = str.charAt(right);
            if (leftStr == rigtStr) {
                left++;
                right--;
            }else {
                return  false;
            }
        }
        return  true;
    }

    public static  String revarseString(String str){
        int left = 0,right = str.length()-1;
        StringBuffer sb = new StringBuffer(str);
        while(left< right) {
            char temp = str.charAt(left);
            sb.setCharAt(left,str.charAt(right));
            sb.setCharAt(right,temp);

                left++;
                right--;


            }

        return  sb.toString();
    }
}

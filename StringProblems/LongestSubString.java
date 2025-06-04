package StringProblems;

import java.util.Vector;

public class LongestSubString {
    public static void main(String[] args) {
      String str= "abcdefghefg";
      int result =checklongest(str);
        System.out.println("Longest Strings length is : "+result);
    }
    static boolean longeststr(String str, int i,int j){
        boolean viseated[] = new boolean[256];
        for (int k = i; k <= j ; k++) {
            if (viseated[str.charAt(k)] == true){return false;}
            viseated[str.charAt(k)] =true;
        }
        return true;
    }
    static int checklongest(String str){
        int n = str.length();
        int res=0;
        for (int i = 0; i <n ; i++) {
            for (int j = i; j <n ; j++) {
                if (longeststr(str,i,j)){
                    res = Math.max(res, j-i+1);
                }
            }
        }
        return res;
    }
}

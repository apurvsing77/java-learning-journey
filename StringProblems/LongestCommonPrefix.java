package StringProblems;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
     String[] str ={"geeksforgeeks", "geeks", "geek", "geezer"};
        System.out.println(chekPrefix2(str));
    }
//    static  String chekPrefix(String[] str){
//
//        if (str.length == 0) {
//            return "";
//        }
//        String prefix =str[0];
//        for (int i = 1; i < str.length ; i++) {
//            while (str[i].indexOf(prefix) != 0) {
//                prefix =prefix.substring(0,prefix.length()-1);
//            }
//            if (prefix.isEmpty()) {
//                return "";
//            }
//        }
//        return prefix;
//    }

    static  String chekPrefix2(String[] str){
      Arrays.sort(str);
        String l = str[0];
        String r = str[str.length-1];
        int len = Math.min(l.length(),r.length());
        for (int i = len; i >0 ; i--) {
            if (l.contains(r)){
                return r;
            }else {
                r = r.substring(0,i-1);
            }
        }
        return "";

    }
}

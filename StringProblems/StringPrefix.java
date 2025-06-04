package StringProblems;

import java.util.Arrays;

public class StringPrefix {
    public static void main(String[] args) {
        String []strs={"rvapu","kumarapu","singhapu"};
        String strs2[]={"apurb","avkumar","apusingh"};

       String result= findPostfix(strs);
        System.out.println(result);
       String result2= findprefix2(strs2);
       System.out.println(result2);
    }

     static String findprefix2(String[] strs) {
        StringBuilder result2= new StringBuilder();
         Arrays.sort(strs);
         char []first= strs[0].toCharArray();
         char []last=strs[strs.length-1].toCharArray();
         for (int i = 0; i < Math.min(first.length, last.length) ; i++) {
             if (first[i] != last[i])
                 break;
             result2.append(first[i]);
         }
         return result2.toString();
    }

    static String findPrefix(String[] strs) {
        if (strs.length==0) return "";
        String prefix=strs[0];
         for (int i = 1; i < strs.length ; i++) {
             while (strs[i].indexOf(prefix)!=0){
                 prefix=prefix.substring(0,prefix.length()-1);
             }
         }
         return prefix;
    }
    static String findPostfix(String[] strs) {
        if (strs.length==0) return "";
        String prefix=strs[0];
        for (int i = 1; i < strs.length ; i++) {
            while (strs[i].lastIndexOf(prefix)!=strs[i].length()-prefix.length()){
                prefix=prefix.substring(1);
            }
        }
        return prefix;
    }
}

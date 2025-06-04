package LeetCode;

import java.util.HashMap;
import java.util.Map;

//205. Isomorphic Strings
//https://leetcode.com/problems/isomorphic-strings/submissions/1195554737/

public class IsomorphicStrings {
    public static void main(String[] args) {
    String s = "foo";
    String t = "kaa";
        System.out.println(checkIsomorphics(s,t));
    }
    static  boolean checkIsomorphics(String s , String t){
        int sl = s.length();
        int tl = t.length();
        if (sl != tl) return false;
        Map<Character,Character> map = new HashMap<>();
        for (int i = 0; i <sl ; i++) {
            char orignal = s.charAt(i);
            char replace = t.charAt(i);
            if (!map.containsKey(orignal)){
                if (!map.containsValue(replace)) {
                    map.put(orignal,replace );
                }else {
                    return  false;
                }
            }else {
                if (map.get(orignal) != replace) return  false;

            }
        }
       return true;
    }
}

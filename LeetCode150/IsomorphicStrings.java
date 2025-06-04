package LeetCode150;
//205. Isomorphic Strings

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
    String str1 = "paper";
    String str2 = "titli";
        System.out.println(isIsomorphic(str1,str2));
    }
    public static boolean isIsomorphic(String s, String t) {
        int s1 = s.length();
        int t1 = t.length();
        Map<Character,Character> map = new HashMap<>();
        for (int i = 0; i <s.length() ; i++) {
            char orignal = s.charAt(i);
            char replace = t.charAt(i);
            if (map.containsKey(orignal)){
                if (map.get(orignal) != replace){
                    return false;
                }
            }else {
                if (map.containsValue(replace)){
                    return false;
                }else {
                    map.put(orignal,replace);
                }
            }
        }

return true;

    }
}

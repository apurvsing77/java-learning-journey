package LeetCode150;
//290. Word Pattern

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
     String str1 ="abba";
     String str2 ="dog cat caat dog";
        System.out.println(wordPattern(str1,str2));
    }
    public static boolean wordPattern(String pattern, String s) {
        Map<Character,String> map = new HashMap<>();
        String[] str = s.trim().split("\\s+");
        char[] ch = pattern.toCharArray();
        if (str.length != ch.length) return false;
        for (int i = 0; i < ch.length ; i++) {
            if (map.containsKey(ch[i])){
                if (!map.get(ch[i]).equals(str[i])){
                    return false;
                }
            }else {
                if (map.containsValue(str[i])){
                  return  false;
                }else {
                    map.put(ch[i],str[i]);
                }

            }
        }
        return true;
    }
}

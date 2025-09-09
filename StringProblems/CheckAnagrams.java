package StringProblems;

import java.util.HashMap;
import java.util.Map;

public class CheckAnagrams {
    public static void main(String[] args) {
        String str1 = "anagram";
        String str2 = "qramaan";
        int k=1;
        if (check(str1,str2,k)){
            System.out.println("Yes, It is Anagrams ");
        }else
            System.out.println("No, It is NOT Anagrams ");

    }
    static  boolean check(String str1, String str2, int k){
       if (str1.length() != str2.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i <str1.length() ; i++) {
            char c= str1.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (int i = 0; i <str2.length() ; i++) {
            char c=str2.charAt(i);
            if (map.getOrDefault(c,0) > 0){
                map.put(c,map.get(c)-1);
            }
        }
        int count=0;
        for (char ch: map.keySet()) {
            count += map.get(ch);
        }
        if (count >= k){
            return false;
        }else
            return true;
    }
}

package LeetCode150;

import java.util.Map;

//242. Valid Anagram
public class ValidAnagram {
    public static void main(String[] args) {
    String str1 ="anagram";
    String str2 ="nagaram";
        System.out.println(isAnagram(str1,str2));
    }
    public static boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        if (s.length() != t.length()) return false;
        for (int i = 0; i <s.length() ; i++) {
            arr[s.charAt(i)-'a']++;
        }
        for (int i = 0; i <t.length() ; i++) {
            arr[t.charAt(i)-'a']--;
        }
        for (int i = 0; i <s.length() ; i++) {
            if (arr[s.charAt(i)-'a'] != 0) return false;
        }
        return  true;
    }
}

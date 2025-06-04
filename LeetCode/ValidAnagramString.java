package LeetCode;

//242. Valid Anagram
//https://leetcode.com/problems/valid-anagram/submissions/1195636776/


public class ValidAnagramString {
    public static void main(String[] args) {
    String s = "anagram";
    String t = "nagarem";
        System.out.println(isAnagram(s,t));
    }

    static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
       s = s.toLowerCase();
       t = t.toLowerCase();
       int[] arr = new int[26];
        for (int i = 0; i <s.length() ; i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i <s.length() ; i++) {
            arr[t.charAt(i) - 'a']--;
        }
        for ( int count : arr) {
            if (count != 0) return false;
        }
        return true;
    }
}

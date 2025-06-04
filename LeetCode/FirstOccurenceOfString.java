package LeetCode;
//28. Find the Index of the First Occurrence in a String
//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/submissions/1193540935/
public class FirstOccurenceOfString {
    public static void main(String[] args) {
        String str1="sadbutsad";
        String str2 ="but";
        System.out.println(strStr(str1,str2));
    }
    static int strStr(String haystack, String needle) {

    return haystack.indexOf(needle);

    }
}

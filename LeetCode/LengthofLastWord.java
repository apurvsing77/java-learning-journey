package LeetCode;
//58. Length of Last Word
//https://leetcode.com/problems/length-of-last-word/submissions/1193561823/

public class LengthofLastWord {
    public static void main(String[] args) {
    String s = "fly me   to   the moon";
        System.out.println(lengthOfLastWord(s));
    }
    static int lengthOfLastWord(String s) {
     String[] str = s.split(" ");
     int len = str.length-1;
        char[] ch = str[len].toCharArray();
        return ch.length;
    }
}

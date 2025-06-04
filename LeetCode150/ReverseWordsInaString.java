package LeetCode150;
//151. Reverse Words in a String

public class ReverseWordsInaString {
    public static void main(String[] args) {
    String str = "the sky is blue";
        System.out.println(reverseWords(str));
    }

    public static String reverseWords(String s) {
        if (s.length()==1) return s;
    String[] str = s.split("\\s+");
    int left=0;
    int right =str.length-1;
    while (left<right){
        String temp = str[left];
        str[left] = str[right];
        str[right] = temp;
        left++;
        right--;
    }
   StringBuffer sb = new StringBuffer();
        for (String k : str) {
         sb.append(k+" ");
        }
    return sb.toString().trim();
    }
}

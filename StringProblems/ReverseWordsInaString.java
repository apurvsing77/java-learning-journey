package StringProblems;
//151. Reverse Words in a String

public class ReverseWordsInaString {
    public static void main(String[] args) {
    String str = "..geeks..for.geeks.";
        System.out.println(reverseWords(str));
    }

    public static String reverseWords(String s) {
    String[] str = s.split("\\.");
    int left=0;
    int right =str.length-1;
    while (left<right){
        String temp = str[left];
        str[left] = str[right];
        str[right] = temp;
        left++;
        right--;
    }
    return String.join(".",str);
    }
}

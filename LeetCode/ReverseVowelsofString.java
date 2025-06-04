package LeetCode;
//https://leetcode.com/problems/reverse-vowels-of-a-string/description/
//345. Reverse Vowels of a String
//https://leetcode.com/problems/reverse-string-ii/submissions/1187713781/

public class ReverseVowelsofString {
    public static void main(String[] args) {
String str= "leetcode";
String res= check(str);
        System.out.println(res);
    }
    static  String check(String str){
    char[] arr = str.toCharArray();
    int i= 0;
    int j= str.length()-1;
    String vobel = "aeiouAEIOU";
    while (i < j){
           while (i < j){
              char ch =arr[i];
              if (vobel.indexOf(ch) != -1)
                  break;
              i++;
           }
        while (i < j){
            char ch =arr[j];
            if (vobel.indexOf(ch) != -1)
                break;
            j--;
        }
        if (i<j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

    }
    return  new String(arr);
    }
}

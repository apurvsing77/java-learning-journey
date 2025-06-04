package LeetCode150;
//383. Ransom Note
//
public class RansomNote {
    public static void main(String[] args) {
     String str1 = "baa";
     String str2 = "aab";
        System.out.println(canConstruct(str1,str2));
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
    int[]  count = new int[26];
        for (char ch : magazine.toCharArray()) {
            count[ch-'a']++;
        }
        for (char ch : ransomNote.toCharArray()) {
            count[ch - 'a']--;
            if (count[ch-'a'] <0){
                return false;
            }
        }
    return true;
    }
}

package LeetCode150;
//392. Is Subsequence


public class IsSubsequence {
    public static void main(String[] args) {
        String t = "b";
        String s = "ahbgdc";
        System.out.println(isSubsequence(s,t));
    }
    public static boolean isSubsequence(String s, String t) {
        if (t.length()==0) return true;
        boolean[] visit = new boolean[t.length()];
        for (int i = 0; i <t.length() ; i++) {
            visit[i] =false;
        }
        int target=0;
     int start =0;
     int end = s.length()-1;
     while (start <= end && target < t.length()){
         if (t.charAt(target)==s.charAt(start)){
             visit[target] =true;
             target++;
             start++;
         }else {
             start++;
         }
     }
        for (boolean res :visit) {
            if (res != true){
                return false;
            }
        }
        return true;
    }
}

package StringProblems;

public class MinimumDistanceWords {
    public static void main(String[] args) {
    String[] str ={"the", "quick", "brown", "fox", "the"};
        System.out.println(checkDistance(str,"the","quick"));
    }
    static  int checkDistance(String[] str,String w1, String w2){

        int d1 =-1;
        int d2 =-1;
        int ans =Integer.MAX_VALUE;
        for (int i = 0; i < str.length ; i++) {
            if (str[i].equals(w1)) {
                d1=i;
            }
            if (str[i].equals(w2)) {
                d2 = i;
            }

            if (d1 !=-1 && d2 != -1) {
                ans = Math.min(ans, Math.abs(d2-d1));
            }
        }


        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

}

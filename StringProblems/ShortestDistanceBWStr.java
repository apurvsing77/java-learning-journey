package StringProblems;

public class ShortestDistanceBWStr {
    public static void main(String[] args) {
        String string="for maximum ninty five fox animal";
        String str1[]=string.split(" ");
        int res=distance(str1,"for","foix");
        System.out.println(res);
    }
    static  int distance(String str[],String s1,String s2){
     int d1=-1,d2=-1;
     int ans = 0;
        for (int i = 0; i <str.length ; i++) {
            if (str[i].equals(s1))
                d1 = i;
            if (str[i].equals(s2))
                d2 = i;
            if (d1 != -1 && d2 != -1)
                //ans=Math.min(ans,Math.abs(d1-d2));
                ans = Math.abs(d1-d2);
        }
        return ans;
    }
}
/*
217= 21-14=7
714= 71-8=63; 6-6=0
 */
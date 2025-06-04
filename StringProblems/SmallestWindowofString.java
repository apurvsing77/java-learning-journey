package StringProblems;

public class SmallestWindowofString {
    public static void main(String[] args) {
      String string = "geeksforgeeks";
      String pattern= "org";
        System.out.println("Str  matched is "+checkPattern(string,pattern));
    }
    static  String checkPattern(String str,String pattern){
        int len = str.length();
        String res = "";
        for (int i = 0; i <len ; i++) {
            for (int j = i + 1; j <len ; j++) {
                res = checkMatch(str,i,j);
                if (res.equals(pattern))
                    return res;
            }
        }
        return "";
    }

    static String checkMatch(String str, int i ,int j){
        String strset ="";
        for (int k = i; k <=j ; k++) {
            strset=strset+str.charAt(k);

        }
        return strset;
    }
}

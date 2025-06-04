package StringProblems;

public class RemoveSpaceString {
    public static void main(String[] args) {
        String str="There is space between words";
        removespace(str);

    }

     static void removespace(String str) {
        String res="";
        StringBuffer sb=new StringBuffer();

         int length=str.length();
         for (int i = 0; i <length ; i++) {
             if (str.charAt(i) != ' ') {
                 res=res+str.charAt(i) ;
                 sb.append(str.charAt(i));
             }

         }
         System.out.println(sb);
         System.out.println(res);

    }
}

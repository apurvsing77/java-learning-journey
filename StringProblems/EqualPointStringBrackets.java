package StringProblems;

public class EqualPointStringBrackets {
    public static void main(String[] args) {

        System.out.println(findEqualPoint("(())))("));//   (()))(()()())))
    }
//    static int findEqualPoint(String string){
//        int opning =0;
//        int closing =0;
//        int i=0,j=string.length()-1;
//
//        while (i<string.length()){
//            if (string.charAt(i) == '(') {
//                opning++;
//            }
//            i++;
//        }
//        while (j>0){
//
//            if (string.charAt(j) == '(')
//                opning--;
//            if (string.charAt(j) == ')')
//                closing++;
//            if (opning == closing)
//                return j;
//           j--;
//        }
//        return -1;
//    }

    static int findEqualPoint(String s) {
        int totalOpen = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') totalOpen++;
        }

        int leftOpen = 0;
        int rightClose = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftOpen++;
                totalOpen--;
            } else if (s.charAt(i) == ')') {
                rightClose++;
            }

            if (leftOpen == rightClose) {
                return i;
            }
        }
        return -1;
    }

}

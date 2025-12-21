package StringProblems;

public class    FindEqualBracketStr {
    public static void main(String[] args) {
        String str = "((()(()()(()))()())";
        //String str ="(())))(";// ()))))(
        System.out.println(findEqualBrac(str));
    }
    static  int findEqualBrac(String str){
        int n= str.length();
        int count_clos=0;
        for (int i = 0; i <n ; i++) {
            if (str.charAt(i) == ')')
                count_clos++;
        }
        for (int i = 0; i < n; i++) {
            if (count_clos == i)
                return i;
        }
        return n;

    }
}

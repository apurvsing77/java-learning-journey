package StringProblems;

public class SwapingString {
    public static void main(String[] args) {
        String a="apurv Kumar";
        String k="karan Singh";
        int al=a.length();
        int kl=k.length();
        System.out.println(a+"...."+k);

        //swapping two String
        a=a.concat(k);
        k=a.substring(0,al);
        a=a.substring(al,al+kl);

        System.out.println(a+"...."+k);

    }
}

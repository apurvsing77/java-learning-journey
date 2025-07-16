package LeetCode150;
//12. Integer to Roman

public class NumberToRoman {
    public static void main(String[] args) {
    int num =1994;
        System.out.println(intToRoman(num));
    }
    public static String intToRoman(int num) {
        String res ="";
        String[] m ={"", "M", "MM", "MMM"};
        String[] c={"", "C", "CC", "CCC","CD","D", "DC", "DCC", "DCCC", "CM"};
        String[] x={"","X", "XX", "XXX", "XL","L","LX", "LXX","LXXX", "XC"};
        String[] i={"","I","II","III","IV","V","VI", "VII","VIII","IX"};

            String tho= m[num/1000];
            num= num % 1000;
            String hun = c[num/100];
            num = num % 100;
            String ten = x[num/10];
            num = num % 10;
            String one = i[num % 10];
            res = tho + hun + ten + one;

        return res;
    }
}

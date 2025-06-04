package StringProblems;

public class NumberToRoman {
    public static void main(String[] args) {
        int num=1904;
        printRonman(num);

        String ans=intToRoman(num);
        System.out.println("Roman Number of "+num+" is : "+ans);
    }
    static void printRonman(int num){
        if (num <= 0) {
            System.out.println("Invalid number");
            return;
        }
        char[] ch = new char[10001];
        int  i=0;

        while (num != 0){
            if (num >= 1000) {

                i=digit('M',num/1000,i,ch);
                num = num % 1000;
            }
            else if (num >=500) {
                if (num < 900) {

                   i=digit('D',num/500,i,ch);
                    num=num % 500;
                }else {
                    i=sub_digit('C','M',i,ch);
                    num=num % 100;
                }
            } else if (num >=100) {
                if (num < 400) {
                    i=digit('C',num/100,i,ch);
                    num = num % 100;
                }else {
                    i=sub_digit('C','D',i,ch);
                    num = num % 100;
                }
            } else if (num >=50) {
                if (num < 90) {
                    i=digit('L',num/50,i,ch);
                    num = num % 50;
                }else {
                    i=sub_digit('X','L',i,ch);
                    num = num % 10;
                }
            } else if (num >=10) {
                if (num < 40) {
                   i= digit('X',num/10,i,ch);
                    num = num % 10;
                }else {
                    i=sub_digit('X','L',i,ch);
                    num = num % 10;
                }
            } else if (num >=5) {
                if (num <9) {
                    i= digit('V',num/5,i,ch);
                    num = num % 5;
                }else {
                    i=sub_digit('I','X',i,ch);
                    num = 0;

                }
            } else if (num>=1) {
                if (num < 4) {
                    i= digit('I',num/1,i,ch);
                    num = 0;
                }else {
                    i=sub_digit('I','V',i,ch);
                    num = 0;
                }
            }

        }

        System.out.println("Print Roman Number");
        for (int j = 0; j <i ; j++) {
            System.out.print(ch[j]);
        }
    }

    private static int sub_digit(char c, char m, int i, char[] ch) {
        ch[i++]=c;
        ch[i++]=m;
        return i;
    }

    private static int digit(char m, int n, int i, char[] ch) {
        for (int j = 0; j <n ; j++) {
          ch[i++] = m;
        }
        return i;
    }


    static String intToRoman(int num){
        String m[]={"","M","MM","MMM"};
        String c[] ={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String x[]={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String i[]={"","I","II","III","IV","V","VI","VII","VIII","IX"};


        String thousend = m[num / 1000];
        String hundred = c[(num % 1000) / 100];
        String ten = c[(num  % 100) / 10];
        String one = i[ num % 10];

        String ans=thousend + hundred + ten + one;

        return ans;
    }

}

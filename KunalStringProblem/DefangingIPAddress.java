package KunalStringProblem;

public class DefangingIPAddress {

    public static void main(String[] args) {
     String str ="1.1.1.1";
        String str2 =" 1 1 1 1 ";
        System.out.println(defangIPaddr(str));
    }
    public static String defangIPaddr(String address) {
      return address.replace(".","[.]");
//        return address.replace(" ","");
    }
}

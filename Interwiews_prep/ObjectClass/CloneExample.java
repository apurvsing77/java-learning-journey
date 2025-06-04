package Interwiews_prep.ObjectClass;

 class A implements  Cloneable{
    String str1;

    public A(String str1) {
        this.str1 = str1;
    }
    void show(){
        System.out.println("This is Class A");
    }

    protected   Object clone() throws CloneNotSupportedException
    {
//        return super.clone();
        throw  new CloneNotSupportedException("Clone not Supported");
    }
}
class B extends A{
    String str2;

    public B(String str1, String str2) {
        super(str1);
        this.str2 = str2;
    }
    protected   Object clone() throws CloneNotSupportedException
    {
        System.out.println("B Class clone()");
        return super.clone();
    }
}
class C extends B{
    String str3;

    public C(String str1, String str2, String str3) {
        super(str1, str2);
        this.str3 = str3;
    }
    protected   Object clone() throws CloneNotSupportedException
    {
        System.out.println("C Class clone()");
        return super.clone();
    }
}
public class CloneExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        A a = new A("A Sreing");
        C c = new C("A Class","B Class","C Class");
//        System.out.println(c.str1+"-------"+c.str2);
        A c_Clone =(C)c.clone();
//        System.out.println(c.str1+"-------"+c.str2);
//        b_Clone.str1="A Class New String";
//        b_Clone.str2="A Calss New String";
//        System.out.println(c.str1+"-------"+c.str2);
//        System.out.println(b_Clone.str1+"-------"+b_Clone.str2);
        c_Clone.show();
    }
}


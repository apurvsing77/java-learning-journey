package Interviews_prep.ObjectClass.DeepClone;

class Cat{
    int j;

    public Cat(int j) {
        this.j = j;
    }
}
class Dog implements Cloneable{
    Cat c ;
    int i ;

    public Dog(Cat c, int i) {
        this.c = c;
        this.i = i;
    }
    protected  Object clone() throws CloneNotSupportedException
    {
        Cat c1 = new Cat(c.j);
        Dog d1 = new Dog(c1,i);
        return  d1;

    }
}


public class DeepCloning {
    public static void main(String[] args) throws CloneNotSupportedException
    {
     Cat c = new Cat(10);
     Dog d = new Dog(c,20);
        System.out.println(d.i+"_______"+d.c.j);
        Dog d2 =(Dog) d.clone();
        d2.i=100;
        d2.c.j=199;
        System.out.println(d.i+"_______"+d.c.j);
        System.out.println(d2.i+"_______"+d2.c.j);


    }
}

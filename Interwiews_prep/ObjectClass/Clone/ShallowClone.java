package Interwiews_prep.ObjectClass.Clone;


class Cat{
    int cat;

    public Cat(int cat) {
        this.cat = cat;
    }
}
class Dog implements Cloneable{

    Integer dog;
     Cat c;
    public Dog(Cat c, Integer dog) {
        this.c = c;
        this.dog = dog;
    }
    protected  Object clone() throws CloneNotSupportedException
    {
        return  super.clone();

    }
}

public class ShallowClone {
    public static void main(String[] args) throws  CloneNotSupportedException
    {
        Cat c = new Cat(10);
        Dog d1 = new Dog(c,20);
        System.out.println(d1.dog +"_______"+d1.c.cat);
        Dog d2 = (Dog) d1.clone();
        d2.dog =100;
        d2.c.cat =199;
        System.out.println(d1.dog +"_______"+d1.c.cat);
        System.out.println(d2.dog +"_______"+d2.c.cat);
        System.out.println(d1.dog +"_______"+d1.c.cat);
        System.out.println("this ");

    }
}

package Interwiews_prep.Serialization.Externalization;

import java.io.*;

public class ExternalizationDemo implements Externalizable {

    transient String name ;
    int age ;
    int id ;

    public ExternalizationDemo() {
        System.out.println("ExternalizationDemo constructor");
    }

    public ExternalizationDemo(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        name = (String) in.readObject();
        age = in.readInt();
    }

    public static void main(String[] args) throws  Exception {
        ExternalizationDemo ed = new ExternalizationDemo("Kunal",20,101);
        System.out.println(ed.name+"_______"+ed.age+"_______"+ed.id);

        FileOutputStream fos = new FileOutputStream("ed.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(ed);


        FileInputStream fis = new FileInputStream("ed.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ExternalizationDemo ed1 = (ExternalizationDemo) ois.readObject();
        System.out.println(ed1.name+"_______"+ed1.age+"_______"+ed1.id);
        System.out.println(ed1.hashCode()+"________"+ed.hashCode());
        ;

    }
}

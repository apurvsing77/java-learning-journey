package Interwiews_prep.Serialization;

import java.io.*;

class Account implements Serializable{

    String username = "apurv_kumar";
    transient String password = "apurv";
    transient int age = 20;
    private void  writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        String ePassword = "123"+password;
        int eAge = age+10;
        out.writeObject(ePassword);
        out.writeInt(eAge);
    }
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        String epassword = (String) in.readObject();
        int eage = in.readInt();
        password = epassword.substring(3);
        age = eage-10;

    }
}


public class custSerializeDemo {
    public static void main(String[] args) throws Exception{

        Account acc = new Account();
        System.out.println(acc.username+"------"+acc.password+"-----"+acc.age);

        FileOutputStream fos = new  FileOutputStream("account.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(acc);

        FileInputStream fis = new FileInputStream("account.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Account acc1 = (Account) ois.readObject();
        System.out.println(acc1.username+"------"+acc1.password+"-----"+acc1.age);



    }
}

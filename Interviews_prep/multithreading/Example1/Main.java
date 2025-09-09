package Interviews_prep.multithreading.Example1;

public class Main {
    public static void main(String[] args) {
        PostBox postBox = new PostBox();
        OwnerThread ownerThread = new OwnerThread(postBox);
        PostManThread postManThread = new PostManThread(postBox,5);
        Thread t1 = new Thread(ownerThread);
        Thread t2 = new Thread(postManThread);
        t1.start();
        t2.start();
    }
}

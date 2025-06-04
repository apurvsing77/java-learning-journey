package Interwiews_prep.multithreading.basicExample;

class Mythread extends Thread{
    @Override
    public void run() {
        Thread.currentThread().setName("thread_t1");
        System.out.println("Run Method Thread: "+Thread.currentThread().getName());
    }
}
public class ThreadTest {
    public static void main(String[] args) {
        System.out.println("Check Current Thread: "+Thread.currentThread().getName() );
        Mythread t1 = new Mythread();
        System.out.println("Check Current Thread1: "+Thread.currentThread().getName() );
        Mythread t2 = new Mythread();
        System.out.println("Check Current Thread2: "+Thread.currentThread().getName() );
        Mythread t3 = new Mythread();
        System.out.println("Check Current Thread3: "+Thread.currentThread().getName() );
        Thread.currentThread().setName("Abc_Main");
        t1.start();
        t2.start();
        System.out.println("Check T2 Thread : "+t2.getName().toUpperCase() );

        t3.start();
        System.out.println("Check Current Thread After start: "+Thread.currentThread().getName() );
    }
}

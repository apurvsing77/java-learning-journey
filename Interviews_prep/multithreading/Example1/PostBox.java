package Interviews_prep.multithreading.Example1;

public class PostBox {

    private int mail = 0;
    private boolean hasMail = false;

    public synchronized void putMail(int count) {

        this.mail = count;
        System.out.println("Postman delivered mail: " + count);
        this.hasMail = true;
        notify();
    }

    public synchronized int getAllMail() {
        while (!hasMail) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        int receivedMail = this.mail;
        this.mail = 0;
        this.hasMail = false;
        notify();
        return receivedMail;
    }

    public synchronized int getOneMail() {
        while (!hasMail) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.mail = this.mail-1;
        if (this.mail == 0) {
            this.hasMail = false;
        }else {
            this.hasMail = true;
        }
        return this.mail;
    }
}

package Interviews_prep.multithreading.Example1;

public class PostManThread implements Runnable {

    int noOfMails;
    private PostBox postBox;
    private OwnerThread ownerThread;
    public PostManThread(PostBox postBox,int noOfMails){
       this.postBox = postBox;
       this.noOfMails = noOfMails;
    }

    @Override
    public void run() {
        postBox.putMail(noOfMails);
    }
}

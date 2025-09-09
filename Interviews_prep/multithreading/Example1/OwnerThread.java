package Interviews_prep.multithreading.Example1;

public class OwnerThread implements Runnable{

    private PostBox postBox;
    public OwnerThread(PostBox postBox){
        this.postBox=postBox;
    }

    @Override
    public void run() {
//       int mail = postBox.getAllMail();
//        System.out.println("Owner received All mail: "+mail);

        int remainMail = postBox.getOneMail();
        while (remainMail>0) {

            try {
                remainMail = postBox.getOneMail();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Owner received one mail and remaining mails are: "+remainMail);
        }
        System.out.println("Remaining mails are : "+remainMail);
    }
}

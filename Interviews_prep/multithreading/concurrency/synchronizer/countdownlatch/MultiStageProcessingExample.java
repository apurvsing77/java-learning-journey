package Interviews_prep.multithreading.concurrency.synchronizer.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiStageProcessingExample {
    public static void main(String[] args) throws InterruptedException {

        int numTask=10;
        AtomicInteger countSuccess = new AtomicInteger(0);
        CountDownLatch dataLoader = new CountDownLatch(numTask);

        //Stage 1 for Data Loading .....
        System.out.println("=== STAGE 1: Data Loading ===");
        for(int i = 1; i <= numTask ; i++) {
            int finalI = i;
            new Thread( new  DataLoader(finalI,dataLoader,countSuccess)).start();
        }

        dataLoader.await();
        System.out.println("\nStage 1 completed. Successful loads: " + countSuccess.get());

        // Stage 2: Data Processing
        CountDownLatch processLatch = new CountDownLatch(countSuccess.get());
        System.out.println("\n=== STAGE 2: Data Processing ===");

        for(int i = 1; i <= numTask ; i++) {
            int finalI = i;
            new Thread( new  DataProcesser(finalI,dataLoader)).start();
        }
        processLatch.await();
        System.out.println("\nAll stages completed successfully!");

    }

static class DataLoader implements Runnable{

    private final int taskId;
    private final CountDownLatch dataLoaderLatch;
    private final AtomicInteger successCount;

    public DataLoader(int taskId, CountDownLatch dataLoaderLatch, AtomicInteger successCount) {
        this.taskId = taskId;
        this.dataLoaderLatch = dataLoaderLatch;
        this.successCount = successCount;
    }

    @Override
    public void run() {

        try{
            System.out.println("Loading data for task " + taskId);
            Thread.sleep((long) (Math.random() * 2000));
             if (Math.random() < 0.8){
                 successCount.incrementAndGet();
                 System.out.println("Task " + taskId + " loaded successfully");
             }else {
                 System.out.println("Task " + taskId + " failed to load");
             }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }finally{
              dataLoaderLatch.countDown();
        }
    }
}

static class DataProcesser implements Runnable{

    private final int taskId;
    private final CountDownLatch dataProcesserlatch;

    public DataProcesser(int taskId, CountDownLatch latch) {
        this.taskId = taskId;
        this.dataProcesserlatch = latch;
    }

    @Override
    public void run() {
        try{
      System.out.println("Processing data for Task : "+taskId);
      Thread.sleep((long)(Math.random()*5000));

      System.out.println("Task " + taskId + " loaded successfully");


        }catch (InterruptedException e){

            Thread.currentThread().interrupt();

        }finally{
            dataProcesserlatch.countDown();
        }
    }
}
}
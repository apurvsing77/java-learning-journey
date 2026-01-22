package Interviews_prep.multithreading.concurrency.synchronizer.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

public class DistributedTransactionSimulator {

    public static void main(String[] args){

        System.out.println("=== DISTRIBUTED TRANSACTION SIMULATOR ===\n");
    int numNodes =5;
    int maxAttempts = 3;
    int timeoutSeconds =10;

        AtomicInteger currentAttempt = new AtomicInteger(1);

        AtomicInteger successCount = new AtomicInteger(0);

        CyclicBarrier commitBarrier = new CyclicBarrier(numNodes,
                () -> {
                    // This runs when all 5 nodes are ready to commit
                    System.out.println("\n✓ ALL " + numNodes + " nodes prepared successfully!");
                    System.out.println("Proceeding to commit phase...\n");
                });

        Thread[] nodes = new Thread[numNodes];
        for(int i = 0; i <nodes.length ; i++) {
            nodes[i] = new Thread(new DatabaseNode(
                    i + 1,
                    commitBarrier,
                    currentAttempt,
                    successCount,
                    maxAttempts,
                    timeoutSeconds
            ));
            nodes[i].start();
        }
        // Wait for all nodes to complete
        for (Thread node : nodes) {
            try {
                node.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("\n=== SIMULATION COMPLETE ===");

  }
  static class DatabaseNode implements Runnable{


      private final int nodeId;
      private final CyclicBarrier commitBarrier;
      private final AtomicInteger currentAttempt;
      private final AtomicInteger successCount;
      private final int maxAttempts;
      private final long timeoutSeconds;
      private volatile boolean transactionPrepared = false;
      private volatile boolean transactionCommitted = false;


      public DatabaseNode(int nodeId, CyclicBarrier commitBarrier, AtomicInteger currentAttempt, AtomicInteger successCount, int maxAttempts, int timeoutSeconds) {
          this.nodeId=nodeId;
          this.commitBarrier=commitBarrier;
          this.currentAttempt =currentAttempt;
          this.successCount=successCount;
          this.maxAttempts=maxAttempts;
          this.timeoutSeconds=timeoutSeconds;

      }


      @Override
      public void run() {
          System.out.println("Node " + nodeId + " starting attempt " + currentAttempt.get());
      for (int attempt = 1; attempt <= maxAttempts; attempt++) {
        try {
            System.out.printf("\nNode %d: Attempt %d/%d%n",nodeId, attempt, maxAttempts);

            // PHASE 1: PREPARE TRANSACTION (local work)
            if (!prepareTransaction()) {
                // This node failed to prepare
                System.out.println("Node " + nodeId + ": Preparation failed, breaking barrier");
                breakBarrier(); // Tell other nodes to abort
                continue; // Try again next attempt
            }

            // Mark that we're prepared
            transactionPrepared = true;

            // PHASE 2: WAIT FOR ALL NODES TO PREPARE
            System.out.println("Node " + nodeId + ": Waiting for other nodes...");

            try {
                // Wait for all nodes with timeout
                int arrivalIndex = commitBarrier.await(timeoutSeconds, TimeUnit.SECONDS);
                System.out.printf("Node %d: All nodes ready! (I arrived #%d)%n",
                        nodeId, arrivalIndex + 1);

            } catch (TimeoutException e) {
                // Some node took too long
                System.out.println("Node " + nodeId + ": TIMEOUT! Some node is too slow");
                rollbackTransaction();
                continue; // Try again

            } catch (BrokenBarrierException e) {
                // Barrier was broken by another node's failure
                System.out.println("Node " + nodeId + ": Barrier broken! Another node failed");
                rollbackTransaction();
                continue; // Try again
            }
            // PHASE 3: ALL PREPARED - NOW COMMIT
            if (commitTransaction()) {
                transactionCommitted = true;
                successCount.incrementAndGet();
                System.out.println("Node " + nodeId + ": ✓ TRANSACTION COMMITTED SUCCESSFULLY!");
                break; // Success! Exit retry loop
            } else {
                System.out.println("Node " + nodeId + ": Commit failed, will retry");
                rollbackTransaction();
            }

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
            System.out.println("Node " + nodeId + ": Interrupted!");
            rollbackTransaction();
            break;
        }
      }
          // Check final state
          if (!transactionCommitted) {
              System.out.println("Node " + nodeId + ": ✗ TRANSACTION FAILED after " + maxAttempts + " attempts");
          }
    }

      // Simulate preparing a transaction
      private boolean prepareTransaction() throws InterruptedException {
          System.out.println("Node " + nodeId + ": Preparing transaction...");

          // Simulate database work with random delay
          long workTime = 1000 + (long)(Math.random() * 3000);
          Thread.sleep(workTime);

          // Simulate random failure (20% chance)
          if (Math.random() < 0.2) {
              System.out.println("Node " + nodeId + ": ✗ PREPARE FAILED (simulated error)");
              return false;
          }

          System.out.printf("Node %d: ✓ Prepared in %d ms%n", nodeId, workTime);
          return true;
      }

      // Simulate committing a transaction
      private boolean commitTransaction() throws InterruptedException {
          System.out.println("Node " + nodeId + ": Committing transaction...");

          // Simulate commit work
          Thread.sleep(500 + (long)(Math.random() * 1000));

          // Small chance of commit failure (5%)
          if (Math.random() < 0.05) {
              System.out.println("Node " + nodeId + ": ✗ COMMIT FAILED (simulated error)");
              return false;
          }

          return true;
      }

      // Rollback if something went wrong
      private void rollbackTransaction() {
          if (transactionPrepared && !transactionCommitted) {
              System.out.println("Node " + nodeId + ": Rolling back transaction...");
              // Simulate rollback work
              try {
                  Thread.sleep(300);
                  System.out.println("Node " + nodeId + ": Rollback complete");
              } catch (InterruptedException e) {
                  Thread.currentThread().interrupt();
              }
              transactionPrepared = false;
          }
      }


      // Break the barrier if this node failed
      private void breakBarrier() {
          // Reset the barrier (breaks it for waiting threads)
          System.out.println("Node " + nodeId + ": Breaking barrier due to failure");
          commitBarrier.reset();
      }
  }
  }




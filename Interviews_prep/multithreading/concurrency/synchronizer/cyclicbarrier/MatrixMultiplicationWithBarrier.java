package Interviews_prep.multithreading.concurrency.synchronizer.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;
import java.util.Random;

public class MatrixMultiplicationWithBarrier {
    
    static class Matrix {
        private final int[][] data;
        private final int rows;
        private final int cols;
        
        Matrix(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
            this.data = new int[rows][cols];
        }
        
        void randomFill() {
            Random rand = new Random();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    data[i][j] = rand.nextInt(1,10);
                }
            }
        }
        
        void print() {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.printf("%4d", data[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }
        
        int get(int i, int j) { return data[i][j]; }
        void set(int i, int j, int value) { data[i][j] = value; }
        int getRows() { return rows; }
        int getCols() { return cols; }
    }
    
    public static void main(String[] args) throws InterruptedException {
        int size = 4; // Matrix size (N x N)
        int numThreads = size; // One thread per row
        
        Matrix A = new Matrix(size, size);
        Matrix B = new Matrix(size, size);
        Matrix C = new Matrix(size, size); // Result matrix
        
        A.randomFill();
        B.randomFill();
        
        System.out.println("Matrix A:");
        A.print();
        
        System.out.println("Matrix B:");
        B.print();
        
        // Create barrier for all threads + main thread for printing
        CyclicBarrier barrier = new CyclicBarrier(numThreads, 
            () -> {
                System.out.println("All rows computed! Result:");
                C.print();
                System.out.println("Starting next iteration...\n");
            });
        
        System.out.println("Starting parallel matrix multiplication...");
        
        // Create and start worker threads
        Thread[] workers = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            workers[i] = new Thread(new MatrixMultiplier(i, A, B, C, barrier));
            workers[i].start();
        }
        
        // Wait for all workers to complete
        for (Thread worker : workers) {
            worker.join();
        }
        
        System.out.println("Matrix multiplication completed!");
    }
    
    static class MatrixMultiplier implements Runnable {
        private final int row;
        private final Matrix A, B, C;
        private final CyclicBarrier barrier;
        
        MatrixMultiplier(int row, Matrix A, Matrix B, Matrix C, CyclicBarrier barrier) {
            this.row = row;
            this.A = A;
            this.B = B;
            this.C = C;
            this.barrier = barrier;
        }
        
        @Override
        public void run() {
            try {
                int cols = B.getCols();
                
                // Compute one row of the result matrix
                for (int j = 0; j < cols; j++) {
                    int sum = 0;
                    for (int k = 0; k < A.getCols(); k++) {
                        sum += A.get(row, k) * B.get(k, j);
                    }
                    C.set(row, j, sum);
                }
                
                System.out.printf("Thread for row %d completed computation%n", row);
                
                // Wait for all rows to be computed
                barrier.await();
                
            } catch (InterruptedException | BrokenBarrierException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread for row " + row + " interrupted!");
            }
        }
    }
}
package Interviews_prep.multithreading.concurrency.synchronizer.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class DatabaseConnectionPool {

        static class Connection{

            private final int id;
            private  boolean inUse;

            public Connection(int id) {
                this.id = id;

            }
            void executeQuery() throws InterruptedException {
                System.out.println("Connection " + id + " executing query...");
                Thread.sleep((long) (Math.random() * 3000));
            }

            public int getId() {
                return id;
            }

            public boolean isInUse() {
                return inUse;
            }
            public void setInUse(boolean inUse) {
                this.inUse = inUse;
            }
        }
    public static void main(String[] args){

            Connection[] connections = new Connection[5];
            for (int i = 0; i < connections.length; i++) {
                connections[i] = new Connection(i);
            }

        Semaphore semaphore = new Semaphore(2);
            for(int i = 1; i <= 15 ; i++) {
                Thread thread = new Thread(new DatabaseConnection(i, semaphore, connections));
                thread.start();
            }
    }

    static class DatabaseConnection implements Runnable{

        private final int clientId;
        private final Semaphore semaphore;
        private final Connection[] connections;

        public DatabaseConnection(int clientId, Semaphore semaphore, Connection[] connections) {
            this.clientId = clientId;
            this.semaphore = semaphore;
            this.connections = connections;
        }

        @Override
        public void run() {
            Connection connection = null;
            try {
               System.out.println("Client " + clientId + " waiting for connection...");

                boolean acquire = semaphore.tryAcquire(20, TimeUnit.SECONDS);

                if(!acquire){
                    System.out.println("Client " + clientId + " timeOut! could not acquire connection. ");
                    return;
                }
                connection = getAvailableConnection();
                if(connection == null){
                    System.out.println("Client " + clientId + "got permit but could not acquire connection. ");
                    semaphore.release();
                    return;
                }
                connection.executeQuery();
                System.out.println("Client " + clientId + " using connection " + connection.getId());

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Client " + clientId + " interrupted!");
            }finally{
                if(connection != null){
                    connection.setInUse(false);
                }
                semaphore.release();
            }
        }
        private synchronized Connection getAvailableConnection() {
            for (Connection conn : connections) {
                if (!conn.isInUse()) {
                    conn.setInUse(true);
                    return conn;
                }
            }
            return null;
        }
    }
}

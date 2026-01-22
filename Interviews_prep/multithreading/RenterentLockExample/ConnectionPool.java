package Interviews_prep.multithreading.RenterentLockExample;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private final ReentrantLock lock = new ReentrantLock(true); // Fair
    private final Condition hasConnections = lock.newCondition();
    private List<Connection> connections = new ArrayList<>();
    
    public Connection getConnection(long timeoutMs) throws InterruptedException, TimeoutException {
        lock.lock();
        try {
            long endTime = System.currentTimeMillis() + timeoutMs;
            
            while (connections.isEmpty()) {
                long remaining = endTime - System.currentTimeMillis();
                if (remaining <= 0) {
                    throw new TimeoutException("No connection available");
                }
                hasConnections.await(remaining, TimeUnit.MILLISECONDS);
            }
            
            return connections.remove(0);
        } finally {
            lock.unlock();
        }
    }
    
    public void releaseConnection(Connection conn) {
        lock.lock();
        try {
            connections.add(conn);
            hasConnections.signal();  // Better than notify()
        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) throws InterruptedException, TimeoutException {
        ConnectionPool pool = new ConnectionPool();
        pool.getConnection(10000);
        pool.releaseConnection(null);
    }
}

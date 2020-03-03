package fr.cnam.smb111.cours02.tp2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ClientTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        ReadWriteLock lock = new ReentrantReadWriteLock();

        lock.writeLock().lock();
        executor.submit(new Thread(new Client(ClientParameters.UP)));
        lock.writeLock().unlock();

        lock.readLock().lock();
        executor.submit(new Thread(new Client(ClientParameters.GET)));
        lock.readLock().unlock();

        lock.writeLock().lock();
        executor.submit(new Thread(new Client(ClientParameters.UP)));
        lock.writeLock().unlock();

        lock.readLock().lock();
        executor.submit(new Thread(new Client(ClientParameters.GET)));
        lock.readLock().unlock();


        lock.writeLock().lock();
        executor.submit(new Thread(new Client(ClientParameters.DOWN)));
        lock.writeLock().unlock();

        lock.readLock().lock();
        executor.submit(new Thread(new Client(ClientParameters.GET)));
        lock.readLock().unlock();

        lock.writeLock().lock();
        for (int i=0;i<100;i++)
            executor.submit(new Thread(new Client(ClientParameters.UP)));
        lock.writeLock().unlock();

        lock.readLock().lock();
        for (int i=0;i<5;i++)
                executor.submit(new Thread(new Client(ClientParameters.GET)));
        lock.readLock().unlock();

    }

}

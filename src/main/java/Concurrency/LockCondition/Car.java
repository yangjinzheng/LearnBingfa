package Concurrency.LockCondition;/**
 * Created by pc on 2018/2/27.
 */

import java.sql.Connection;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/27
 */
public class Car {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean waxon = false;
    public void waxed(){
        lock.lock();
        try{
            waxon = true;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
    public void buffed(){
        lock.lock();
       try{
           waxon = false;
           condition.signalAll();
       }finally {
           lock.unlock();
       }
    }
    public void waitforwaxing() throws InterruptedException {
        lock.lock();
        try {
            while(waxon==false){
                condition.await();
            }
        }finally {
            lock.unlock();
        }
    }
    public void waitforbuffering() throws InterruptedException {
        lock.lock();
        try{
            while(waxon==true){
                condition.await();
            }
        }finally {
            lock.unlock();
        }
    }
}

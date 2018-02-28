package Concurrency;/**
 * Created by pc on 2018/2/18.
 */

import Util.DaeminThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/18
 */
public class DaemonFromFactory implements Runnable {
    public void run() {
        try{
            while(true){
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread()+" "+this);
            }
        } catch (InterruptedException e) {
            System.out.print("Interpred");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool(new DaeminThreadFactory());
        for(int i=0;i<10;i++){
            exec.execute(new DaemonFromFactory());
        }
        System.out.println("All demons started");
        TimeUnit.MILLISECONDS.sleep(500);
    }
}

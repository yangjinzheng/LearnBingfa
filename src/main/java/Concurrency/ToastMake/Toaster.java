package Concurrency.ToastMake;/**
 * Created by pc on 2018/2/27.
 */

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/27
 */
public class Toaster implements Runnable {
    private ToastQueue toastqueue;
    private int count = 0;
    private Random rand = new Random(47);
    public Toaster(ToastQueue tq){toastqueue = tq;}
    public void run() {
        try{
            while(!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(100+rand.nextInt(500));
                Toast t = new Toast(count++);//刚出炉土司
                System.out.println(t);
                toastqueue.put(t);
            }
        } catch (InterruptedException e) {
            System.out.println("Toaster interrupt");
        }
        System.out.println("Toaster off");
    }
}

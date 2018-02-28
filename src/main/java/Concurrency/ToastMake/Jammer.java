package Concurrency.ToastMake;/**
 * Created by pc on 2018/2/27.
 */

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/27
 */
public class Jammer implements Runnable {
    private ToastQueue butterqueue,finishqueue;

    public Jammer(ToastQueue butterqueue, ToastQueue finishqueue) {
        this.butterqueue = butterqueue;
        this.finishqueue = finishqueue;
    }

    public void run() {
        try{
            while(!Thread.interrupted()){
                Toast t = butterqueue.take();
                t.jam();
                System.out.println(t);
                finishqueue.put(t);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("jam off");
    }
}

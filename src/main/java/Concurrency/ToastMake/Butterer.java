package Concurrency.ToastMake;/**
 * Created by pc on 2018/2/27.
 */

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/27
 */
public class Butterer implements Runnable{
    private ToastQueue dryqueue,butterqueue;
    public Butterer(ToastQueue dryqueue,ToastQueue butterqueue){
        this.dryqueue = dryqueue;
        this.butterqueue = butterqueue;
    }
    public void run() {
        try{
            while(!Thread.interrupted()){
                Toast t = dryqueue.take();
                t.butter();
                System.out.println(t);
                butterqueue.put(t);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("butter off");
    }
}

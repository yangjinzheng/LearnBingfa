package Concurrency.ToastMake;/**
 * Created by pc on 2018/2/27.
 */

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/27
 */
public class Eater implements Runnable {
    private ToastQueue finishqueue;
    private int counter = 0;

    public Eater(ToastQueue finishqueue) {
        this.finishqueue = finishqueue;
    }

    public void run() {
       try{
           while(!Thread.interrupted()){
               Toast t = finishqueue.take();
               if(t.getID()!=counter++||t.getStatus()!=Toast.Status.JAMMED){
                   System.exit(1);//检验土司是否合格
               }else {
                   System.out.println("chomp"+t);
               }
           }
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       System.out.println("Eater off");
    }
}

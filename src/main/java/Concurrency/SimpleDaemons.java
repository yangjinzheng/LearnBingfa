package Concurrency;/**
 * Created by pc on 2018/2/18.
 */

import java.util.concurrent.TimeUnit;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/18
 */
public class SimpleDaemons implements Runnable {
    public void run() {
        try{
            while(true){
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread()+" "+this);
            }
        } catch (InterruptedException e) {
            System.out.print("time zhongduan");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<10;i++){
            Thread demon = new Thread(new SimpleDaemons());
            demon.setDaemon(true);//在线程启动之前调用该方法才能把它设置为后台线程
            demon.start();
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}

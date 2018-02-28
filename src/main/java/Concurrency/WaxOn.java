package Concurrency;/**
 * Created by pc on 2018/2/25.
 */

import java.util.concurrent.TimeUnit;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/25
 */
public class WaxOn implements Runnable {
    private Car car;
    public WaxOn(Car c){car = c;}
    public void run() {
        try{
            while(!Thread.interrupted()){
                System.out.println("wax on");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffering();
            }
        } catch (InterruptedException e) {
            System.out.println("Exit");
        }
    }
}

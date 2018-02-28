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
public class WaxOff implements Runnable {
    private Car car;
    public WaxOff(Car car){car = car;}
    public void run() {
        try{
            while(!Thread.interrupted()){
                car.waitForWxing();
                System.out.println("wax off");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffered();
            }
        } catch (InterruptedException e) {
            System.out.println("ending wax off task");
        }
    }
}

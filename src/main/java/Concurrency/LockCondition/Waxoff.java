package Concurrency.LockCondition;/**
 * Created by pc on 2018/2/27.
 */

import Concurrency.WaxOff;

import java.util.concurrent.TimeUnit;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/27
 */
public class Waxoff implements Runnable {
    private Car car;
    public Waxoff(Car c){
        car = c;
    }
    public void run() {
        try{
            while(!Thread.interrupted()){
                car.waitforwaxing();
                System.out.println("waxoff");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch (InterruptedException e) {
            System.out.println("exit via");
        }
        System.out.println("ending wax off");
    }
}

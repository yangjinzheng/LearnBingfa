package Concurrency.LockCondition;/**
 * Created by pc on 2018/2/27.
 */

import Concurrency.WaxOn;

import java.util.concurrent.TimeUnit;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/27
 */
public class Waxon implements Runnable {
    private Car car;
    public Waxon(Car c){car = c;}
    public void run() {
        try{
            while(!Thread.interrupted()){
                System.out.println("Waxon");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitforbuffering();
            }
        } catch (InterruptedException e) {
            System.out.println("exit via");
        }
    }
}

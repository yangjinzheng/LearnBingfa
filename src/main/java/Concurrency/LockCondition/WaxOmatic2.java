package Concurrency.LockCondition;/**
 * Created by pc on 2018/2/27.
 */

import Concurrency.WaxOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/27
 */
public class WaxOmatic2 {
    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Waxoff(car));
        exec.execute(new Waxon(car));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}

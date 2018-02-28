package Concurrency;/**
 * Created by pc on 2018/2/25.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/25
 */
public class OranamentalGarden {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            exec.execute(new Entrance(i));
        }
        TimeUnit.SECONDS.sleep(3);
        Entrance.cancel();
        exec.shutdown();
        if(!exec.awaitTermination(250,TimeUnit.MILLISECONDS)){
            System.out.print("Some tasks were not terminated");
        }
        System.out.println("Total"+Entrance.getTotalValue());
        System.out.println(Entrance.sumEntrances());
    }
}

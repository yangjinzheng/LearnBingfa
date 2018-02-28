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
public class InterruptingIdiom {
    public static void main(String[] args) throws InterruptedException {
        if(args.length!=1){
            System.exit(1);
        }
        Thread t = new Thread(new Blocked());
        t.start();
        TimeUnit.MILLISECONDS.sleep(new Integer(args[0]));
        t.interrupt();
    }
}

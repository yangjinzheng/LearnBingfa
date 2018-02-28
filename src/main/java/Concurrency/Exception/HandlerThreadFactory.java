package Concurrency.Exception;/**
 * Created by pc on 2018/2/23.
 */

import java.util.concurrent.ThreadFactory;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/23
 */
public class HandlerThreadFactory implements ThreadFactory {

    public Thread newThread(Runnable r) {
        System.out.println(this+"creating new thread");
        Thread t = new Thread(r);
        System.out.println("created"+t);
        t.setUncaughtExceptionHandler(new MyUncaughtException());
        System.out.println("eh = "+t.getUncaughtExceptionHandler());
        return t;
    }
}

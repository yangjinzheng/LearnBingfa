package Concurrency.Exception;/**
 * Created by pc on 2018/2/23.
 */

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/23
 */
public class ExceptionThread implements Runnable {
    public void run() {
        Thread t = Thread.currentThread();
        System.out.print("run() by"+t);
        System.out.print("en = "+t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}

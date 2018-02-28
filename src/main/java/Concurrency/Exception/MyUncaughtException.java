package Concurrency.Exception;/**
 * Created by pc on 2018/2/23.
 */

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/23
 */
public class MyUncaughtException implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught"+e);
    }
}

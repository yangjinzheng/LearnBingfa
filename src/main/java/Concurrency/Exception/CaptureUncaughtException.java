package Concurrency.Exception;/**
 * Created by pc on 2018/2/23.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/23
 */
public class CaptureUncaughtException {
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread());
    }
}

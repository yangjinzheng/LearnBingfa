package Concurrency.ToastMake;/**
 * Created by pc on 2018/2/27.
 */

import Concurrency.Entrance;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/27
 */
public class ToastMatic {
    public static void main(String[] args) throws InterruptedException {
        ToastQueue dryqueue = new ToastQueue(),//未处理土司队列
        butterqueue = new ToastQueue(),//加奶油队列
        finishqueue = new ToastQueue();//加果酱完成队列
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryqueue));
        exec.execute(new Butterer(dryqueue,butterqueue));
        exec.execute(new Jammer(butterqueue,finishqueue));
        exec.execute(new Eater(finishqueue));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}

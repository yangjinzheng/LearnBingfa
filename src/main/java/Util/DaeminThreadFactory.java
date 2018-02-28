package Util;/**
 * Created by pc on 2018/2/18.
 */

import java.util.concurrent.ThreadFactory;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/18
 */
public class DaeminThreadFactory implements ThreadFactory {

    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}

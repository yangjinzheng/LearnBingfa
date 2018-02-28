package Util;/**
 * Created by pc on 2018/2/24.
 */

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/24
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;//为了保证可视性，cancel标志是volatile的
    public abstract int next();
    public void cancel(){
      canceled = true;
    }
    public boolean isCanceled(){return canceled;}
}

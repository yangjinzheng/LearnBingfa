package Concurrency;/**
 * Created by pc on 2018/2/24.
 */

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/24
 */
public class SynObject {
    public static void main(String[] args){
        final DualSynch ds =new DualSynch();
        new Thread(){
            public void run(){
                ds.f();
            }
        }.start();
        ds.g();
    }
}

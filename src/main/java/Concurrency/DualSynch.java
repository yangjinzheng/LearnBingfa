package Concurrency;/**
 * Created by pc on 2018/2/24.
 */

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/24
 */
public class DualSynch {
    public Object synobject = new Object();
    public synchronized void f(){
        for(int i=0;i<5;i++){
            System.out.println("f{}");
            Thread.yield();
        }
    }
    public void g(){
        synchronized (synobject){
            for(int i=0;i<5;i++){
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}

package Concurrency;/**
 * Created by pc on 2018/2/25.
 */

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/25
 */
public class Car {
    private boolean waxon = false;
    public synchronized void waxed(){
        waxon = true;
        notifyAll();
    }
    public synchronized void buffered(){
        waxon = false;
        notifyAll();
    }
    public synchronized void waitForWxing() throws InterruptedException {
        while (waxon==false){
            wait();
        }
    }
    public synchronized void waitForBuffering() throws InterruptedException {
        while(waxon==true){
            wait();
        }
    }
}

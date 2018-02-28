package Util;/**
 * Created by pc on 2018/2/20.
 */

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/20
 */
public class Sleeper extends Thread {
    private int duration;
    public Sleeper(String name,int sleepTime){
        super(name);
        duration = sleepTime;
        start();
    }
    public void run(){
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.print(getName()+"was interrupted."+"isInterrupted:"+isInterrupted());
            return;
        }
        System.out.print(getName()+"has awaking");
    }
}

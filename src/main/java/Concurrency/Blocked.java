package Concurrency;/**
 * Created by pc on 2018/2/25.
 */

import java.util.concurrent.TimeUnit;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/25
 */
public class Blocked implements Runnable {
    private volatile double d = 0.0;
    public void run() {
        try{
            while(!Thread.interrupted()){
                NeedCleanUp n1 = new NeedCleanUp(1);
                try{
                    System.out.println("sleeping");
                    TimeUnit.SECONDS.sleep(1);
                    NeedCleanUp n2 = new NeedCleanUp(2);
                    try{
                        System.out.println("Calculating");
                        for(int i=1;i<2500000;i++){
                            d = d+(Math.PI+Math.E)/d;}
                            System.out.println("finished oprateration");

                    }finally {
                        n2.cleanup();
                    }
                } finally {
                    n1.cleanup();
                }
            }
            System.out.println("Exiting via while() test");
        }catch (InterruptedException e){
            System.out.println("exiting InterExecption");
        }

    }
}

package Concurrency;/**
 * Created by pc on 2018/2/21.
 */

import java.io.IOException;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/21
 */
public class ResponsiveUi extends Thread {
    private static volatile double d = 1;
    public ResponsiveUi(){
        setDaemon(true);
        start();
    }
    public void run(){
        while (true){
            d = d+(Math.PI+Math.E)/d;
        }
    }
    public static void main(String[] args) throws IOException {
        new ResponsiveUi();
        System.in.read();
        System.out.println(d);
    }
}

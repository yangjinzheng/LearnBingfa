package Concurrency;/**
 * Created by pc on 2018/2/17.
 */

import Util.Listoff;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/17
 */
public class BasicThreads {
    public static void main(String[] args){
        Thread t = new Thread(new Listoff());
        t.start();
        System.out.print("waiting for listoff");
    }
}

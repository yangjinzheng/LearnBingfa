package Concurrency;/**
 * Created by pc on 2018/2/24.
 */

import Util.IntGenerator;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/24
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenvalue = 0;
    public synchronized int next() {
        ++currentEvenvalue;
        Thread.yield();
        ++currentEvenvalue;
        return currentEvenvalue;
    }
    public static void main(String[] args){
        Evenchecker.test(new EvenGenerator());
    }
}

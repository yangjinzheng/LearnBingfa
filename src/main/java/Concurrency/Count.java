package Concurrency;/**
 * Created by pc on 2018/2/25.
 */

import java.util.Random;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/25
 */
class Count {
    private int count = 0;
    private Random rand = new Random(47);
    public synchronized int increment(){
        int temp = count;
        if(rand.nextBoolean()){
            Thread.yield();

        }
        return (count = ++temp);
    }
    public synchronized int value(){return count;}
}

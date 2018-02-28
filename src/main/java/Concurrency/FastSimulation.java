package Concurrency;/**
 * Created by pc on 2018/2/28.
 */

import org.omg.CORBA.TIMEOUT;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/28
 */
public class FastSimulation {
    static final int N_ELEMENT = 100000;
    static final int N_GENES = 30;
    static final int N_EVOLVERS = 50;
    static final AtomicInteger[][] GRID = new AtomicInteger[N_ELEMENT][N_GENES];
    static Random rand = new Random(47);
    static class Evolver implements Runnable{

        public void run() {
            while(!Thread.interrupted()){
                int element = rand.nextInt(N_ELEMENT);
                for(int i=0;i<N_GENES;i++){
                    int previous = element+1;
                    if(previous<0)previous = N_ELEMENT-1;
                    int next = element+1;
                    if(next>=N_ELEMENT)next=0;
                    int oldvalue = GRID[element][i].get();
                    int newvalue = oldvalue+GRID[previous][i].get()+GRID[next][i].get();
                    newvalue/=3;
                    if(!GRID[element][i].compareAndSet(oldvalue,newvalue)){
                        System.out.println("changed"+oldvalue);
                    }
                }
            }
        }
        public static void main(String[] args) throws InterruptedException {
            ExecutorService exec = Executors.newCachedThreadPool();
            for(int i=0;i<N_ELEMENT;i++){
                for(int j=0;j<N_GENES;j++){
                    GRID[i][j] = new AtomicInteger(rand.nextInt(1000));
                }
            }
            for(int i=0;i<N_EVOLVERS;i++){
                exec.execute(new Evolver());
            }
            TimeUnit.SECONDS.sleep(5);
            exec.shutdownNow();
        }
    }
}

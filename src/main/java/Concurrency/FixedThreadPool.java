package Concurrency;/**
 * Created by pc on 2018/2/17.
 */

import Util.Listoff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/17
 */
public class FixedThreadPool {
    public static void main(String[] args){
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for(int i=0;i<5;i++){
            exec.execute(new Listoff());
            exec.shutdown();
        }
    }
}

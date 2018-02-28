package Concurrency;/**
 * Created by pc on 2018/2/24.
 */

import Util.IntGenerator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/24
 */
public class Evenchecker implements Runnable {
    private IntGenerator generator;
    private final int id;
    public Evenchecker(IntGenerator generator,int ident) {
        this.generator = generator;
        id = ident;
    }

    public void run() {
        while (!generator.isCanceled()){
            int val = generator.next();
            if(val%2==0){
                System.out.println(val+"not even");
                generator.cancel();
            }
        }

    }
    public static void test(IntGenerator gp,int count){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0;i<count;i++){
            exec.execute(new Evenchecker(gp,i));
            exec.shutdown();
        }
    }
    public static void test(IntGenerator gp){
        test(gp,10);
    }
}

package Util;/**
 * Created by pc on 2018/2/20.
 */

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/20
 */
public class Joiner extends Thread {
   private Sleeper sleeper;
   public Joiner(String name,Sleeper sleeper){
        super(name);
        this.sleeper = sleeper;
        start();
   }
   public void run(){
       try{
           sleeper.join();
       } catch (InterruptedException e) {
           System.out.print("Interrupted");
       }
       System.out.print(getName()+"join completed");
   }
}

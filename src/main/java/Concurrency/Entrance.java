package Concurrency;/**
 * Created by pc on 2018/2/25.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/25
 */
public class Entrance implements Runnable {
    private static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<Entrance>();
    private int number = 0;
    private final int id;
    private static volatile boolean canceled = false;

    public Entrance(int id) {
        this.id = id;
        entrances.add(this);
    }

    public static void cancel(){canceled = true;}
    public void run() {
        while(!canceled){
            synchronized (this){
                ++number;
            }
            System.out.println(this+"total"+count.increment());
            try{
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("intreruppt");
            }
        }
        System.out.println("stop"+this);
    }
    public synchronized int getValue(){return number;}
    public String tostring(){
        return "Entrance"+id+":"+getValue();
    }
    public static int getTotalValue(){return count.value();}
    public static int sumEntrances(){
        int sum = 0;
        for(Entrance entrance:entrances){
            sum+=entrance.getValue();
        }
        return sum;
    }
}

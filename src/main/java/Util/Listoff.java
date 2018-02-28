package Util;/**
 * Created by pc on 2018/2/17.
 */

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/17
 */
public class Listoff implements Runnable {
    protected int countdown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;//一但初始化不希望被修改
    public Listoff(){

    }
    public Listoff(int countdown){
        this.countdown = countdown;
    }
    public String status(){
        return "#"+id+"("+(countdown>0?countdown:"Listoff!")+").";
    }
    public void run() {
        while(countdown-->0){
            System.out.print(status());
            Thread.yield();//将cpu从一个线程转移到另一个线程
        }
    }
}

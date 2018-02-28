package Concurrency;/**
 * Created by pc on 2018/2/20.
 */

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/20
 */
public class SelManaged implements Runnable{
    private int countDown = 5;
    private Thread t = new Thread(this);
    public SelManaged(){t.start();}
    public String toString(){
        return Thread.currentThread().getName()+"("+countDown+"),";
    }
    public void run() {
        while (true){
            System.out.print(this);
            if(--countDown==0){
                return;
            }
        }
    }
    public static void main(String[] args){
        for(int i=0;i<5;i++){
            new SelManaged();
        }
    }
}

/**
 * Created by pc on 2018/2/27.
 */

import javafx.scene.shape.Sphere;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/27
 */
public class Pool<T> {
    private int size;
    private List<T> items = new ArrayList<T>();
    private volatile boolean[] checkedout;
    private Semaphore available;
    public Pool(Class<T> classobject,int size){
        this.size = size;
        checkedout = new boolean[size];
        available = new Semaphore(size,true);
        for(int i=0;i<size;++i){
            try{
                items.add(classobject.newInstance());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
    public T checkout() throws InterruptedException {
        available.acquire();
        return getItem();
    }
    public void checkin(T x){
        if(releaseItem(x)){
            available.release();
        }
    }
    public synchronized T getItem(){
        for(int i=0;i<size;i++){
            if(!checkedout[i]){
                checkedout[i] = true;
                return items.get(i);
            }
        }
        return null;
    }
    public synchronized boolean releaseItem(T item){
        int index = items.indexOf(item);
        if(index==-1){
            return false;
        }
        if(checkedout[index]){
            checkedout[index] = false;
            return true;
        }
        return false;
    }
}

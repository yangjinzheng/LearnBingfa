package Util;/**
 * Created by pc on 2018/2/17.
 */

import java.util.concurrent.Callable;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/17
 */
public class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id){
        this.id = id;
    }
    public String call() throws Exception {
        return "result od TaskWithResult"+id;
    }
}

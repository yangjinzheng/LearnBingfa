package Concurrency;/**
 * Created by pc on 2018/2/25.
 */

import java.net.SocketPermission;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/25
 */
public class NeedCleanUp {
    private final int id;

    public NeedCleanUp(int id) {
        this.id = id;
        System.out.println("Needs"+id);
    }
    public void cleanup(){
        System.out.println("cleanup"+id);
    }
}

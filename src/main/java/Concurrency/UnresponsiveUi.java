package Concurrency;/**
 * Created by pc on 2018/2/21.
 */

import java.io.IOException;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/21
 */
public class UnresponsiveUi {
    private volatile double d = 1;
    public UnresponsiveUi() throws IOException {
        while(d>0){
            d = d+(Math.PI+Math.E)/d;
            System.in.read();
        }
    }
}

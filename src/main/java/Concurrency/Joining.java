package Concurrency;/**
 * Created by pc on 2018/2/20.
 */

import Util.Joiner;
import Util.Sleeper;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/20
 */
public class Joining {
    public static void main(String[] args){
        Sleeper
                sleeper = new Sleeper("sleeper",1500),
                grumpy = new Sleeper("Grumpy",1500);
        Joiner
                dopey = new Joiner("Dopey",sleeper),
                doc = new Joiner("Doc",grumpy);
        grumpy.interrupt();

    }
}

package Concurrency.ToastMake;/**
 * Created by pc on 2018/2/27.
 */

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/02/27
 */
public class Toast {
    public enum Status {DRY,BUTTERED,JAMMED}
    private Status status = Status.DRY;
    private final int id;
    public Toast(int idm){id = idm;}
    public void butter(){status = Status.BUTTERED;}
    public void jam(){status = Status.JAMMED;}
    public Status getStatus(){return status;}
    public int getID(){return id;}
    public String toString(){
        return "Toast"+id+status;
    }
}

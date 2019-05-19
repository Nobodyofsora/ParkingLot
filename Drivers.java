package Parking;
import java.util.Date;

public class Drivers{
    private Date in;
    private Date out;
    private int id=0;

    public Drivers(Date in){
        this.in= in;
    }
   
    public long getIn() {
        return in.getTime();
    }
    public void setIn(Date in) {
        this.in = in;
    }
    public long getOut() {
        return out.getTime();
    }
    public void setOut(Date out) {
        this.out = out;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}
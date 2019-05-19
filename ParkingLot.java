package Parking;
import java.util.Date;

public class ParkingLot {
    public int availableSpots;
    public boolean isItACar;
    public Drivers[] user;

    public ParkingLot(){
        this.availableSpots=50;
        this.user=new Drivers[availableSpots];
    }
    public boolean addVehicle(boolean vehicle, Date in, int id) throws Exception {
        if (this.availableSpots==0) return false;
        if (vehicle) this.availableSpots--;
        else if (this.availableSpots>=3)this.availableSpots-= 3;
        for (int i=0;i<this.user.length;i++){
            if(this.user[i]==null) continue;
            if (id==this.user[i].getId()) throw new Exception("Vehicle already parked");
            this.user[i].setId(id);
            this.user[i].setIn(in);
        }
        return true;
    }
    public double removeVehicle(boolean vehicle, int id){
        double fee=0;
        long time1, time2;
        if(vehicle)this.availableSpots++;
        else this.availableSpots+=3;
        for (int i=0;i<this.user.length;i++){
            if (id==this.user[i].getId()){
                time1= this.user[i].getIn();
                time2= this.user[i].getOut();
                fee=calculateFee(time1, time2)/100;
                this.user[i]=null;
            }
        }     
        return fee;
    }
    public double calculateFee(long in, long out){
        double fee=(double) (in - out)/(1000*60);
         if (fee<200) return fee;
         if (fee>200 && fee<240) return 200;
         if (fee>240 && fee<360) return 200 + (fee-240);
         if (fee>360) return 600;
         return 0;
    }
    @Override
    public String toString() {
        String s="Capacity:\n";
        s+="_________\n";
        for (int i=5;i>this.availableSpots/10;i--){
            s+="▓";
            if (i==0) s+="\n Full capacity reached";
        }
        s+="\n¯¯¯¯¯¯¯¯¯";
        return s;
        }
    
}
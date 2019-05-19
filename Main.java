package Parking;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        ParkingLot parkingLot = new ParkingLot();
        SimpleDateFormat hours = new SimpleDateFormat("HH:mm:ss");
        try{
            Date enteringParkingLotAt = hours.parse("10:10:10");
            for (int i=0; i<40;i++) {
                parkingLot.addVehicle(true,enteringParkingLotAt, i );
            }
            System.out.println(parkingLot.toString());
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
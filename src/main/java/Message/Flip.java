package Message;

import Common.Communicator;
import Common.DroneState;
import Common.CommandValuesCollection;
import Common.SendReceive;

import java.util.Scanner;

public class Flip implements Message {
    public void doAction(Communicator communicator, DroneState droneState) throws Exception{
        String command = null;
        //DroneState droneState= new DroneState();
        if(droneState.isInCommandMode()) {
            if((droneState.getBatteryPercentage())>20) {
                Scanner cin = new Scanner(System.in);
                System.out.println("Enter the type of flip from the following option\n" + "l = left\n r = right\n f = forward\n b = back\n bl = back/left\n rb =" +
                        " back/right)\n fl = front/left\n fr = front/right");
                String xx = cin.next();
                command = CommandValuesCollection.FLIP + " " + xx;
            }
            else {
                Scanner cin = new Scanner(System.in);
                System.out.println("Enter the distance value in cm between 20-500 ");
                int xx= cin.nextInt();
                command= CommandValuesCollection.LEFT+" "+xx;
            }
            SendReceive.sendReceiveCommon(command,communicator);
        }
        else System.out.println("Drone is not in command mode");
    }
}

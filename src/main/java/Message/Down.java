package Message;

import Common.Communicator;
import Common.CommandValuesCollection;
import Common.DroneState;
import Common.SendReceive;

import java.util.Scanner;

public class Down implements Message {
    public void doAction(Communicator communicator, DroneState droneState) throws Exception{
        Scanner cin =new Scanner(System.in);
        System.out.println("Enter the distance value in cm between 20-500 ");
        int xx= cin.nextInt();
        String command= CommandValuesCollection.DOWN +" "+xx;

        String reply= SendReceive.sendReceiveCommon(command,communicator);
        if(reply.equals("ok")){
            droneState.move(0,0,-xx);
        }

    }
}

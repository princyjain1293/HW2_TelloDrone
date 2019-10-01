package Message;

import Common.Communicator;
import Mission.CommandValuesCollection;
import Mission.SendReceive;

import java.util.Scanner;

public class Down implements Message {
    public void doAction(Communicator communicator) throws Exception{
        Scanner cin =new Scanner(System.in);
        System.out.println("Enter the distance value in cm between 20-500 ");
        int xx= cin.nextInt();
        String command= CommandValuesCollection.DOWN +" "+xx;

        SendReceive.SendReceiveCommon(command,communicator);

    }
}

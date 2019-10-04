package Message;

import Common.Communicator;
import Common.CommandValuesCollection;
import Common.SendReceive;

import java.util.Scanner;

public class Right implements Message {
    public void doAction(Communicator communicator) throws Exception{
        Scanner cin =new Scanner(System.in);
        System.out.println("Enter the distance value in cm between 20-500 ");
        int xx= cin.nextInt();
        String command= CommandValuesCollection.RIGHT +" "+xx;

        SendReceive.sendReceiveCommon(command,communicator);

    }
}

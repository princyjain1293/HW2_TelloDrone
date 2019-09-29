package Message;

import DroneAccessors.Communicator;
import Mission.CommandValuesCollection;
import Mission.SendReceive;

import java.util.Scanner;

public class Flip implements Message {
    public void doAction(Communicator communicator) throws Exception{
        Scanner cin =new Scanner(System.in);
        System.out.println("Enter the type of flip from the following option\n"+"l = left\n r = right\n f = forward\n b = back\n bl = back/left\n rb =" +
                " back/right)\n fl = front/left\n fr = front/right");
        String xx= cin.next();
        String command= CommandValuesCollection.FLIP +" "+xx;

        SendReceive.SendReceiveCommon(command,communicator);

    }
}

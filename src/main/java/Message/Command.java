package Message;

import Common.Communicator;
import Common.CommandValuesCollection;
import Common.DroneState;
import Common.SendReceive;

public class Command implements Message {
    String command;
//    public void Validation(){
//
//    }
    public final void doAction(Communicator communicator, DroneState droneState) throws Exception{
        command=CommandValuesCollection.COMMAND_MODE;
        String reply=SendReceive.sendReceiveCommon(command, communicator);
        if(reply.equals("ok")){
            droneState.setInCommandMode(true);
        }
    }
    public String getCommand(){return CommandValuesCollection.COMMAND_MODE;}
}

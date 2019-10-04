package Message;

import Common.Communicator;
import Common.CommandValuesCollection;
import Common.SendReceive;

public class Command implements Message {
    String command;
//    public void Validation(){
//
//    }
    public final void doAction(Communicator communicator) throws Exception{
        command=CommandValuesCollection.COMMAND_MODE;
        SendReceive.sendReceiveCommon(command, communicator);
    }
    public String getCommand(){return CommandValuesCollection.COMMAND_MODE;}
}

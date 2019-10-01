package Message;

import DroneAccessors.Communicator;
import Mission.CommandValuesCollection;
import Mission.SendReceive;

public class Command implements Message {
    String command;
    public void doAction(Communicator communicator) throws Exception{
        command=CommandValuesCollection.COMMAND_MODE;
        SendReceive.SendReceiveCommon(command, communicator);
    }
    public String getCommand(){return command;}
}

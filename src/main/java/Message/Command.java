package Message;

import DroneAccessors.Communicator;
import Mission.CommandValuesCollection;
import Mission.SendReceive;

public class Command implements Message {
    public void doAction(Communicator communicator) throws Exception{
        SendReceive.SendReceiveCommon(CommandValuesCollection.COMMAND_MODE, communicator);


    }
}

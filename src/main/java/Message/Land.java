package Message;

import DroneAccessors.Communicator;
import Message.Message;
import Mission.CommandValuesCollection;
import Mission.SendReceive;

public class Land implements Message {
    @Override
    public void doAction(Communicator communicator) throws Exception{
        SendReceive.SendReceiveCommon(CommandValuesCollection.LAND,communicator);

    }
}

package Message;

import Common.Communicator;
import Mission.CommandValuesCollection;
import Mission.SendReceive;

public class Land implements Message {
    @Override
    public void doAction(Communicator communicator) throws Exception{
        SendReceive.SendReceiveCommon(CommandValuesCollection.LAND,communicator);

    }
}

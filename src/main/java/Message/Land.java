package Message;

import Common.Communicator;
import Common.CommandValuesCollection;
import Common.SendReceive;

public class Land implements Message {
    @Override
    public final void doAction(Communicator communicator) throws Exception{
        SendReceive.sendReceiveCommon(CommandValuesCollection.LAND,communicator);



    }
}

package Message;

import Common.Communicator;
import Common.CommandValuesCollection;
import Common.SendReceive;

public class Takeoff implements Message {
    @Override
    public final void doAction(Communicator communicator) throws Exception{

        SendReceive.sendReceiveCommon(CommandValuesCollection.TAKE_OFF,communicator);

    }
}

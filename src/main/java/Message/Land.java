package Message;

import Common.Communicator;
import Common.CommandValuesCollection;
import Common.DroneState;
import Common.SendReceive;

public class Land implements Message {
    @Override
    public final void doAction(Communicator communicator, DroneState droneState) throws Exception{
        String reply=SendReceive.sendReceiveCommon(CommandValuesCollection.LAND,communicator);
        if(reply.equals("ok")){
            droneState.resetState();
        }
    }
    public String getCommand(){return CommandValuesCollection.LAND;}
}

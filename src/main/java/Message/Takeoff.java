package Message;

import Common.Communicator;
import Common.CommandValuesCollection;
import Common.DroneState;
import Common.SendReceive;

public class Takeoff implements Message {
    @Override
    public final void doAction(Communicator communicator, DroneState droneState) throws Exception{

        String reply=SendReceive.sendReceiveCommon(CommandValuesCollection.TAKE_OFF,communicator);
        if(reply.equals("ok")){
            droneState.setHasTakenOff(true);
        }
    }
    public String getCommand(){return CommandValuesCollection.TAKE_OFF;}
}

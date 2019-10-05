package Mission;

import Common.CommandValuesCollection;
import Common.Communicator;
import Common.DroneState;
import Common.MessageCaller;

public class SupersonicMission extends Mission {


    @Override
    public void executeCommand(Communicator communicator, DroneState droneState) throws Exception {
        String[] requestArray={CommandValuesCollection.FLIP,CommandValuesCollection.RIGHT,CommandValuesCollection.FLIP,CommandValuesCollection.LEFT};
        MessageCaller.commandSelecter(requestArray,communicator,droneState);
    }
//    public void fly(Communicator communicator) throws Exception {
//        String[] requestArray={CommandValuesCollection.COMMAND_MODE,CommandValuesCollection.TAKE_OFF,CommandValuesCollection.FLIP,CommandValuesCollection.RIGHT,CommandValuesCollection.FLIP,CommandValuesCollection.LEFT,CommandValuesCollection.LAND};
//        MessageCaller.commandSelecter(requestArray,communicator);
//
////        for(int i=0;i<requestArray.length;i++) {
////            //System.out.println("You are going on a Supersonic Simulator.Message.MessageCaller....");
////            SendReceive.sendReceiveCommon(requestArray[i], communicator);
////        }
//    }
}

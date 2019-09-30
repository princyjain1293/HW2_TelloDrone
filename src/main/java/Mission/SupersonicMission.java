package Mission;

import DroneAccessors.Communicator;
import Message.*;

public class SupersonicMission implements Mission {
    public void fly(Communicator communicator) throws Exception {
        String[] requestArray={CommandValuesCollection.COMMAND_MODE,CommandValuesCollection.TAKE_OFF,CommandValuesCollection.FLIP,CommandValuesCollection.RIGHT,CommandValuesCollection.FLIP,CommandValuesCollection.LEFT,CommandValuesCollection.LAND};
        MessageCaller.fly(requestArray,communicator);

//        for(int i=0;i<requestArray.length;i++) {
//            //System.out.println("You are going on a Supersonic Simulator.Message.MessageCaller....");
//            SendReceive.SendReceiveCommon(requestArray[i], communicator);
//        }
    }
}

package Mission;

import DroneAccessors.Communicator;
import Message.MessageCaller;

public class BouncyMission implements Mission {
    public void fly(Communicator communicator) throws Exception{

        String[] requestArray={CommandValuesCollection.COMMAND_MODE,CommandValuesCollection.TAKE_OFF,CommandValuesCollection.UP,CommandValuesCollection.DOWN,CommandValuesCollection.UP,CommandValuesCollection.DOWN,CommandValuesCollection.LAND};

        System.out.println("You are going on a Bouncy mission....");

        MessageCaller.fly(requestArray,communicator);

//        for(int i=0;i<requestArray.length;i++) {
//            //System.out.println("You are going on a Supersonic Simulator.Message.MessageCaller....");
//            SendReceive.SendReceiveCommon(requestArray[i], communicator);
//        }
    }
}

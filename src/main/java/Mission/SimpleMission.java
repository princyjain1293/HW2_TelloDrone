package Mission;


import DroneAccessors.Communicator;
import Message.MessageCaller;

public class SimpleMission implements Mission {
    public void fly(Communicator communicator) throws Exception {
        System.out.println("You are going on a simple mission....");
        String[] requestArray={CommandValuesCollection.COMMAND_MODE,CommandValuesCollection.TAKE_OFF,CommandValuesCollection.LEFT,CommandValuesCollection.RIGHT,CommandValuesCollection.LAND};
        MessageCaller.fly(requestArray,communicator);
//        for(int i=0;i<requestArray.length;i++) {
//            //System.out.println("You are going on a Supersonic Message.MessageCaller....");
//            SendReceive.SendReceiveCommon(requestArray[i], communicator);
//        }
    }
}

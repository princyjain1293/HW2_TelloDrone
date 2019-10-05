package Mission;


import Common.CommandValuesCollection;
import Common.Communicator;
import Common.DroneState;
import Common.MessageCaller;

public class SimpleMission extends Mission {

    @Override
    public void executeCommand(Communicator communicator, DroneState droneState) throws Exception {
        String[] requestArray={CommandValuesCollection.LEFT,CommandValuesCollection.RIGHT};
        MessageCaller.commandSelecter(requestArray,communicator,droneState);
    }
}

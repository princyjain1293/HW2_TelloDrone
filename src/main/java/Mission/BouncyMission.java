package Mission;

import Common.CommandValuesCollection;
import Common.Communicator;
import Common.MessageCaller;

public class BouncyMission extends Mission {


    @Override
    public void executeCommand(Communicator communicator) throws Exception {
        String[] requestArray={CommandValuesCollection.UP,CommandValuesCollection.DOWN,CommandValuesCollection.UP,CommandValuesCollection.DOWN};
        MessageCaller.commandSelecter(requestArray,communicator);
    }
}

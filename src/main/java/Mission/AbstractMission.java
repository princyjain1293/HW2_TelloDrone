package Mission;

import Common.CommandValuesCollection;
import Common.Communicator;
import Common.SendReceive;

public abstract class AbstractMission {
    public abstract void executeCommand();
    public final void commandMode(Communicator communicator) throws Exception {
        SendReceive.sendReceiveCommon(CommandValuesCollection.COMMAND_MODE,communicator);
    }
    public final void takeoffmode(Communicator communicator) throws Exception {
        SendReceive.sendReceiveCommon(CommandValuesCollection.TAKE_OFF,communicator);
    }
    public final void landmode(Communicator communicator) throws Exception {
        SendReceive.sendReceiveCommon(CommandValuesCollection.LAND,communicator);
    }
    public final void commandOrder(Communicator communicator) throws Exception {
        commandMode(communicator);
        takeoffmode(communicator);
        executeCommand();
        landmode(communicator);
    }
}

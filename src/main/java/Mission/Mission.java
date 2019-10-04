package Mission;
import Common.Communicator;
import Message.Command;
import Message.Land;
import Message.Takeoff;


public abstract class Mission {

    //public abstract void fly(Communicator communicator) throws Exception;
    public abstract void executeCommand(Communicator communicator) throws Exception;
    public final void commandMode(Communicator communicator) throws Exception {
        Command command= new Command();
        command.doAction(communicator);
    }
    public final void takeoffmode(Communicator communicator) throws Exception {
        //SendReceive.sendReceiveCommon(CommandValuesCollection.TAKE_OFF,communicator);
        Takeoff takeoff= new Takeoff();
        takeoff.doAction(communicator);
    }
    public final void landmode(Communicator communicator) throws Exception {
        //SendReceive.sendReceiveCommon(CommandValuesCollection.LAND,communicator);
        Land land= new Land();
        land.doAction(communicator);
    }
    public final void fly(Communicator communicator) throws Exception {
        commandMode(communicator);
        takeoffmode(communicator);
        executeCommand(communicator);
        landmode(communicator);
    }
}

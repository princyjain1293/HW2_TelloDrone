package Mission;
import Common.Communicator;
import Common.DroneState;
import Message.Command;
import Message.Land;
import Message.Takeoff;


public abstract class Mission {

    //public abstract void fly(Communicator communicator) throws Exception;
    public abstract void executeCommand(Communicator communicator,DroneState droneState) throws Exception;
    public final void commandMode(Communicator communicator, DroneState droneState) throws Exception {
        Command command= new Command();
        command.doAction(communicator,droneState);
    }
    public final void takeoffmode(Communicator communicator,DroneState droneState) throws Exception {
        //SendReceive.sendReceiveCommon(CommandValuesCollection.TAKE_OFF,communicator);
        Takeoff takeoff= new Takeoff();
        takeoff.doAction(communicator,droneState);
    }
    public final void landmode(Communicator communicator,DroneState droneState) throws Exception {
        //SendReceive.sendReceiveCommon(CommandValuesCollection.LAND,communicator);
        Land land= new Land();
        land.doAction(communicator,droneState);
    }
    public final void fly(Communicator communicator,DroneState droneState) throws Exception {
        commandMode(communicator,droneState);
        takeoffmode(communicator,droneState);
        executeCommand(communicator,droneState);
        landmode(communicator,droneState);
    }
}

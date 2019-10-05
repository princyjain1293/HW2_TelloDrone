package Mission;

import Common.Communicator;
import Common.DroneState;
import Message.Command;
import Message.Land;
import Message.Takeoff;
import org.junit.Test;

import java.net.DatagramSocket;

import static org.junit.Assert.*;

public class MissionTest {

    @Test
    public void commandMode() throws Exception {
        DatagramSocket ds = new DatagramSocket();
        Communicator communicator= new Communicator("127.0.0.1",8889,ds);
        DroneState droneState= new DroneState();
        Command command= new Command();
        assertEquals("command",command.getCommand());
        command.doAction(communicator,droneState);
    }

    @Test
    public void takeoffmode() throws Exception {
        DatagramSocket ds = new DatagramSocket();
        Communicator communicator= new Communicator("127.0.0.1",8889,ds);
        DroneState droneState= new DroneState();
        Takeoff takeoff= new Takeoff();
        assertEquals("takeoff",takeoff.getCommand());
        takeoff.doAction(communicator,droneState);
    }

    @Test
    public void landmode() throws Exception {
        DatagramSocket ds = new DatagramSocket();
        Communicator communicator= new Communicator("127.0.0.1",8889,ds);
        DroneState droneState= new DroneState();
        Land land= new Land();
        assertEquals("land",land.getCommand());
        land.doAction(communicator,droneState);
    }

    @Test
    public void fly() throws Exception {
        commandMode();
        takeoffmode();
        landmode();

    }
}
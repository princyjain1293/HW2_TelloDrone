package Mission;

import Common.Communicator;
import Common.DroneState;
import org.junit.Test;

import java.net.DatagramSocket;

import static org.junit.Assert.*;

public class BouncyMissionTest {

    @Test
    public void executeCommand() throws Exception {
        BouncyMission bouncyMission= new BouncyMission();
        DatagramSocket ds = new DatagramSocket();
        Communicator communicator= new Communicator("127.0.0.1",8889,ds);
        DroneState droneState= new DroneState();
        bouncyMission.executeCommand(communicator,droneState);
    }
}
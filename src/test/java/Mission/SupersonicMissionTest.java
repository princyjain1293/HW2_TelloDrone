package Mission;

import Common.Communicator;
import Common.DroneState;
import org.junit.Test;

import java.net.DatagramSocket;

import static org.junit.Assert.*;

public class SupersonicMissionTest {

    @Test
    public void executeCommand() throws Exception {
        SupersonicMission bouncyMission= new SupersonicMission();
        DatagramSocket ds = new DatagramSocket();
        Communicator communicator= new Communicator("127.0.0.1",8889,ds);
        DroneState droneState= new DroneState();
        bouncyMission.executeCommand(communicator,droneState);
    }
}
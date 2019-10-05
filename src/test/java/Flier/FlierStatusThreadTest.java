package Flier;

import Common.Communicator;
import Common.DroneState;
import org.junit.Test;

import java.io.IOException;
import java.net.DatagramSocket;

import static org.junit.Assert.*;

public class FlierStatusThreadTest {
    @Test
    public void ConstructorTest() throws IOException {
        DatagramSocket datagramSocket= new DatagramSocket(8890);
        Communicator communicator= new Communicator(datagramSocket);
        DroneState droneState= new DroneState();
        FlierStatusThread fst= new FlierStatusThread(communicator,droneState);
        assertEquals(droneState,fst.getDroneState());
        assertEquals(communicator,fst.getStatusCommunicator());
    }

    @Test
    public void run() throws Exception {
        DatagramSocket datagramSocket= new DatagramSocket(8890);
        Communicator communicator= new Communicator(datagramSocket);
        String statusReceived= "mid:-1;x:0;y:0;z:0;mpry:0,0,0;pitch:0;roll:0;yaw:0;vgx:0;vgy:0;vgz:0;templ:0;temph:40;tof:0;h:0;bat:30;baro:0.00;time:0;agx:0.00;agy:0.00;agz:0.00";
        assertEquals(statusReceived,communicator.Receive());

    }
}
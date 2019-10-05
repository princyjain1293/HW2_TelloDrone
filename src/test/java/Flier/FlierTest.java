package Flier;

import Common.Communicator;
import Common.DroneState;
import Common.MessageCaller;
import Mission.*;
import org.junit.Test;

import java.io.Flushable;
import java.net.DatagramSocket;
import java.net.SocketException;

import static org.junit.Assert.*;

public class FlierTest {

    @Test
    public void selectFileTest() throws Exception {
        DatagramSocket ds= new DatagramSocket();
        Communicator communicator= new Communicator("127.0.0.1",8889,ds);
        DroneState droneState= new DroneState();
        String fileName="SimpleMission.csv";
        Flier.selectFile(fileName,communicator,droneState);

    }

    @Test
    public void selectMissionTest() throws Exception {
        DatagramSocket ds= new DatagramSocket();
        Communicator communicator= new Communicator("127.0.0.1",8889,ds);
        DroneState droneState= new DroneState();
        Mission mission1= new SimpleMission();
        Mission mission2= new SupersonicMission();
        Mission mission3=new BouncyMission();
        mission1.fly(communicator,droneState);
        mission2.fly(communicator,droneState);
        mission3.fly(communicator,droneState);
    }

    @Test
    public void manualCommandsTest() throws Exception {
        String[] requestArray= new String[]{"command","takeoff","land"};
        DatagramSocket ds= new DatagramSocket();
        Communicator communicator= new Communicator("127.0.0.1",8889,ds);
        DroneState droneState= new DroneState();
        MessageCaller.commandSelecter(requestArray,communicator,droneState);

    }
}
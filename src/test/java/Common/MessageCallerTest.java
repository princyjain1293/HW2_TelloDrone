package Common;

import org.junit.Test;

import java.net.DatagramSocket;
import java.net.SocketException;

import static org.junit.Assert.*;

public class MessageCallerTest {

    @Test
    public void commandSelecter() throws Exception {
        DroneState droneState= new DroneState();
        String[] requestArray= new String[]{"command","takeoff","land"};
        DatagramSocket ds =new DatagramSocket();
        Communicator communicator= new Communicator("127.0.0.1",8889,ds);
        MessageCaller.commandSelecter(requestArray,communicator,droneState);
    }
}

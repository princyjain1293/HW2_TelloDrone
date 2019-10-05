package Common;
import org.junit.Test;

import java.net.DatagramSocket;
import java.net.InetAddress;


import static org.junit.Assert.*;

public class CommunicatorTest {
    @Test
    public void constructorTestwithNullSocket() throws Exception{
        DatagramSocket udpClient= new DatagramSocket();
        Communicator communicator = new Communicator("127.0.0.1", 8889,udpClient);
        Communicator communicator1= new Communicator(udpClient);
        assertEquals(8889, communicator.getDestPort());
        assertEquals(InetAddress.getByName("127.0.0.1"), communicator.getDestIPAddress());
        assertEquals(udpClient,communicator.getDatagramSocket());
        assertEquals(udpClient,communicator1.getDatagramSocket());
    }





    @Test
    public void send() {
    }

    @Test
    public void receive() throws Exception {
        String expectedReply="ok";
        DatagramSocket udpClient= new DatagramSocket();
        Communicator communicator2 = new Communicator("127.0.0.1",8889,udpClient);
        communicator2.Send("command");
        communicator2.Receive().compareTo(expectedReply);
    }

    @Test
    public void getDestIPAddress() {
    }

    @Test
    public void getDestPort() {
    }
}
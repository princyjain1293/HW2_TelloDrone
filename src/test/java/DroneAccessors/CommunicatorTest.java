package DroneAccessors;

import org.junit.Test;

import java.net.InetAddress;

import static org.junit.Assert.*;

public class CommunicatorTest {
        void constructorTest() throws Exception{
            Communicator communicator = new Communicator("127.0.0.1", 8889,);
            assertEquals(8889, communicator.destPort);
            assertEquals(InetAddress.getByName("127.0.0.1"), communicator.destIPAddress);
        }
    }

    @Test
    public void send() {
    }

    @Test
    public void receive() {
    }

    @Test
    public void getDestIPAddress() {
    }

    @Test
    public void getDestPort() {
    }
}
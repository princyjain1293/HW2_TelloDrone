package Common;

import org.junit.Test;

import javax.xml.crypto.Data;

import java.net.DatagramSocket;
import java.net.SocketException;

import static org.junit.Assert.*;

public class SendReceiveTest {


    @Test
    public void sendReceiveCommonTest() throws Exception {
        DatagramSocket udpClient= new DatagramSocket();

        Communicator communicator= new Communicator("127.0.0.1",8889,udpClient);
        String command1= CommandValuesCollection.COMMAND_MODE;
        String command2= CommandValuesCollection.TAKE_OFF;
        String command3=CommandValuesCollection.LAND;
        SendReceive.sendReceiveCommon(command1,communicator);
        SendReceive.sendReceiveCommon(command2,communicator);
        SendReceive.sendReceiveCommon(command3,communicator);

    }
}
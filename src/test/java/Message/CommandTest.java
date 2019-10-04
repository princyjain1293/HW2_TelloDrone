package Message;

import Common.CommandValuesCollection;
import Common.Communicator;
import Common.SendReceive;
import org.junit.Test;

import java.net.DatagramSocket;

import static org.junit.Assert.*;

public class CommandTest {

    @Test
    public void doActionTest() throws Exception {
        Command command1= new Command();
        DatagramSocket udpClient= new DatagramSocket();
        Communicator communicator= new Communicator("127.0.0.1",8889,udpClient);
        String command= CommandValuesCollection.COMMAND_MODE;
        assertEquals(CommandValuesCollection.COMMAND_MODE,command1.getCommand());
        SendReceive.sendReceiveCommon(command,communicator);
    }

    @Test
    public void getCommandTest(){
        Command command1= new Command();
        assertEquals("command",command1.getCommand());
    }

}
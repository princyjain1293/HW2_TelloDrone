import java.net.DatagramSocket;

public interface Message {
    void doAction(Communicator communicator, String request, DatagramSocket udpClient) throws Exception;
}

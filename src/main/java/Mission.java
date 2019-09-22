import java.net.DatagramSocket;


public interface Mission{
    void fly(String ipAddress,int dronePort, DatagramSocket udpClient) throws Exception;
}

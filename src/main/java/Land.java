import java.net.DatagramSocket;

public class Land implements Message {
    @Override
    public void doAction(Communicator communicator, String request, DatagramSocket udpClient) throws Exception {
        String response;
        System.out.println("Put Drone in "+request+" mode.");
        communicator.Send(request,udpClient);
        response= communicator.Receive(udpClient);
        System.out.println("Response received from drone is "+response);
    }
}

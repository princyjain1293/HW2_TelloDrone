import java.net.DatagramSocket;

//import java.net.DatagramSocket;
//
//
//public interface Mission{
//    void fly(String ipAddress,int dronePort, DatagramSocket udpClient) throws Exception;
//}
public class Mission{
    public void fly(String ipAddress, int dronePort, DatagramSocket udpClient, String[] requestArray) throws Exception{
        Communicator communicator = new Communicator(ipAddress,dronePort);
        for (String request : requestArray) {

            switch (request) {
                case "command":
                    Command command = new Command();
                    command.doAction(communicator, request, udpClient);
                    break;
                case "takeoff":
                    Takeoff takeoff = new Takeoff();
                    takeoff.doAction(communicator, request, udpClient);
                    break;
                case "land":
                    Land land = new Land();
                    land.doAction(communicator, request, udpClient);
                    break;
                case "left 25":
                    Left left = new Left();
                    left.doAction(communicator, request, udpClient);
                    break;
                case "right 25":
                    Right right = new Right();
                    right.doAction(communicator, request, udpClient);
                    break;


            }
        }
    }
}
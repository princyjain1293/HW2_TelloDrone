import TelloCommands.*;

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
            if (request.contains("left")){
                Left left = new Left();
                left.doAction();
            }
            else if(request.contains("right")){
                Right right = new Right();
                right.doAction();
            }
            else if(request.contains("flip")){
                Flip flip= new Flip();
                flip.doAction();
            }
            else if(request.contains("up")){
                Up up= new Up();
                up.doAction();
            }
            else if(request.contains("down")){
                Down down = new Down();
                down.doAction();
            }
            else if(request.contains("command")){
                Command command= new Command();
                command.doAction();
            }
            else if(request.contains("takeoff")){
                Takeoff takeoff= new Takeoff();
                takeoff.doAction();
            }
            else  if(request.contains("land")){
                Land land= new Land();
                land.doAction();
            }
        }
    }
}
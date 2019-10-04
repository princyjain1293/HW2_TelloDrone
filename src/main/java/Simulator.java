import Common.Communicator;
import Common.DroneState;
import Simulator.*;

import java.net.DatagramSocket;


public class Simulator {
    public static void main(String[] args)throws Exception{
        DatagramSocket ds= new DatagramSocket(8889);
        DatagramSocket socket=new DatagramSocket();
        Communicator communicatorStatus = new Communicator("127.0.0.1",8890, socket);
        Communicator serverCommunicator= new Communicator(ds);
        DroneState droneState=new DroneState();
        String reply = "ok";
        String error="error";
        CommandValidation commandValidation= new CommandValidation(reply,error);

        SimulatorStatusThread simulatorThread= new SimulatorStatusThread(droneState,communicatorStatus);
        simulatorThread.start();

        while (true) {
            String command = serverCommunicator.Receive();
            System.out.println("Received "+command+" from flier");
            commandValidation.ValidateCommand(serverCommunicator,command);
        }
    }
}

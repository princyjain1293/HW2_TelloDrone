import DroneAccessors.Communicator;
import Mission.CommandValuesCollection;
import Message.TelloFlip;
import Simulator.*;

import java.net.DatagramSocket;


public class Simulator {
    public static void main(String[] args)throws Exception{
        DatagramSocket ds= new DatagramSocket(8889);
        Communicator serverCommunicator= new Communicator(ds);
        String reply = "ok";
        String error="error";

        CommandValidation commandValidation= new CommandValidation(reply,error);
        commandValidation.start();

        while (true) {
            String command = serverCommunicator.Receive();
            commandValidation.ValidateCommand(serverCommunicator,command);
        }
    }
}

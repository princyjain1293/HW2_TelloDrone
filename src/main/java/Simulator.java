import DroneAccessors.Communicator;
import Mission.CommandValuesCollection;
import Message.TelloFlip;
import Simulator.*;

import java.net.DatagramSocket;


public class Simulator {
    public static void main(String[] args)throws Exception{
        DatagramSocket ds= new DatagramSocket(8889);
        Communicator serverCommunicator= new Communicator(ds);
        DroneState droneState= new DroneState();

        while (true) {
            String command = serverCommunicator.Receive();
            String reply = "ok";

            //Command received is command
            if (command.equals(CommandValuesCollection.COMMAND_MODE)) {
                if (droneState.isInCommandMode() == true) System.out.println("Already in Command Mode");
                else {
                    droneState.setInCommandMode(true);
                    serverCommunicator.Send(reply);
                }
            }
            //Command received is takeoff
            else if (command.equals(CommandValuesCollection.TAKE_OFF) ){
                if (droneState.hasTakenOff() == true) System.out.println("Drone has already taken off");
                else {
                    droneState.setHasTakenOff(true);
                    serverCommunicator.Send(reply);
                }
            } else {
                if (droneState.isInCommandMode() && droneState.hasTakenOff()) {
                    //Command received is land
                    if (command == (CommandValuesCollection.LAND)) {
                        serverCommunicator.Send(reply);
                        droneState.setHasTakenOff(false);
                    }
                    //Command received is left
                    else if (command.contains(CommandValuesCollection.LEFT)) {
                        int value = Integer.parseInt(command.substring(command.indexOf(" ") + 1));
                        if (value >= 20 && value <= 500)
                            serverCommunicator.Send(reply);
                        else System.out.println("Entered value is not supported");
                    }
                    //Command received is right
                    else if (command.contains(CommandValuesCollection.RIGHT)) {
                        int value = Integer.parseInt(command.substring(command.indexOf(" ") + 1));
                        if (value >= 20 && value <= 500)
                            serverCommunicator.Send(reply);
                        else System.out.println("Entered value is not supported");
                    }
                    //Command received is forward
                    else if (command.contains(CommandValuesCollection.FORWARD)) {
                        int value = Integer.parseInt(command.substring(command.indexOf(" ") + 1));
                        if (value >= 20 && value <= 500)
                            serverCommunicator.Send(reply);
                        else System.out.println("Entered value is not supported");
                    }
                    //Command received is backward
                    else if (command.contains(CommandValuesCollection.BACK)) {
                        int value = Integer.parseInt(command.substring(command.indexOf(" ") + 1));
                        if (value >= 20 && value <= 500)
                            serverCommunicator.Send(reply);
                        else System.out.println("Entered value is not supported");
                    }
                    //Command received is up
                    else if (command.contains(CommandValuesCollection.UP)) {
                        int value = Integer.parseInt(command.substring(command.indexOf(" ") + 1));
                        if (value >= 20 && value <= 500)
                            serverCommunicator.Send(reply);
                        else System.out.println("Entered value is not supported");
                    }
                    //Command received is down
                    else if (command.contains(CommandValuesCollection.DOWN)) {
                        int value = Integer.parseInt(command.substring(command.indexOf(" ") + 1));
                        if (value >= 20 && value <= 500)
                            serverCommunicator.Send(reply);
                        else System.out.println("Entered value is not supported");
                    }
                    //Command received is flip
                    else if (command.contains(CommandValuesCollection.FLIP)) {
                        String value = command.substring(command.indexOf(" ") + 1);
                        if (TelloFlip.contains(value)) {
                            serverCommunicator.Send(reply);
                        } else System.out.println("Entered flip type is not supported");
                    }
                    //Command received is clock wise
                    else if (command.contains(CommandValuesCollection.CW)) {
                        int value = Integer.parseInt(command.substring(command.indexOf(" ") + 1));
                        if (value >= 1 && value <= 360)
                            serverCommunicator.Send(reply);
                        else System.out.println("Entered degree of rotation is not supported");
                    }
                    //Command received counter is clock wise
                    else if (command.contains(CommandValuesCollection.CCW)) {
                        int value = Integer.parseInt(command.substring(command.indexOf(" ") + 1));
                        if (value >= 1 && value <= 360)
                            serverCommunicator.Send(reply);
                        else System.out.println("Entered degree of rotation is not supported");
                    }
                    //Command received is battery percentage
                    else if (command.contains(CommandValuesCollection.CURRENT_BATTERY)) {
                        reply = "100%";
                        serverCommunicator.Send(reply);
                    }
                } else if (!droneState.isInCommandMode()) {
                    System.out.println("Drone is not in command mode");
                    serverCommunicator.Send("ok");
                } else if (!droneState.hasTakenOff()) System.out.println("Drone has not yet taken off");
            }

        }

    }
}

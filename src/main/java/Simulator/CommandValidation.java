package Simulator;
import Message.TelloFlip;

import DroneAccessors.Communicator;
import Mission.CommandValuesCollection;

import java.net.DatagramSocket;
import java.net.InetAddress;

public class CommandValidation extends Thread{
    DroneState droneState=new DroneState();
    String reply;
    String error;
    Communicator communicatorStatus ;

    public void run()
    {
        while(true)
        {
            try {
                Status status=new Status(droneState.getPitch(), droneState.getRoll(),droneState.getYaw(), droneState.getSpeedX(), droneState.getSpeedY(), droneState.getSpeedZ(),
                        droneState.getLowTemperature(), droneState.getHighTemperature(), droneState.getFlightDistance(),droneState.getHeight(),
                        droneState.getBatteryPercentage(),droneState.getBarometerMeasurement(),droneState.getMotorTime(),
                        droneState.getAccelerationX(), droneState.getAccelerationY(), droneState.getAccelerationZ());
                String statusReply= status.getMessageText();

                communicatorStatus.Send(statusReply);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }


    public CommandValidation(String reply, String error) throws Exception{
        this.reply=reply;
        this.error=error;
        DatagramSocket socket=new DatagramSocket();
        communicatorStatus = new Communicator("127.0.0.1",8890, socket);

    }
    public void ValidateCommand(Communicator serverCommunicator,String command) throws Exception {
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
                if (command.contains(CommandValuesCollection.LAND)) {
                    serverCommunicator.Send(reply);
                    droneState.setHasTakenOff(false);
                }
                //Command received is left
                else if (command.contains(CommandValuesCollection.LEFT)) {
                    int value = Integer.parseInt(command.substring(command.indexOf(" ") + 1));
                    System.out.println(value);
                    if (value >= 20 && value <= 500)
                        serverCommunicator.Send(reply);
                    else {
                        serverCommunicator.Send(error);
                        System.out.println("Entered value is not supported");
                    }
                }
                //Command received is right
                else if (command.contains(CommandValuesCollection.RIGHT)) {
                    int value = Integer.parseInt(command.substring(command.indexOf(" ") + 1));
                    if (value >= 20 && value <= 500)
                        serverCommunicator.Send(reply);
                    else {
                        serverCommunicator.Send(error);
                        System.out.println("Entered value is not supported");
                    }
                }
                //Command received is forward
                else if (command.contains(CommandValuesCollection.FORWARD)) {
                    int value = Integer.parseInt(command.substring(command.indexOf(" ") + 1));
                    if (value >= 20 && value <= 500)
                        serverCommunicator.Send(reply);
                    else {
                        serverCommunicator.Send(error);
                        System.out.println("Entered value is not supported");
                    }
                }
                //Command received is backward
                else if (command.contains(CommandValuesCollection.BACK)) {
                    int value = Integer.parseInt(command.substring(command.indexOf(" ") + 1));
                    if (value >= 20 && value <= 500)
                        serverCommunicator.Send(reply);
                    else {
                        serverCommunicator.Send(error);
                        System.out.println("Entered value is not supported");
                    }
                }
                //Command received is up
                else if (command.contains(CommandValuesCollection.UP)) {
                    int value = Integer.parseInt(command.substring(command.indexOf(" ") + 1));
                    if (value >= 20 && value <= 500)
                        serverCommunicator.Send(reply);
                    else {
                        serverCommunicator.Send(error);
                        System.out.println("Entered value is not supported");
                    }
                }
                //Command received is down
                else if (command.contains(CommandValuesCollection.DOWN)) {
                    int value = Integer.parseInt(command.substring(command.indexOf(" ") + 1));
                    if (value >= 20 && value <= 500)
                        serverCommunicator.Send(reply);
                    else {
                        serverCommunicator.Send(error);
                        System.out.println("Entered value is not supported");
                    }
                }
                //Command received is flip
                else if (command.contains(CommandValuesCollection.FLIP)) {
                    String value = command.substring(command.indexOf(" ") + 1);
                    if (TelloFlip.contains(value)) {
                        serverCommunicator.Send(reply);
                    }
                    else {
                        serverCommunicator.Send(error);
                        System.out.println("Entered value is not supported");
                    }
                }
                //Command received is clock wise
                else if (command.contains(CommandValuesCollection.CW)) {
                    int value = Integer.parseInt(command.substring(command.indexOf(" ") + 1));
                    if (value >= 1 && value <= 360)
                        serverCommunicator.Send(reply);
                    else {
                        serverCommunicator.Send(error);
                        System.out.println("Entered value is not supported");
                    }
                }
                //Command received counter is clock wise
                else if (command.contains(CommandValuesCollection.CCW)) {
                    int value = Integer.parseInt(command.substring(command.indexOf(" ") + 1));
                    if (value >= 1 && value <= 360)
                        serverCommunicator.Send(reply);
                    else {
                        serverCommunicator.Send(error);
                        System.out.println("Entered value is not supported");
                    }
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

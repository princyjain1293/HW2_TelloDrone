package Common;


import java.util.Scanner;

public class SendReceive {

    public static final String sendReceiveCommon(String command, Communicator communicator) throws Exception {
        DroneState droneState = new DroneState();
//        Scanner in = new Scanner(System.in);
//        System.out.println("enter number of retries");
        int maxRetries = 3;
        String reply=null;

        while (maxRetries > 0)
        {       if (command.contains(CommandValuesCollection.COMMAND_MODE)) {
                System.out.println("Put drone in " + command + " mode");
                communicator.Send(command);
            } else {
                if (droneState.getBatteryPercentage() > 20 || droneState.getHighTemperature() < 60) {
                    System.out.println("Put drone in " + command + " mode");
                    communicator.Send(command);
                } else {
                    communicator.Send(CommandValuesCollection.LAND);
                }
            }
        reply = communicator.Receive();
        if(reply.equals("ok"))
        {
            break;
        }
        maxRetries--;
    }
        if(reply==null && !reply.equals("ok"))
        {
            return "not received anything";
        }

        System.out.println("Response received from drone is: "+ reply);
            return reply;


    }
}

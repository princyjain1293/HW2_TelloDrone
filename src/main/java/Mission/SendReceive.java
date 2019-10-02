package Mission;
import Common.Communicator;
import Common.DroneState;

public class SendReceive {



    public static final void SendReceiveCommon(String command, Communicator communicator) throws Exception {
        DroneState droneState= new DroneState();
        if(droneState.getBatteryPercentage()>20 && droneState.getHighTemperature()<60) {
            if(command.contains(CommandValuesCollection.COMMAND_MODE)) {
                System.out.println("Put drone in " + command + " mode");
                communicator.Send(command);
            }
            else {
                if(droneState.isInCommandMode()){
                    System.out.println("Put drone in " + command + " mode");
                    communicator.Send(command);
                }
                else {
                    System.out.println("Put drone in command mode first");
                }
            }
        }
        else {communicator.Send(CommandValuesCollection.LAND);}

        System.out.printf("Response received from drone is %s%n", communicator.Receive());
    }
}

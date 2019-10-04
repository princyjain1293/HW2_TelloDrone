package Common;


public class SendReceive {

    public static final String sendReceiveCommon(String command, Communicator communicator) throws Exception {
        DroneState droneState= new DroneState();

            if(command.contains(CommandValuesCollection.COMMAND_MODE)) {
                System.out.println("Put drone in " + command + " mode");
                communicator.Send(command);
            }
            else {
                if(droneState.getBatteryPercentage()>20 || droneState.getHighTemperature()<60) {
                    System.out.println("Put drone in " + command + " mode");
                    communicator.Send(command);
                }
                else {communicator.Send(CommandValuesCollection.LAND);}
            }
           String  reply=communicator.Receive();
        System.out.println("Response received from drone is: "+ reply);
            return reply;


    }
}

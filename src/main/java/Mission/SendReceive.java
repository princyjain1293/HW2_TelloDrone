package Mission;

import DroneAccessors.Communicator;

public class SendReceive {
    public static final void SendReceiveCommon(String command, Communicator communicator) throws Exception {

            System.out.println("Put drone in "+command+" mode");
            communicator.Send(command);
            System.out.println("Response received from drone is " + communicator.Receive());


    }
}

package Flier;

import Common.Communicator;
import Common.DroneState;
import Common.Status;

public class FlierStatusThread extends Thread{
    public DroneState droneState;
    Communicator statusCommunicator;

    public FlierStatusThread(Communicator statusCommunicator,DroneState droneState){
        this.droneState=droneState;
        this.statusCommunicator=statusCommunicator;
    }
    public void run() {
        String receivedStatus= null;
        while(true){
            try {
                receivedStatus= statusCommunicator.Receive();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Status status= new Status(receivedStatus);
            droneState.updateFlyingInfo(status);
        }
    }
}

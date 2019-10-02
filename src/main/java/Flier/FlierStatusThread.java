package Flier;

import Common.Communicator;
import Common.DroneState;
import Common.Status;

public class FlierStatusThread extends Thread{
    DroneState statusDroneState;
    Communicator statusCommunicator;

    public FlierStatusThread(DroneState statusDroneState, Communicator statusCommunicator){
        this.statusDroneState=statusDroneState;
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
            statusDroneState.updateFlyingInfo(status);
        }
    }
}

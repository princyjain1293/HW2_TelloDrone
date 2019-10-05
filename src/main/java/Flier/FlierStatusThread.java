package Flier;

import Common.Communicator;
import Common.DroneState;
import Common.Status;

import java.io.IOException;
import java.util.logging.*;

public class FlierStatusThread extends Thread{
    public DroneState droneState;
    Communicator statusCommunicator;
    Logger logger;
    FileHandler fh;

    public FlierStatusThread(Communicator statusCommunicator,DroneState droneState) throws IOException {
        this.droneState=droneState;
        this.statusCommunicator=statusCommunicator;
        logger= Logger.getLogger(FlierStatusThread.class.getName());
        fh= new FileHandler("C:/Users/princy/Desktop/Cs5700/HW2_TelloDrone/Logs/FlierLogs.txt");
        SimpleFormatter simpleFormatter= new SimpleFormatter();
        fh.setFormatter(simpleFormatter);
        logger.setUseParentHandlers(false);
        logger.addHandler(fh);

    }
    public void run() {
        String receivedStatus= null;
        while(true){
            try {
                if(droneState.isInCommandMode()) {
                    receivedStatus = statusCommunicator.Receive();
                    logger.info(receivedStatus);
                    Status status = new Status(receivedStatus);
                    droneState.updateFlyingInfo(status);
                    Thread.sleep(100);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    public DroneState getDroneState(){return droneState;}
    public Communicator getStatusCommunicator(){return statusCommunicator;}
}

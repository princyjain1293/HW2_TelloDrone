package Simulator;

import Common.Communicator;
import Common.DroneState;
import Common.Status;
import Flier.FlierStatusThread;
import Mission.SimpleMission;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SimulatorStatusThread extends Thread{
    DroneState droneState;
    Communicator communicatorStatus;
    Logger logger;
    FileHandler fh;

    public SimulatorStatusThread(DroneState droneState, Communicator communicatorStatus) throws IOException {
        this.droneState=droneState;
        this.communicatorStatus=communicatorStatus;
        logger= Logger.getLogger(FlierStatusThread.class.getName());
        fh= new FileHandler("C:/Users/princy/Desktop/Cs5700/HW2_TelloDrone/Logs/SimulatorLogs.txt");
        SimpleFormatter simpleFormatter= new SimpleFormatter();
        fh.setFormatter(simpleFormatter);
        logger.setUseParentHandlers(false);
        logger.addHandler(fh);
    }
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
                logger.info(statusReply);
                if(droneState.isInCommandMode())
                    communicatorStatus.Send(statusReply);

                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }
}

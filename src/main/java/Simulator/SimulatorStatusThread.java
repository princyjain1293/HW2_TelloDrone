package Simulator;

import Common.Communicator;
import Common.DroneState;
import Common.Status;
import Mission.SimpleMission;

public class SimulatorStatusThread extends Thread{
    DroneState droneState;
    Communicator communicatorStatus;

    public SimulatorStatusThread(DroneState droneState, Communicator communicatorStatus){
        this.droneState=droneState;
        this.communicatorStatus=communicatorStatus;

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

                communicatorStatus.Send(statusReply);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }
}

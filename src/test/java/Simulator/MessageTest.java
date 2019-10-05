package Simulator;

import Common.DroneState;
import Common.Status;
import org.junit.Test;

import static org.junit.Assert.*;

public class MessageTest {



    @Test
    public void getMessageText() {
        DroneState droneState= new DroneState();
        Message message= new Status(droneState.getPitch(), droneState.getRoll(),droneState.getYaw(), droneState.getSpeedX(), droneState.getSpeedY(), droneState.getSpeedZ(),
                droneState.getLowTemperature(), droneState.getHighTemperature(), droneState.getFlightDistance(),droneState.getHeight(),
                droneState.getBatteryPercentage(),droneState.getBarometerMeasurement(),droneState.getMotorTime(),
                droneState.getAccelerationX(), droneState.getAccelerationY(), droneState.getAccelerationZ());
        String value= "mid:-1;x:0;y:0;z:0;mpry:0,0,0;pitch:0;roll:0;yaw:0;vgx:0;vgy:0;vgz:0;templ:0;temph:40;tof:0;h:0;bat:30;baro:0.00;time:0;agx:0.00;agy:0.00;agz:0.00";
        assertEquals(value,message.getMessageText());
    }


    @Test
    public void getMessageText1() {
    }

//    @Test
//    public void toString() {
//    }
}
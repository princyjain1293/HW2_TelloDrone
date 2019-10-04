package Common;

import org.junit.Test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.lang.*;
import java.net.DatagramSocket;
import java.net.SocketException;

public class DroneStateTest {

    @Test
    public void isInCommandModeTest() {

    }

    @Test
    public void setInCommandModeTest() {
        DroneState droneState= new DroneState();
        assertEquals(false, droneState.isInCommandMode());
        droneState.setInCommandMode(true);
        droneState.resetState();
    }

    @Test
    public void hasTakenOff() {
    }

    @Test
    public void setHasTakenOff() {
        DroneState droneState= new DroneState();
        assertEquals(false,droneState.hasTakenOff());
        droneState.setHasTakenOff(true);
        droneState.resetState();
    }

    @Test
    public void isVideoStreamOn() {
    }

    @Test
    public void setVideoStreamOn() {
        DroneState droneState= new DroneState();
        assertEquals(false,droneState.isVideoStreamOn());
        droneState.setVideoStreamOn(true);

    }

    @Test
    public void getCurrentFlightTime() {
    }

    @Test
    public void setCurrentFlightTime() {
        DroneState droneState= new DroneState();
        Double time=0.0;
        assertEquals(time,droneState.getCurrentFlightTime());

        droneState.setCurrentFlightTime(12.5);
    }

    @Test
    public void updateFlyingInfo() throws Exception {
        DroneState droneState= new DroneState();
        DatagramSocket ds= new DatagramSocket(8890);
        Communicator communicator= new Communicator(ds);
        String statusReceived= communicator.Receive();
        Status status= new Status(statusReceived);
        droneState.updateFlyingInfo(status);
    }

    @Test
    public void getStateTimestamp() {
    }

    @Test
    public void move() {
    }

    @Test
    public void rotate() {
    }

    @Test
    public void getPositionX() {
    }

    @Test
    public void getPositionY() {
    }

    @Test
    public void getPositionZ() {
    }

    @Test
    public void getPitch() {
    }

    @Test
    public void getRoll() {
    }

    @Test
    public void getYaw() {
    }

    @Test
    public void getSpeedX() {
    }

    @Test
    public void getSpeedY() {
    }

    @Test
    public void getSpeedZ() {
    }

    @Test
    public void getAccelerationX() {
    }

    @Test
    public void getAccelerationY() {
    }

    @Test
    public void getAccelerationZ() {
    }

    @Test
    public void getLowTemperature() {
    }

    @Test
    public void getHighTemperature() {
    }

    @Test
    public void getFlightDistance() {
    }

    @Test
    public void getHeight() {
    }

    @Test
    public void getBatteryPercentage() {
    }

    @Test
    public void getBarometerMeasurement() {
    }

    @Test
    public void getMotorTime() {
    }

    @Test
    public void getOrientation() {
    }
}
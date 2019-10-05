package Common;


import Common.Communicator;
import Message.*;

public class MessageCaller {
    public static final void commandSelecter(String[] command, Communicator communicator, DroneState droneState) throws Exception{
        for(String request: command) {
            if (request.contains("left")) {
                Left left = new Left();
                left.doAction(communicator,droneState);
            } else if (request.contains("right")) {
                Right right = new Right();
                right.doAction(communicator,droneState);
            } else if (request.contains("flip")) {
                Flip flip = new Flip();
                flip.doAction(communicator,droneState);
            } else if (request.contains("up")) {
                Up up = new Up();
                up.doAction(communicator,droneState);
            } else if (request.contains("down")) {
                Down down = new Down();
                down.doAction(communicator,droneState);
            } else if (request.contains("command")) {
                Command commandMode = new Command();
                commandMode.doAction(communicator,droneState);
            } else if (request.contains("takeoff")) {
                Takeoff takeoff = new Takeoff();
                takeoff.doAction(communicator,droneState);
            } else if (request.contains("land")) {
                Land land = new Land();
                land.doAction(communicator,droneState);
            }
            System.out.println(droneState.getPosition());
        }
        
    }
}
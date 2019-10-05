package Message;

import Common.Communicator;
import Common.DroneState;

public interface Message {
    void doAction(Communicator communicator, DroneState droneState) throws Exception;
}

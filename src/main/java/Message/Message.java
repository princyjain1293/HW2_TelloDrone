package Message;

import DroneAccessors.Communicator;

import java.net.DatagramSocket;

public interface Message {
    void doAction(Communicator communicator) throws Exception;
}

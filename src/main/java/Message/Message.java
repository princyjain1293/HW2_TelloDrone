package Message;

import Common.Communicator;

public interface Message {
    void doAction(Communicator communicator) throws Exception;
}

package TelloCommands;

import TelloCommands.Message;

public class Takeoff implements Message {
    @Override
    public String doAction(String command){
        return command;
    }
}

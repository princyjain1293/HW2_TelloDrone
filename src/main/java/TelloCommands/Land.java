package TelloCommands;



public class Land implements Message {
    @Override
    public String doAction(String command){
        return command;
    }
}

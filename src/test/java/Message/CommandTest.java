package Message;

import Mission.CommandValuesCollection;

import static org.junit.Assert.*;

public class CommandTest {
    public void doActionTest(){
        Command command1= new Command();
        assertEquals(CommandValuesCollection.COMMAND_MODE,command1.getCommand());
    }

}
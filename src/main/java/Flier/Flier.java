package Flier;
import Common.Communicator;
import FileReader.FileCommand;
import Message.MessageCaller;
import Mission.*;

public class Flier extends Thread {





    public static void SelectMission(Mission mission, Communicator communicator) throws Exception{

        mission.fly(communicator);
    }
    public static final void SelectFile(String fileName,Communicator communicator) throws Exception{

        MessageCaller.fly(FileCommand.selectFileType(fileName),communicator);
    }
    public static final void ManualCommands(String[] requestArray, Communicator communicator) throws Exception{
        MessageCaller.fly(requestArray,communicator);
    }


}
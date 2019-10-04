package Flier;
import Common.Communicator;
import FileReader.FileCommand;
import Common.MessageCaller;
import Mission.*;

public class Flier extends Thread {





    public static void SelectMission(Mission mission, Communicator communicator) throws Exception{

        mission.fly(communicator);
    }
    public static final void SelectFile(String fileName,Communicator communicator) throws Exception{

        MessageCaller.commandSelecter(FileCommand.selectFileType(fileName),communicator);
    }
    public static final void ManualCommands(String[] requestArray, Communicator communicator) throws Exception{
        MessageCaller.commandSelecter(requestArray,communicator);
    }


}
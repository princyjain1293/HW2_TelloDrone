package Flier;
import Common.Communicator;
import Common.DroneState;
import FileReader.FileCommand;
import Common.MessageCaller;
import Mission.*;

public class Flier extends Thread {





    public static final void SelectFile(String fileName,Communicator communicator, DroneState droneState) throws Exception{

        MessageCaller.commandSelecter(FileCommand.selectFileType(fileName),communicator,droneState);
    }
    public static void SelectMission(Mission mission, Communicator communicator, DroneState droneState) throws Exception{

        mission.fly(communicator, droneState);
    }
    public static final void ManualCommands(String[] requestArray, Communicator communicator, DroneState droneState) throws Exception{
        MessageCaller.commandSelecter(requestArray,communicator,droneState);
    }


}
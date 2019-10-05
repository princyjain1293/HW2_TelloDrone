package Flier;
import Common.Communicator;
import Common.DroneState;
import FileReader.FileCommand;
import Common.MessageCaller;
import Mission.*;

public class Flier extends Thread {
    public static final void selectFile(String fileName, Communicator communicator, DroneState droneState) throws Exception{

        MessageCaller.commandSelecter(FileCommand.selectFileType(fileName),communicator,droneState);
    }
    public static void selectMission(Mission mission, Communicator communicator, DroneState droneState) throws Exception{

        mission.fly(communicator, droneState);
    }
    public static final void manualCommands(String[] requestArray, Communicator communicator, DroneState droneState) throws Exception{
        MessageCaller.commandSelecter(requestArray,communicator,droneState);
    }


}
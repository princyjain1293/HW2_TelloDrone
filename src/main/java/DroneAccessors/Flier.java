package DroneAccessors;

import java.net.*;

import FileReader.FileCommand;
import Message.MessageCaller;
import Mission.*;


public class Flier{
    public static final void SelectMission(int selectedMission, Communicator communicator) throws Exception{


        switch (selectedMission) {
            case 1:
                SimpleMission simpleMission= new SimpleMission();
                simpleMission.fly(communicator);
                break;
            case 2:
                SupersonicMission supersonicMission = new SupersonicMission();
                supersonicMission.fly(communicator);
                break;
            case 3:
                BouncyMission bouncyMission = new BouncyMission();
                bouncyMission.fly(communicator);
                break;
            default:
                System.out.println("Enter a valid option....");
                break;
        }
    }
    public static final void SelectFile(String fileName,Communicator communicator) throws Exception{

        MessageCaller.fly(FileCommand.selectFileType(fileName),communicator);
    }
    public static final void ManualCommands(String[] requestArray, Communicator communicator) throws Exception{
        MessageCaller.fly(requestArray,communicator);
    }
}
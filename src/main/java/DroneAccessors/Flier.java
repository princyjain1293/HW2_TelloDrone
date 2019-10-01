package DroneAccessors;
import Common.Communicator;
import FileReader.FileCommand;
import Message.MessageCaller;
import Mission.*;
import Common.DroneState;
import Common.Status;

import java.net.DatagramSocket;
import java.net.SocketException;


public class Flier extends Thread {
    DatagramSocket statusSocket= new DatagramSocket(8890);
    DroneState statusDroneState= new DroneState();
    Communicator statusCommunicator;

    public Flier() throws SocketException{
        statusCommunicator= new Communicator(statusSocket);
    }

    @Override
    public void run() {
        String receivedStatus= null;
        while(true){
            try {
                receivedStatus= statusCommunicator.Receive();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Status status= new Status(receivedStatus);
            statusDroneState.updateFlyingInfo(status);
        }
    }



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
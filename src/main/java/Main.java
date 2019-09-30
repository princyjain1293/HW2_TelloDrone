
import DroneAccessors.Communicator;
import DroneAccessors.Flier;
import FileReader.FileCommand;
import Mission.BouncyMission;
import Mission.SimpleMission;
import Mission.SupersonicMission;

import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.Scanner;



public class Main{
    public static void main(String[] args) throws Exception {
        Scanner telloInput = new Scanner(System.in);

        //Read IP Address from User
        System.out.println("Enter the IP Address");
        String ipAddress = telloInput.next();

        // Read Port Number from user
        System.out.println("Enter the port of the drone");
        int dronePort = telloInput.nextInt();
        DatagramSocket udpClient = new DatagramSocket();
        udpClient.setSoTimeout(1000);
//        SimpleMission simpleMission= new SimpleMission();
//        SupersonicMission supersonicMission= new SupersonicMission();
//        BouncyMission bouncyMission=new BouncyMission();
        //Object[] missionArray= new Object[]{simpleMission,supersonicMission,bouncyMission};

        Communicator communicator = new Communicator(ipAddress, dronePort, udpClient);
        System.out.println("Please select how you want to load your mission:\n" + "1. Select from existing Missions\n" + "2. Upload a csv or xml file\n" + "3. Customize your own mission");
        int choice = telloInput.nextInt();
        int selectedMission ;
        if (choice == 1) {
            System.out.println("Select your Simulator.Message.MessageCaller for the day...");
            System.out.println("Press 1 for Simple Mission\n" + "Press 2 for Supersonic Mission\n" + "Press 3 for Bouncy Mission");
            selectedMission = telloInput.nextInt();
            Flier.SelectMission(selectedMission,communicator);

        }
        else if(choice==2){
            System.out.println("Enter the name of the file from which you want to load the Mission (Note: Kindly include the extension of the same)");
            String fileName = telloInput.next();
            Flier.SelectFile(fileName,communicator);
        }
        else{
            System.out.println("Enter the number of commands you want to execute");
            int noOfCommands= telloInput.nextInt();
            String[] commandList= new String[noOfCommands];
            System.out.println("Enter the commands");
            for(int j=0;j<noOfCommands;j++){
                commandList[j]= telloInput.next();
            }
            Flier.ManualCommands(commandList,communicator);
        }




    }
}
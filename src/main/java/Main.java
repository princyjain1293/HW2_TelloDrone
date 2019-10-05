
import Common.Communicator;
import Common.DroneState;
import Flier.*;
import Mission.*;

import java.net.DatagramSocket;
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

//        // Read number of retries
//        System.out.println("Enter number of retries");
//        int maxRetries=telloInput.nextInt();
        DatagramSocket udpClient = new DatagramSocket();
        udpClient.setSoTimeout(1000);
        Flier flier= new Flier();
        DatagramSocket statusSocket= new DatagramSocket(8890);
        DroneState droneState= new DroneState();
        Communicator statusCommmunicator= new Communicator(statusSocket);
        FlierStatusThread flierthread= new FlierStatusThread(statusCommmunicator,droneState);
        flierthread.start();
        Mission[] mission=new Mission[3];
        mission[0]= new SimpleMission();
        mission[1]=new SupersonicMission();
        mission[2]=new BouncyMission();



        Communicator communicator = new Communicator(ipAddress, dronePort, udpClient);
        System.out.println("Please select how you want to load your mission:\n" + "1. Select from existing Missions\n" + "2. Upload a csv or xml file\n" + "3. Customize your own mission");
        int choice = telloInput.nextInt();
        int selectedMission ;
        if (choice == 1) {
            System.out.println("Select your Mission for the day...");
            System.out.println("Press 1 for Simple Mission\n" + "Press 2 for Supersonic Mission\n" + "Press 3 for Bouncy Mission");
            selectedMission = telloInput.nextInt();
            flier.selectMission(mission[selectedMission-1],communicator,droneState);
        }
        else if(choice==2){
            System.out.println("Enter the name of the file from which you want to load the Mission (Note: Kindly include the extension of the same)");
            String fileName = telloInput.next();
            flier.selectFile(fileName,communicator,droneState);
        }
        else{
            System.out.println("Enter the number of commands you want to execute");
            int noOfCommands= telloInput.nextInt();
            String[] commandList= new String[noOfCommands];
            System.out.println("Enter the commands");
            for(int j=0;j<noOfCommands;j++){
                commandList[j]= telloInput.next();
            }
            flier.manualCommands(commandList,communicator,droneState);
        }




    }
}
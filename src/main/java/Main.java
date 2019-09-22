
import java.util.Scanner;



public class Main{
    public static void main(String[] args) throws Exception{
        Scanner telloInput= new Scanner(System.in);
        //Read IP Address from User
        System.out.println("Enter the IP Address");
        String ipAddress= telloInput.next();
        //InetAddress droneIPAddress= InetAddress.getByName(ipAddress);


        // Read Port Number from user
        System.out.println("Enter the port of the drone");
        int dronePort= telloInput.nextInt();

        // Read the type of mission
        System.out.println("Select your Mission for the day...");
        System.out.println("Press 1 for Simple Mission \n"+"Press 2 for Supersonic Mission \n"+"Press 3 for Bouncy Mission");
        int selectedMission = telloInput.nextInt();


        Flier flier = new Flier();
        flier.SelectMission(ipAddress,dronePort,selectedMission);

    }
}
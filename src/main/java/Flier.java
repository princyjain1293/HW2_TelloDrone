
import java.net.*;


public class Flier{
       
    
    
    public void SelectMission(String ipAddress, int dronePort, int selectedMission) throws Exception{
        DatagramSocket udpClient=new DatagramSocket();
        udpClient.setSoTimeout(1000);
        switch (selectedMission) {
            case 1:
                SimpleMission simpleMission= new SimpleMission();
                simpleMission.fly(ipAddress,dronePort,udpClient);
                break;
            case 2:
                SupersonicMission supersonicMission = new SupersonicMission();
                supersonicMission.fly(ipAddress,dronePort,udpClient);
                break;
            case 3:
                BouncyMission bouncyMission = new BouncyMission();
                bouncyMission.fly(ipAddress,dronePort,udpClient);
                break;
            default:
                System.out.println("Enter a valid option....");
                break;
        } 
    }

    

    // switch (selectedMission) {
    //     case 1:
    //         SimpleMission simpleMission= new SimpleMission();
    //         request= simpleMission.fly();
    //         communicator.SendReceive(droneIPAddress,dronePort,request);
    //         break;
    //     case 2:
    //         SupersonicMission supersonicMission = new SupersonicMission();
    //         request= supersonicMission.fly();
    //         communicator.SendReceive(droneIPAddress,dronePort,request);
    //         break;
    //     case 3:
    //         BouncyMission bouncyMission = new BouncyMission();
    //         request= bouncyMission.fly();
    //         communicator.SendReceive(droneIPAddress,dronePort,request);
    //         break;
    //     default:
    //         System.out.println("Enter a valid option....");
    //         break;
    // }        
    
}

import java.net.*;


public class Flier{

    public void SelectFileType(String ipAddress, int dronePort, String fileName) throws Exception{
        String[] requestArray= new String[0];
        String fileType=fileName.substring(fileName.indexOf(".")+1);
        System.out.println(fileType);
        if(fileType.equals("csv")){
            CSVReader csvReader = new CSVReader();
            requestArray=csvReader.ReadCSV(fileName);
        }
        else if(fileType.equals("xml")){
            XMLReader xmlReader= new XMLReader();
            requestArray=xmlReader.ReadXML(fileName);
        }
        else{
            System.out.println("The uploaded file is not supported");
        }
        DatagramSocket udpClient=new DatagramSocket();
        udpClient.setSoTimeout(1000);
        Mission mission=new Mission();
        mission.fly(ipAddress,dronePort,udpClient,requestArray);
    }
       
    
    
//    public void SelectMission(String ipAddress, int dronePort, int selectedMission) throws Exception{
//        DatagramSocket udpClient=new DatagramSocket();
//        udpClient.setSoTimeout(1000);
//        switch (selectedMission) {
//            case 1:
//                SimpleMission simpleMission= new SimpleMission();
//                simpleMission.fly(ipAddress,dronePort,udpClient);
//                break;
//            case 2:
//                SupersonicMission supersonicMission = new SupersonicMission();
//                supersonicMission.fly(ipAddress,dronePort,udpClient);
//                break;
//            case 3:
//                BouncyMission bouncyMission = new BouncyMission();
//                bouncyMission.fly(ipAddress,dronePort,udpClient);
//                break;
//            default:
//                System.out.println("Enter a valid option....");
//                break;
//        }
//    }

    

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
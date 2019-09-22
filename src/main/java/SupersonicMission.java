

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class SupersonicMission implements Mission{
    
    // public SimpleMission(String[] requestArray){
    //     this.requestArray=requestArray;
    // }

    public void fly(String ipAddress, int dronePort, DatagramSocket udpClient) throws Exception{
        Communicator communicator=new Communicator(ipAddress,dronePort);
        //List<List<String>> records = new ArrayList<>();
        BufferedReader readCSV= new BufferedReader(new FileReader("SupersonicMission.csv"));
        String line;
        String[] requestArray= new String[0];
        while((line= readCSV.readLine())!= null){
            requestArray= line.split(",");
            //records.add(Arrays.asList(requestArray));
        }
        //String[] requestArray={"command","takeoff","flip r","right 25","flip l","left 25","land"};
        System.out.println("You are going on a Supersonic Mission....");


        for (String request: requestArray) {
            //List finalRequest = iterator.next();
            //request= requestArray[i];
            //String request = finalRequest.toString();
            switch (request) {
                case "command":
                    Command command = new Command();
                    command.doAction(communicator, request, udpClient);
                    break;
                case "takeoff":
                    Takeoff takeoff = new Takeoff();
                    takeoff.doAction(communicator, request, udpClient);
                    break;
                case "land":
                    Land land = new Land();
                    land.doAction(communicator, request, udpClient);
                    break;
                case "flip r":
                    Flip flip = new Flip();
                    flip.doAction(communicator, request, udpClient);
                    break;
                case "flip l":
                    Flip flip1 = new Flip();
                    flip1.doAction(communicator, request, udpClient);
                    break;
                case "right 25":
                    Right right = new Right();
                    right.doAction(communicator, request, udpClient);
                    break;
                case "left 25":
                    Left left = new Left();
                    left.doAction(communicator, request, udpClient);
                    break;

            }
        }
    }
    
   
}
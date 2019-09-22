import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class SimpleMission implements Mission {

    // public SimpleMission(String[] requestArray){
    //     this.requestArray=requestArray;
    // }

    public void fly(String ipAddress, int dronePort, DatagramSocket udpClient) throws Exception {
        Communicator communicator = new Communicator(ipAddress, dronePort);
        //String[] requestArray = new String[];
        //List<List<String>> records = new ArrayList<>();
        /*BufferedReader readCSV = new BufferedReader(new FileReader("SimpleMission.csv"));
        String line;


        while ((line = readCSV.readLine()) != null) {
            requestArray = line.split(",");
            //records.add(Arrays.asList(requestArray));
        }
        */
        ArrayList<String> requestArray= new ArrayList<>();
        File xmlFile = new File("SimpleMission.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbFactory.newDocumentBuilder();
        Document doc = builder.parse(xmlFile);
        NodeList nList= doc.getElementsByTagName("Command");


        for (int j=0; j<nList.getLength();j++){
            Node requestNode= nList.item(j);
            //requestArray[j]= requestNode.getTextContent();
            requestArray.add(requestNode.getTextContent());
        }
        for (int temp=0; temp<requestArray.size();temp++){
            System.out.println(requestArray.get(temp));
        }

        System.out.println("You are going on a Simple mission....");


        for (String request : requestArray) {
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
                case "left 25":
                    Left left = new Left();
                    left.doAction(communicator, request, udpClient);
                    break;
                case "right 25":
                    Right right = new Right();
                    right.doAction(communicator, request, udpClient);
                    break;


            }
        }
    }
}
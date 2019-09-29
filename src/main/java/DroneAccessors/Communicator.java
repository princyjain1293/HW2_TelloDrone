package DroneAccessors;

import java.net.*;
import java.nio.charset.StandardCharsets;

public class Communicator{
    InetAddress droneIPAddress;
    int dronePort;
    DatagramSocket udpClient;

    String[] requestArray;
    public Communicator (String ipAddress,int dronePort, DatagramSocket udpClient) throws Exception{
        this.droneIPAddress=InetAddress.getByName(ipAddress);
        this.dronePort=dronePort;
        this.udpClient= udpClient;

    }

    public void Send(String request) throws Exception{
        byte[] bytesToSend;
        // int maxRetries= 3;
        // while(maxRetries>0){
        bytesToSend=request.getBytes(StandardCharsets.UTF_8);
        DatagramPacket datagramPacket;

        datagramPacket = new DatagramPacket(bytesToSend, bytesToSend.length, droneIPAddress, dronePort);
        udpClient.send(datagramPacket);
        System.out.println("Sent " + request + " bytes to " + droneIPAddress.toString() + ":" + dronePort);
        //System.out.println("Remaining retries: " + maxRetries);
        //maxRetries--;
        //}
    }


    public String Receive () throws Exception{

        int maxRetries=3;
        byte[] bytesToReceive= new byte[64];
        DatagramPacket datagramPacket;
        String response=null;
        while(maxRetries>0){

            datagramPacket=new DatagramPacket(bytesToReceive,64);
            try{
                udpClient.receive(datagramPacket);
            }
            catch(SocketTimeoutException ex){
                datagramPacket=null;
            }
            if(datagramPacket!=null){
                System.out.println(String.format("Received %d bytes",datagramPacket.getLength()));
                response= new String(bytesToReceive,0,datagramPacket.getLength(), StandardCharsets.UTF_8);
                System.out.println("Received"+response );
                if(response.equals("ok")){
                    break;
                }
            }
            System.out.println("Remaining retries: " + maxRetries);
            maxRetries--;
        }
        if (response == null || !response.equals("ok"))
            return "garbage values";

        Thread.sleep(5000);
        return response;

    }

}
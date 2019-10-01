package DroneAccessors;

import java.net.*;
import java.nio.charset.StandardCharsets;

public class Communicator{
    InetAddress destIPAddress=null;
    int destPort=0;
    DatagramSocket socket;
    DatagramPacket datagramPacket;





    public Communicator(DatagramSocket udpClient){
        this.socket =udpClient;
    }
    public Communicator (String ipAddress, int destPort, DatagramSocket udpClient) throws Exception{
        this.destIPAddress =InetAddress.getByName(ipAddress);
        this.destPort = destPort;
        this.socket = udpClient;

    }

    public void Send(String request) throws Exception{
        byte[] bytesToSend;
        // int maxRetries= 3;
        // while(maxRetries>0){
        bytesToSend=request.getBytes(StandardCharsets.UTF_8);
        //DatagramPacket datagramPacket;

        datagramPacket = new DatagramPacket(bytesToSend, bytesToSend.length, destIPAddress, destPort);
        socket.send(datagramPacket);
        System.out.println("Sent " + request + " bytes to " + destIPAddress.toString() + ":" + destPort);
        //System.out.println("Remaining retries: " + maxRetries);
        //maxRetries--;
        //}

    }


    public String Receive () throws Exception{

            String reply = null;
            byte[] bytesReceived;
            bytesReceived = new byte[64];
            datagramPacket = new DatagramPacket(bytesReceived, 64);


            try {
                socket.receive(datagramPacket);
            }
            catch (SocketTimeoutException ex) {
                datagramPacket = null;
            }
            System.out.println(datagramPacket.getAddress());
            System.out.println(datagramPacket.getPort());

            if(destIPAddress==null){destIPAddress=datagramPacket.getAddress();}
            if(destPort==0){destPort=datagramPacket.getPort();}

            if (datagramPacket != null)
            {
                System.out.println(String.format("Received %d bytes", datagramPacket.getLength()));
                reply = new String(bytesReceived, 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
                System.out.println("Receive " + reply);
//              Thread.sleep(1000);
            }

            if (reply == null)
            {
                return "Nothing received";}
            else if(reply.equals("ok")) {
//              Thread.sleep(10000);
                return reply;
            }
            else{
                return reply;
            }

    }
    public InetAddress getDestIPAddress(){return destIPAddress;}
    public int getDestPort(){return destPort;}


}
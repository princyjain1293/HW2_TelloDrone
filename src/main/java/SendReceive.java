import java.util.Scanner;
import java.net.*;
import java.nio.charset.StandardCharsets;

class SendReceive{
    public static void main(String[] args) throws Exception{
        Scanner telloInput= new Scanner(System.in);

        //Read IP Address from User
        System.out.println("Enter the IP Address");
        String ipAddress= telloInput.next();
        InetAddress droneIPAddress= InetAddress.getByName(ipAddress);

        // Read Port Number from user
        System.out.println("Enter the port of the drone");
        int dronePort= telloInput.nextInt();

        // InetAddress droneAddress = InetAddress.getByName("127.0.0.1");
        // int dronePort = 8889;

        DatagramSocket udpClient=new DatagramSocket();
        udpClient.setSoTimeout(1000);

        System.out.println("Put Drone in Command mode");
        String request= "command";
        byte[] bytesToSend;
        byte[] bytesToReceive= new byte[64];
        DatagramPacket datagramPacket;
        String response = null;
        int maxRetries= 3;
        while(maxRetries>0){
            bytesToSend=request.getBytes(StandardCharsets.UTF_8);
            datagramPacket = new DatagramPacket(bytesToSend, bytesToSend.length, droneIPAddress, dronePort);
            udpClient.send(datagramPacket);
            System.out.println("Sent " + request + " bytes to " + droneIPAddress.toString() + ":" + dronePort);
            
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
            return;
    }
    

}